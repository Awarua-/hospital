package com.team3.models;

public class Waiting {
    private int currentWardId;
    private int wantedWardId;
    private int patientId;

    public Waiting(int currentWardId, int wantedWardId) {
        this.currentWardId = currentWardId;
        this.wantedWardId = wantedWardId;
    }

    public int getCurrentWardId() {
        return currentWardId;
    }

    public int getWantedWardId() {
        return wantedWardId;
    }
}
