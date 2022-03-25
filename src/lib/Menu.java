package lib;

import java.util.Scanner;

import models.Doctor;
import models.Patient;

public class Menu {
  private static String ask(String text) {
    Scanner inputReader = new Scanner(System.in);
    System.out.print(text);
    return inputReader.nextLine();
  }

  private static String askln(String text) {
    Scanner inputReader = new Scanner(System.in);
    System.out.println(text);
    return inputReader.nextLine();
  }

  public static void printWelcome() {
    System.out.println("\n------------------");
    System.out.println("MediClinic v1.0");
    System.out.println("------------------\n");
  }

  public static void main() throws Exception {
    System.out.println("1. Doctores");
    System.out.println("2. Pacientes");
    System.out.println("3. Citas");
    String select = ask("\nSeleccione una opción: ");
    if (select.equals("1")) {
      printCrud("doctor");
    } else if (select.equals("2")) {
      printCrud("patient");
    }
    main();
  }
  
  private static void printCrud(String model) throws Exception {
    System.out.println("\n1. Listado");
    System.out.println("2. Buscar");
    System.out.println("3. Agregar");
    System.out.println("4. Editar");
    System.out.println("5. Eliminar");
    String select = ask("\nSeleccione una opción: ");
    if (select.equals("1")) {
      list(model);
    } else if (select.equals("2")) {
      find(model);
    } else if (select.equals("3")) {
      create(model);
    } else if (select.equals("5")) {
      delete(model);
    }
  }

  private static void list(String model) throws Exception {
    if (model.equals("doctor")) {
      System.out.println("\n----------------------");
      Doctor.all().forEach((doctor) -> {
        System.out.println(doctor.toString());
        System.out.println("----------------------");
      });
    } else if (model.equals("patient")) {
      System.out.println("\n----------------------");
      Patient.all().forEach((patient) -> {
        System.out.println(patient.toString());
        System.out.println("----------------------");
      });
    }
    System.out.println("");
  }

  private static void create(String model) throws Exception {
    String firstName, surname, speciality;
    if (model.equals("doctor")) {
      firstName = ask("Nombre: ");
      surname = ask("Apellido: ");
      speciality = ask("Especialidad: ");
      Doctor doctor = new Doctor(firstName, surname, speciality);
      doctor.save();
      System.out.println("\nSe creo satisfactoriamente el doctor:");
      System.out.println(doctor.toString() + "\n");
    } else if (model.equals("patient")) {
      firstName = ask("Nombre: ");
      surname = ask("Apellido: ");
      Patient patient = new Patient(firstName, surname);
      patient.save();
      System.out.println("\nSe creo satisfactoriamente el paciente:");
      System.out.println(patient.toString() + "\n");
    }
  }

  private static void delete(String model) throws Exception {
    if (model.equals("doctor")) {
      String id = ask("id: ");
      Doctor doctor = Doctor.find(Integer.parseInt(id));
      doctor.delete();
      System.out.println("\nSe creo satisfactoriamente el doctor:");
      System.out.println(doctor.toString() + "\n");
    } else if (model.equals("patient")) {
      String id = ask("id: ");
      Patient patient = Patient.find(Integer.parseInt(id));
      patient.delete();
      System.out.println("\nSe creo satisfactoriamente el paciente:");
      System.out.println(patient.toString() + "\n");
    }
  }

  private static void find(String model) throws Exception {
    Integer id = Integer.parseInt(ask("id: "));
    if (model.equals("doctor")) {
      Doctor doctor = Doctor.find(id);
      System.out.println(doctor.toString() + "\n");
    } else if (model.equals("patient")) {
      Patient patient = Patient.find(id);
      System.out.println(patient.toString() + "\n");
    }
  }
}
