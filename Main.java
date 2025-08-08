import Classes.User;
import Services.UserService;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        UserService userService = new UserService();

        System.out.println("=== Gym Management System ===");

        User currentUser = null;
        while (currentUser == null) {
            System.out.println("\n1. Register");
            System.out.println("2. Login");
            System.out.println("3. Exit");
            System.out.print("Choose an option: ");
            String choice = scanner.nextLine();

            switch (choice) {
                case "1":
                    System.out.print("Enter name: ");
                    String name = scanner.nextLine();
                    System.out.print("Enter email: ");
                    String email = scanner.nextLine();
                    System.out.print("Enter password: ");
                    String password = scanner.nextLine();
                    System.out.print("Enter role (Admin / Trainer / Member): ");
                    String role = scanner.nextLine();

                    if (userService.register(name, email, password, role)) {
                        System.out.println("Registration successful! You can now login.");
                    } else {
                        System.out.println("Registration failed.");
                    }
                    break;

                case "2":
                    System.out.print("Enter email: ");
                    email = scanner.nextLine();
                    System.out.print("Enter password: ");
                    password = scanner.nextLine();

                    currentUser = userService.login(email, password);
                    break;

                case "3":
                    System.out.println("Goodbye!");
                    System.exit(0);

                default:
                    System.out.println("Invalid choice.");
            }
        }

        // Role-based menu
        switch (currentUser.getRole().toLowerCase()) {
            case "admin":
                showAdminMenu(scanner);
                break;
            case "trainer":
                showTrainerMenu(scanner);
                break;
            case "member":
                showMemberMenu(scanner);
                break;
            default:
                System.out.println("Unknown role. Access denied.");
        }
    }

    private static void showAdminMenu(Scanner scanner) {
        while (true) {
            System.out.println("\n=== Admin Menu ===");
            System.out.println("1. View Users (coming soon)");
            System.out.println("2. View Revenue (coming soon)");
            System.out.println("3. Logout");
            System.out.print("Choose an option: ");
            String option = scanner.nextLine();

            if (option.equals("3")) {
                System.out.println("Logging out...");
                break;
            }
        }
    }

    private static void showTrainerMenu(Scanner scanner) {
        while (true) {
            System.out.println("\n=== Trainer Menu ===");
            System.out.println("1. View Classes (coming soon)");
            System.out.println("2. Logout");
            System.out.print("Choose an option: ");
            String option = scanner.nextLine();

            if (option.equals("2")) {
                System.out.println("Logging out...");
                break;
            }
        }
    }

    private static void showMemberMenu(Scanner scanner) {
        while (true) {
            System.out.println("\n=== Member Menu ===");
            System.out.println("1. View Available Classes (coming soon)");
            System.out.println("2. Logout");
            System.out.print("Choose an option: ");
            String option = scanner.nextLine();

            if (option.equals("2")) {
                System.out.println("Logging out...");
                break;
            }
        }
        
    }
}
