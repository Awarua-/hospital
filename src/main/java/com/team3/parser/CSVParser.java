package com.team3.parser;

import com.team3.models.Movement;
import com.team3.models.Patient;
import com.team3.models.Ward;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.NoSuchFileException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class CSVParser implements Parser {
	private List<Patient> patients;
	private List<Ward> wards;
	private List<Movement> moves;

    private String filePath;

	private final String patientsFile = "./Data/patients.csv";
	private final String wardsFile = "./Data/wards.csv";
	private final String movementsFile = "./Data/movements.csv";


    public CSVParser(String filePath) {
        this.filePath = filePath;
    }


    public List<String[]> process() throws IOException {
        return parse();
    }

    private List<String[]> parse() throws IOException {
        List<String[]> items = new ArrayList<>();
        BufferedReader reader = null;

        Path path = Paths.get(filePath);
        if (Files.exists(path)) {
            reader = Files.newBufferedReader(path);

            // ignore the first header line.
            reader.readLine();
            String line = reader.readLine();

            do {
                String[] properties = line.split(",");
                items.add(properties);
            } while ((line = reader.readLine()) != null);

            return items;
        }
        throw new NoSuchFileException("The file: " + filePath);
    }
}
