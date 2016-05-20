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
    private List<Ward> ward;
    private List<Movement> movements;
    private State[][] state;
    private List<Movement> [] movesByDay;
    List<Long> waitList[];
    int rejections;
    int deaths;

    public HashMap<LocalDate, HashMap<Long, ArrayList<Long>>> stateList;

    public HashMap<Long, ArrayList<Long>> currState;

    public Processor(ArrayList<Patient> patients, ArrayList<Ward> wards, List<Movement> movements) {
        this.patients = patients;
        this.ward = wards;
        this.movements = movements;
        for (int i = 0; i < 8; ++i)
            waitList[i] = new ArrayList<Long>();
        rejections = 0;
        deaths = 0;
    }




    static int dateToInt(LocalDate d) {
        return d.getDayOfYear();
    }

    public void shift(int day, int from, int to, int pid) {
        state[day][(int)from].numDischarges++;
        state[day][(int)to].numAdmissions++;
        state[day][(int) to].patients.add((long )pid);
        patients.get(pid).curWard = to;



        if (waitList[(int)from].size() > 0) {
            int pid2 = (int) (long) waitList[from].get(0);
            waitList[from].remove(0);
            shift(day, patients.get(pid2).curWard, from, pid2);
        }
    }

    public void process() throws FileNotFoundException {
        state = new State[367][8];
        for (int i = 0; i < 8; ++i) {
            state[0][i] = new State();
        }

        for (int day = 1; day <= 366; day++) {
            // Initialize next day as initially equivalent
            for (int i = 0; i < 8; ++i)
                state[day][i] = state[day-1][i].clone2();

            for (Movement m : movesByDay[day]) {
                long from = m.getFromWard();
                long to = m.getToWard();
                Long pid = m.getPatient();
                if (from == 0) {
                    if (to == 2) {
                        if (state[day][2].patients.size() >= ward.get(2).getCapacity()) {
                            deaths++;
                            continue;
                        }
                    }
                    else {
                        if (state[day][1].patients.size() >= ward.get(1).getCapacity()) {
                            rejections++;
                            continue;
                        }
                    }
                }
                else {
                    if (state[day][(int)to].patients.size() >= ward.get((int)to).getCapacity()) {
                        waitList[(int)to].add(pid);
                        continue;
                    }
                }

                // Shift


            }
        }

    }

    private void makeDays() {

        ArrayList<Movement>[] movesByDay = new ArrayList[366];
        for (int i = 0; i < movesByDay.length; i++) {
            movesByDay[i] = new ArrayList<Movement>();
        }

        for (Movement move : movements) {

            movesByDay[dateToInt(move.getDate())].add(move);

        }

    }
/*
    private HashMap<Long, ArrayList<Long>> copyWardStates(HashMap<Long, ArrayList<Long>> states) {

        HashMap<Long, ArrayList<Long>> newStates = new HashMap<>();

        for (long ward : states.keySet()) {
            ArrayList<Long> patients =  states.get(ward);
            newStates.put(ward, (ArrayList<Long>) patients.clone());

        }

    }*/



}
