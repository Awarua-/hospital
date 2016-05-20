package models;

import java.time.LocalDate;

/**
 * Created by Maxeonyx on 20/05/2016.
 */
public class Movement {

    private long id;
    private long patient;
    private long fromWard;
    private long toWard;
    private LocalDate date;

    public Movement(long id, long patient, long fromWard, long toWard, LocalDate date) {
        this.id = id;
        this.patient = patient;
        this.toWard = toWard;
        this.fromWard = fromWard;
        this.date = date;
    }

    public long getToWard() {
        return toWard;
    }

    public void setToWard(long toWard) {
        this.toWard = toWard;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public long getPatient() {
        return patient;
    }

    public void setPatient(long patient) {
        this.patient = patient;
    }

    public long getFromWard() {
        return fromWard;
    }

    public void setFromWard(long fromWard) {
        this.fromWard = fromWard;
    }
}
