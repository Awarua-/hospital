package com.team3.loaders;

import com.team3.models.Ward;
import com.team3.parser.CSVParser;
import com.team3.parser.Parser;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class WardsLoader implements Loader<Ward> {

    private final String filePath = "./Data/wards.csv";
    private Parser parser;
    private List<Ward> wards;

    public WardsLoader() {
        wards = new ArrayList<>();
        parser = new CSVParser(filePath);
    }

    @Override
    public List<Ward> load() {
        try {
            List<String[]> items = parser.process();

            items.stream().forEach(i -> {
                int id = Integer.parseInt(i[0]);
                int capacity = Integer.parseInt(i[2]);
                wards.add(new Ward(id, i[1], capacity));
            });
        } catch (IOException e) {
            e.printStackTrace();
        }
        return wards;
    }
}
