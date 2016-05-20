package com.team3.models;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by Maxeonyx on 20/05/2016.
 */
public class State {
    public ArrayList<Long> patients;
    public int firstDeath;
    public int numDeaths;
    public int numAdmissions;
    public int numUniquePatients;
    public int numDischarges;

    public State() {
        firstDeath = -1;
        numDeaths = numAdmissions = numUniquePatients = numDischarges = 0;
    }

    public State clone2() {
        State r = new State();
        r.firstDeath = this.firstDeath;
        r.numDeaths = this.numDeaths;
        r.numAdmissions = this.numAdmissions;
        r.numUniquePatients = this.numUniquePatients;
        r.numDischarges = this.numDischarges;
        r.patients = (ArrayList<Long>)(this.patients.clone());
        return r;
    }
}
