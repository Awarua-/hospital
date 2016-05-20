package main;

import models.Movement;
import models.Patient;
import models.Ward;

import java.io.FileNotFoundException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Created by Maxeonyx on 20/05/2016.
 */
public class Processor {

    private ArrayList<Patient> patients;
    private ArrayList<Ward> wards;
    private List<Movement> movements;

    public HashMap<LocalDate, HashMap<Long, ArrayList<Long>>> stateList;

    public HashMap<Long, ArrayList<Long>> currState;

    public Processor(ArrayList<Patient> patients, ArrayList<Ward> wards, List<Movement> movements) {
        this.patients = patients;
        this.wards = wards;
        this.movements = movements;
    }


    public void process() throws FileNotFoundException {

        stateList = new HashMap<>();

        LocalDate currDate = LocalDate.MIN;

        HashMap<Long, ArrayList<Long>> currWardStates = new HashMap<>();

        for (Movement move : movements) {

        }

    }

    private HashMap<Long, ArrayList<Long>> copyWardStates(HashMap<Long, ArrayList<Long>> states) {

        HashMap<Long, ArrayList<Long>> newStates = new HashMap<>();

        for (long ward : states.keySet()) {
            ArrayList<Long> patients =  states.get(ward);
            newStates.put(ward, (ArrayList<Long>) patients.clone());

        }

    }



}
