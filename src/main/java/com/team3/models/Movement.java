package com.team3.models;
import java.time.LocalDate;

public class Movement {

    private int id;
    private int patientId;
    private int fromWard;
    private int toWard;
    private LocalDate date;

    public Movement(int id, int patientId, int fromWard, int toWard, LocalDate date) {
        this.id = id;
        this.patientId = patientId;
        this.fromWard = fromWard;
        this.toWard = toWard;
        this.date = date;
    }

    public int getToWard() {
        return toWard;
    }

    public int getFromWard() {
        return fromWard;
    }

    public int getId() {
        return id;
    }

    public LocalDate getDate() {
        return date;
    }

    public int getPatientId() {
        return patientId;
    }

    @Override
    public String toString() {
        return String.valueOf(id);
    }
}
