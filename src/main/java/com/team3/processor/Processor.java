package com.team3.processor;

import com.team3.models.Movement;
import com.team3.models.Patient;
import com.team3.models.State;
import com.team3.models.Ward;

import java.io.FileNotFoundException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Created by Maxeonyx on 20/05/2016.
 */
public class Processor {

    private List<Patient> patients;
    private List<Ward> wards;
    private List<Movement> movements;
    private State[][] states;
    private List<Movement> [] movesByDay;

    public HashMap<LocalDate, HashMap<Long, ArrayList<Long>>> stateList;

    public HashMap<Long, ArrayList<Long>> currState;

    public Processor(ArrayList<Patient> patients, ArrayList<Ward> wards, List<Movement> movements) {
        this.patients = patients;
        this.wards = wards;
        this.movements = movements;
    }




    static int dateToInt(LocalDate d) {
        return d.getDayOfYear();
    }

    public void process() throws FileNotFoundException {
        state = new State[367][8];
        for (int j = 0; j < )
        for (int i = 0; i < 8; ++i) {
            state[0][i] = new State();
        }

        for ()

        int day = 1;
        for (Movement m : move) {

        }


        for (int day = 1; day <= 366; day++) {
            // Initialize next day as initially equivalent
            for (int i = 0; i < 8; ++i)
                state[day][i] = state[day-1][i].clone();

            while (dateToInt(move[mi].getDate()) < day) {

            }

            if (dateToInt(move[i].getDate()) == day) {

            }
        }

        LocalDate currDate = LocalDate.MIN;

        for (Movement move : movements) {



        }

    }

    private void makeDays() {

        ArrayList<Movement>[366] movesByDay = new ArrayList<Movement>[366];
        for (int i = 0; i < movesByDay.length; i++) {
            movesByDay[i] = new ArrayList<Movement>();
        }

        for (Movement move : movements) {

            movesByDay[dateToInt(move.getDate())].add(move);

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
