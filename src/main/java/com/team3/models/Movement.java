package models;

import java.time.LocalDateTime;

/**
 * Created by Maxeonyx on 20/05/2016.
 */
public class Movement {

    private long id;
    private long patient;
    private long fromWard;
    private long toWard;
    private LocalDateTime date;

    public Movement(long id, long patient, long fromWard, long toWard, LocalDateTime date) {
        this.id = id;
        this.patient = patient;
        this.fromWard = fromWard;
        this.toWard = toWard;
        this.date = date;
    }

    public long getToWard() {
        return toWard;
    }

    public void setToWard(long toWard) {
        this.toWard = toWard;
    }
 
    public long getFromWard() {
        return fromWard;
    }

    public void setFromWard(long fromWard) {
        this.fromWard = fromWard;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public LocalDateTime getDate() {
        return date;
    }

    public void setDate(LocalDateTime date) {
        this.date = date;
    }

    public long getPatient() {
        return patient;
    }

    public void setPatient(long patient) {
        this.patient = patient;
    }
}
