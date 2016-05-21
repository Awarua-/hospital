package com.team3;


import com.team3.loaders.MovementsLoader;
import com.team3.loaders.PatientsLoader;
import com.team3.loaders.WardsLoader;
import com.team3.models.Movement;
import com.team3.models.Patient;
import com.team3.models.Waiting;
import com.team3.models.Ward;

import java.util.*;
import java.util.stream.Collectors;

public class Hospital {
    private List<Patient> deadPatients;
    private Map<Integer, Ward> wards;
    private Map<Integer, Patient> patients;
    private List<Movement> movements;
    private Map<Patient, Waiting> waitingList;

    public Hospital() {
        deadPatients = new ArrayList<>();
        patients = new PatientsLoader().load().stream().collect(Collectors.toMap(Patient::getId, p -> p));
        wards = new WardsLoader().load().stream().collect(
                Collectors.toMap(Ward::getId, w -> w)
        );
        movements = new MovementsLoader().load();
        waitingList = Collections.synchronizedMap(new LinkedHashMap<>());
        for (Map.Entry<Integer, Ward> ward: wards.entrySet()) {
            ward.getValue().attachObserver(this);
        }
    }

    public void notifyObservers(int wardId) {
        for (Iterator<Map.Entry<Patient, Waiting>> it = waitingList.entrySet().iterator(); it.hasNext();) {
            Map.Entry<Patient, Waiting> waitingEntry = it.next();
            if (waitingEntry.getValue().getWantedWardId() == wardId) {
                if (wards.get(wardId).addPatient(waitingEntry.getKey())) { //should always be true, but just in case java fails.
                    wards.get(wardId).removePatientFromWaitingList(waitingEntry.getKey());
                    it.remove();
                    wards.get(waitingEntry.getValue().getCurrentWardId()).removePatient(waitingEntry.getKey());
                    break;
                }
            }
        }
    }

    public void run() {
        for (Movement m : movements) {
            processTransaction(m);
        }
    }

    private void processTransaction(Movement movement) {
        // admissions
        Patient patient = patients.get(movement.getPatientId());
        Ward fromWard = wards.get(movement.getFromWard());
        Ward toWard = wards.get(movement.getToWard());

        if (movement.getFromWard() == 0) {
            if (toWard.isAtCapacity()) {
                // admitting patients,
                switch(movement.getToWard()) {
                    case 1:
                        // waiting room is full so turn away
                        break;
                    case 2:
                        // patient died
                        deadPatients.add(patient);
                        patients.remove(movement.getPatientId());
                        break;
                    default:
                        System.err.println("This could be a problem");
                        break;
                }
            }
            else {
                toWard.addPatient(patient);
            }
        }

        // Discharge person
        else if (movement.getToWard() == -1) {
            // discharge from ward
            fromWard.removePatient(patient);

            // remove from waiting list if present.
            removePatientFromWaitingLists(patient);

        }

        // Other movement between wards
        else {
            // If the ward is not full, move person.
            if (!toWard.isAtCapacity()) {
                toWard.addPatient(patient);
                fromWard.removePatient(patient);

                // If patient was on the waiting list but got moved to another ward that is not full
                removePatientFromWaitingLists(patient);
            }
            // transfer to a full emergency ward -> person dies.
            else if (movement.getToWard() == 2) {
                // remove from waiting list
                removePatientFromWaitingLists(patient);

                // patient dies
                fromWard.removePatient(patient);
                deadPatients.add(patient);
                patients.remove(movement.getPatientId());
            }
            else {
                // If patient already has a waiting list.
                removePatientFromWaitingLists(patient);

                toWard.addPatientToWaitingList(patient);
                waitingList.put(patient, new Waiting(movement.getFromWard(), movement.getToWard()));

            }
        }
    }

    private void removePatientFromWaitingLists(Patient patient) {
        Waiting waiting = waitingList.get(patient);
        if (waiting != null) {
            wards.get(waiting.getWantedWardId()).removePatientFromWaitingList(patient);
            waitingList.remove(patient);
        }
    }

    public int getNumberOfDeadPatients() {
        return deadPatients.size();
    }
}
