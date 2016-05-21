package com.team3.models;

import com.team3.Hospital;

import java.util.HashSet;
import java.util.Set;

public class Ward {

    private int id;
    private String name;
    private int capacity;
    private Set<Patient> patients;
    private Set<Patient> waitingList;
    private Hospital observer;

    public Ward(int id, String name, int capacity) {
        this.id = id;
        this.name = name;
        this.capacity = capacity;
        patients = new HashSet<>();
        waitingList = new HashSet<>();
    }

    public void attachObserver(Hospital observer) {
        this.observer = observer;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getCapacity() {
        return capacity;
    }

    public Set<Patient> getPatients() {
        return patients;
    }

    public void update() {

    }

    public boolean removePatient(Patient patient) {
        boolean removed = patients.remove(patient);
        if (removed) {
            observer.notifyObservers(id);
        }
        return removed;
    }

    public boolean addPatient(Patient patient) {
        if (patients.size() < capacity) {
            return patients.add(patient);
        }
        return false;
    }

    public boolean isAtCapacity() {
        return patients.size() >= capacity;
    }

    public boolean removePatientFromWaitingList(Patient patient) {
        return waitingList.remove(patient);
    }

    public boolean addPatientToWaitingList(Patient patient) {
        return waitingList.add(patient);
    }

    @Override
    public String toString() {
        return String.valueOf(id);
    }
}
