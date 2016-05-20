package com.team3.models;
import java.time.LocalDateTime;

/**
 * Created by Maxeonyx on 20/05/2016.
 */
public class Patient {

    public long id;
    public String name;
    public LocalDateTime dob;
    public Gender gender;


    public Patient(long id, String name, LocalDateTime dob, Gender gender) {
        this.id = id;
        this.name = name;
        this.dob = dob;
        this.gender = gender;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDateTime getDob() {
        return dob;
    }

    public void setDob(LocalDateTime dob) {
        this.dob = dob;
    }

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }
}