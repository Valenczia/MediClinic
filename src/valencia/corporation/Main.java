package valencia.corporation;
import models.Doctor;

public class Main {

    public static void main(String[] args) throws Exception {
        Doctor doctor = new Doctor("Carlos", "Mireles", "Pediatra");
        doctor.save();
        System.out.println(doctor.toString());
        // Doctor.all().get(0).delete();
        System.out.println("Cuantos doctores hay: " + Doctor.all().size());
    }
}
