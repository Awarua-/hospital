package com.team3.models;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by Maxeonyx on 20/05/2016.
 */
public class State {
    ArrayList<Long> patients;
    int firstDeath;
    int numDeaths;
    int numEntries;
    int numUniquePatients;
    int numDischarged;

    State() {
        firstDeath = -1;
        numDeaths = numEntries = numUniquePatients = numDischarged = 0;
    }
}
