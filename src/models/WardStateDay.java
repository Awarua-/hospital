package models;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by Maxeonyx on 20/05/2016.
 */
public class WardStateDay {

    private HashMap<Long, ArrayList<Long>> wards;

    public WardStateDay(ArrayList<Long> patients, HashMap<Long, ArrayList<Long>> wards) {
        this.wards = wards;
    }

    public ArrayList<Long> getPatients(long ward) {
        return wards.get(ward);
    }

    public HashMap<Long, ArrayList<Long>> getWards() {
        return wards;
    }

    public void setWards(HashMap<Long, ArrayList<Long>> wards) {
        this.wards = wards;
    }

    public void addWard(Long ward, ArrayList<Long> patients) {

        wards.put(ward, patients);

    }

}
