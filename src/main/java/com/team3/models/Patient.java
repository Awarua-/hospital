package com.team3.models;

import java.time.LocalDate;

public class Patient {

    private int id;
    private String name;
    private LocalDate dob;
    private Gender gender;

    public Patient(int id, String name, LocalDate dob, Gender gender) {
        this.id = id;
        this.name = name;
        this.dob = dob;
        this.gender = gender;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public LocalDate getDob() {
        return dob;
    }

    public Gender getGender() {
        return gender;
    }

    @Override
    public String toString() {
        return String.valueOf(id);
    }
}