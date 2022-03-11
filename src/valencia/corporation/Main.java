package valencia.corporation;
import models.Doctor;

public class Main {

    public static void main(String[] args) throws Exception {
        Doctor d = Doctor.find(2);
        System.out.println(d.fullName());
        System.out.println(d.speciality);
        Doctor x = new Doctor("Carlos", "Mireles", "Pediatra");
        x.save();
        System.out.println("Cuantos doctores hay: " + Doctor.all().size());
    }
}
