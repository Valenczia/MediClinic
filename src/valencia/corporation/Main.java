package valencia.corporation;
import java.util.Scanner;
import lib.Login;
import lib.Menu;
import models.Doctor;
import models.User;

public class Main {
    public static void main(String[] args) throws Exception {
        Menu.printWelcome();
        Login.authenticate();
        Menu.main();
    }
}
