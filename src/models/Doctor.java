package models;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;
import java.io.IOException;
import java.util.Scanner;

public class Doctor {
    private static List<Doctor> all = new ArrayList<Doctor>();;

    public int id;
    private boolean persisted;
    public String firstName;
    public String surname;
    public String speciality;

    /*
    static {
        try {
            reload();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    */

    public Doctor() {}

    public Doctor(String firstName, String surname, String speciality) {
        this.persisted = false;
        this.firstName = firstName;
        this.surname = surname;
        this.speciality = speciality;
    }

    public Doctor(int id, String firstName, String surname, String speciality) {
        this.id = id;
        this.firstName = firstName;
        this.surname = surname;
        this.speciality = speciality;
        this.persisted = true;
    }

    public String fullName() {
        return firstName + " " + surname;
    }

    public static Doctor find(int id) throws Exception {
        //id.toString()
        for (int i = 0; i < all().size(); i++) {
            Doctor instance = all().get(i);
            if (instance.id == id) {
                return instance;
            }
        }
        return new Doctor();
    }

    private static void reload() throws Exception {
        String line = "";
        String delimiter = ",";
        File file = new File("src/db/doctors.csv");
        BufferedReader br = new BufferedReader(new FileReader(file.getAbsolutePath()));
        all.clear();
        while ((line = br.readLine()) != null) {
            String[] row = line.split(delimiter);
            Doctor d = new Doctor(Integer.parseInt(row[0]), row[1], row[2], row[3]);
            all.add(d);
        }
    }

    public static List<Doctor> all() throws Exception {
        reload();
        return all;
    }

    public void save() throws Exception {

    }
}
