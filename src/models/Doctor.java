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

    private int id;
    private String firstName;
    private String surname;
    private String speciality;

    public Doctor(String firstName, String surname, String speciality) {
        this.id = 1;
        this.firstName = firstName;
        this.surname = surname;
        this.speciality = speciality;
    }

    public String fullName() {
        return firstName + " " + surname;
    }
    
    public static void all() throws Exception {
        String line = "";
        String delimiter = ",";
        File file = new File("src/db/doctors.csv");
        BufferedReader br = new BufferedReader(new FileReader(file.getAbsolutePath()));
        while ((line = br.readLine()) != null) {
            String[] row = line.split(delimiter);
            Doctor d = new Doctor(row[1], row[2], row[3]);
            all.add(d);
        }
    } 

    public void saveToDb() throws Exception {
    }
}
