package valencia.corporation;
import models.Doctor;

public class Main {

    public static void main(String[] args) throws Exception {
        Doctor d = Doctor.find(2);
        Doctor x = new Doctor("Christopher", "Robbin", "Urólogo");
        x.save();
    }
}
