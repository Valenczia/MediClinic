package valencia.corporation;
import models.Doctor;

public class Main {

    public static void main(String[] args) throws Exception {
	    Doctor d = new Doctor("Daniel", "Ávila", "Ginecólogo");
        d.all();
    }
}
