package com.team3.loaders;

import com.team3.models.Movement;
import com.team3.parser.CSVParser;

import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;


public class MovementsLoader implements Loader<Movement> {

    private final String filePath = "./Data/movements.csv";
    private final DateTimeFormatter formatter = DateTimeFormatter.ISO_LOCAL_DATE;
    private CSVParser parser;
    private List<Movement> movements;

    public MovementsLoader() {
        movements = new ArrayList<>();
        parser = new CSVParser(filePath);
    }

    @Override
    public List<Movement> load() {
        try {
            List<String[]> items = parser.process();

            items.stream().forEach(i -> {
                int id = Integer.parseInt(i[0]);
                int patient = Integer.parseInt(i[1]);
                LocalDate date = LocalDate.parse(i[4], formatter);

                // Admitting ward id = 0
                // Discharging ward id = 1
                int fromWard;
                int toWard;

                if (i[2].equals("admitting")) {
                    fromWard = 0;
                }
                else {
                    fromWard = Integer.parseInt(i[2]);
                }

                if (i[3].equals("discharging")) {
                    toWard = -1;
                }
                else {
                    toWard = Integer.parseInt(i[3]);
                }

                movements.add(new Movement(id, patient, fromWard, toWard, date));
            });
        } catch (IOException e) {
            e.printStackTrace();
        }
        return movements;
    }
}
