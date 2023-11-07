package com.example.Vaccination;
import java.util.Scanner;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class VaccinationApplication {
    static Scanner in = new Scanner(System.in);

    public static void setDetails(String person, TimeAndLocation timeAndLocation, User user) {
        System.out.println("Please enter " + person + " details:");
        in.nextLine();
        System.out.print("Name: ");
        String name = in.nextLine();
        System.out.print("Age: ");
        int age = in.nextInt();
        in.nextLine();
        System.out.print("Appointment date (YYYY-MM-DD):");
        String date = in.nextLine();
        System.out.print("Appointment time (HH:MM AM/PM):");
        String time = in.nextLine();
        System.out.print("Appointment location: ");
        String city = in.nextLine();
        timeAndLocation.setDetails(time, city, date);
        user.setUserDetails(name, age, timeAndLocation);
        user.setAppointment();
    }

    public static void main(String[] args) {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("ApplicationContext.xml");
        while (true) {
            System.out.println("Welcome to the Vaccination Application\n" +
                    "Please choose your vaccine preference:");
            System.out.println("1. Covid\n2. Polio\n3. Typhoid\n4. Exit");
            int vaccine = in.nextInt();

            switch (vaccine) {
                case 1:
                    processVaccine(context, "Covid");
                    break;
                case 2:
                    processVaccine(context, "Polio");
                    break;
                case 3:
                    processVaccine(context, "Typhoid");
                    break;
                case 4:
                    System.out.println("Exiting the Vaccination Application. Goodbye!");
                    return;
                default:
                    System.out.println("Invalid choice. Please select a valid option.");
                    break;
            }
        }
    }

    private static void processVaccine(ClassPathXmlApplicationContext context, String vaccineName) {
        Vaccine vaccineType = (Vaccine) context.getBean(vaccineName.toLowerCase());
        System.out.println("Whom do you want to vaccinate");
        System.out.println("1. Father\n" +
                "2. Mother\n" +
                "3. Self\n" +
                "4. Spouse\n" +
                "5. Exit");
        int person = in.nextInt();
        in.nextLine(); // Consume the newline character

        if (person >= 1 && person <= 4) {
            String personRelation = String.format("%s", personRelation(person));
            User user = (User) context.getBean(personRelation);
            TimeAndLocation timeAndLocation = (TimeAndLocation) context.getBean("timeAndLocation");
            setDetails(personRelation, timeAndLocation, user);
        } else if (person == 5) {
            return; // Exit the current vaccine choice
        } else {
            System.out.println("Invalid choice. Please select a valid option.");
        }
    }

    private static String personRelation(int choice) {
        switch (choice) {
            case 1:
                return "father";
            case 2:
                return "mother";
            case 3:
                return "self";
            case 4:
                return "spouse";
            default:
                return "";
        }
    }
}
