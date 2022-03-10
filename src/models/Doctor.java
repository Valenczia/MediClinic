package models;

public class Doctor {
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
}
