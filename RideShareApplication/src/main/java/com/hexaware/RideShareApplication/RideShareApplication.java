package com.hexaware.RideShareApplication;
import java.util.Scanner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@SpringBootApplication(exclude= {DataSourceAutoConfiguration.class})
public class RideShareApplication {

    private static String username;
    private static String email;
    private static String phoneNumber;
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        SpringApplication.run(RideShareApplication.class, args);
        boolean exit = false;

        while (!exit) {
            System.out.println("\nRideShare Application - CLI Interface");
            System.out.println("---------------------------------------");
            System.out.println("1. Register or Login");
            System.out.println("2. Profile");
            System.out.println("3. Find a Ride");
            System.out.println("4. Offer a Ride");
            System.out.println("5. Ride History");
            System.out.println("6. Notifications");
            System.out.println("Type 'exit' to quit.");
            System.out.print("Enter command: ");
            String command = scanner.nextLine();

            switch (command.toLowerCase()) {
                case "1":
                case "register":
                case "login":
                    registerOrLogin();
                    break;
                case "2":
                case "profile":
                    viewProfile();
                    break;
                case "3":
                case "find a ride":
                    findRide();
                    break;
                case "4":
                case "offer a ride":
                    offerRide();
                    break;
                case "5":
                case "ride history":
                    viewRideHistory();
                    break;
                case "6":
                case "notifications":
                    viewNotifications();
                    break;
                case "exit":
                    exit = true;
                    break;
                default:
                    System.out.println("Invalid command. Please try again.");
            }
        }
        scanner.close();
        System.out.println("Exiting the RideShare Application. Goodbye!");
    }

    private static void registerOrLogin() {
        System.out.println("\nRegister/Login - Enter your details below.");
        System.out.print("Username: ");
        username = scanner.nextLine();
        System.out.print("Email: ");
        email = scanner.nextLine();
        System.out.print("Phone Number: ");
        phoneNumber = scanner.nextLine();
        System.out.println("Registration/Login successful for user: " + username);
    }

    private static void viewProfile() {
        System.out.println("\nProfile Details");
        System.out.println("---------------------------------");
        System.out.println("Username : " + username);
        System.out.println("Email : " + email);
        System.out.println("Phone Number : " + phoneNumber);
        System.out.print("Would you like to update your profile? (yes/no): ");
        String response = scanner.nextLine();
        if (response.equalsIgnoreCase("yes")) {
            System.out.print("Enter new Email: ");
            email = scanner.nextLine();
            System.out.print("Enter new Phone Number: ");
            phoneNumber = scanner.nextLine();
            System.out.println("Profile updated successfully.");
        }
    }

    private static void findRide() {
        System.out.println("\nFind a Ride");
        System.out.print("Enter starting location: ");
        String startLocation = scanner.nextLine();
        System.out.print("Enter destination: ");
        String destination = scanner.nextLine();
        System.out.print("Enter preferred time: ");
        String time = scanner.nextLine();

        // Simulating ride matching
        System.out.println("\nSearching for rides...");
        System.out.println("Match Found: Driver - John, Route: " + startLocation + " to " + destination + " at " + time);
        System.out.print("Would you like to book this ride? (yes/no): ");
        String response = scanner.nextLine();
        if (response.equalsIgnoreCase("yes")) {
            System.out.println("Ride booked successfully with Driver John!");
        } else {
            System.out.println("No ride booked.");
        }
    }

    private static void offerRide() {
        System.out.println("\nOffer a Ride");
        System.out.print("Enter starting location: ");
        String startLocation = scanner.nextLine();
        System.out.print("Enter destination: ");
        String destination = scanner.nextLine();
        System.out.print("Enter available time: ");
        String time = scanner.nextLine();
        System.out.print("Enter number of seats available: ");
        int seats = scanner.nextInt();
        scanner.nextLine(); // Consume newline

        System.out.println("Ride offered successfully from " + startLocation + " to " + destination + " at " + time + " with " + seats + " seats available.");
    }

    private static void viewRideHistory() {
        System.out.println("\nRide History for " + username);
        System.out.println("---------------------------------------");
        System.out.println("1. Ride with Driver: John, Route: A to B, Status: Completed.");
        System.out.println("2. Ride with Driver: Sarah, Route: C to D, Status: Cancelled.");
        System.out.println("View your past rides for more details.");
    }

    private static void viewNotifications() {
        System.out.println("\nNotifications");
        System.out.println("---------------------------------------");
        System.out.println("1. Your ride with John is confirmed.");
        System.out.println("2. Ride with Sarah has been cancelled.");
        System.out.println("3. New ride offers available for your route!");
    }
}
