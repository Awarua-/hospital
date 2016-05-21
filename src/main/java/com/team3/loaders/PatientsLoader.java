package com.team3.loaders;

import com.team3.models.Gender;
import com.team3.models.Patient;
import com.team3.parser.CSVParser;
import com.team3.parser.Parser;

import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;


public class PatientsLoader implements Loader<Patient> {

    private final String filePath = "./Data/patients.csv";
    private final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
    private Parser parser;
    private List<Patient> patients;

    public PatientsLoader() {
        parser = new CSVParser(filePath);
        patients = new ArrayList<>();
    }

    @Override
    public List<Patient> load() {
        try {
            List<String[]> items = parser.process();

            items.stream().forEach(i -> {
                int id = Integer.parseInt(i[0]);
                LocalDate dob = LocalDate.parse(i[2], formatter);
                Gender gender = Gender.fromString(i[3]);
                patients.add(new Patient(id, i[1], dob, gender));
            });
        } catch (IOException e) {
            e.printStackTrace();
        }
        return patients;
    }
}
