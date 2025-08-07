package ui;

import Classes.*;
import Services.*;
import Logging.Logger;

import java.util.List;
import java.util.Scanner;

public class Menu {
    private final UserService userService;
    private final MembershipService membershipService;
    private final GymMerchService gymMerchService;
    private final WorkoutClassService workoutClassService;

    public Menu(UserService us, MembershipService ms, GymMerchService gs, WorkoutClassService wcs) {
        this.userService = us;
        this.membershipService = ms;
        this.gymMerchService = gs;
        this.workoutClassService = wcs;
    }

    public void displayMenu(User currentUser) {
        Scanner scanner = new Scanner(System.in);
        String role = currentUser.getRole();

        boolean running = true;
        while (running) {
            System.out.println("\nWelcome " + currentUser.getName() + " (" + role + ")");
            System.out.println("Select an option:");

            switch (role) {
                case "Admin" -> {
                    System.out.println("1. View all users");
                    System.out.println("2. View all memberships");
                    System.out.println("3. View all merchandise stock");
                    System.out.println("0. Logout");
                    switch (scanner.nextLine()) {
                        case "1" -> userService.printAllUsers(); // This method must exist in your UserService
                        case "2" -> membershipService.getAllMemberships().forEach(System.out::println);
                        case "3" -> gymMerchService.printStockReport();
                        case "0" -> running = false;
                        default -> System.out.println("Invalid choice.");
                    }
                }

                case "Trainer" -> {
                    System.out.println("1. Add workout class");
                    System.out.println("2. Update workout class");
                    System.out.println("3. Delete workout class");
                    System.out.println("4. View all merchandise");
                    System.out.println("0. Logout");
                    switch (scanner.nextLine()) {
                        case "1" -> {
                            System.out.print("Class name: ");
                            String name = scanner.nextLine();
                            System.out.print("Schedule: ");
                            String schedule = scanner.nextLine();
                            System.out.print("Trainer name: ");
                            String trainerName = currentUser.getName();
                            WorkoutClass wc = new WorkoutClass(0, name, schedule, trainerName);
                            workoutClassService.addWorkoutClass(wc);
                        }
                        case "2" -> {
                            System.out.print("Class ID to update: ");
                            int id = Integer.parseInt(scanner.nextLine());
                            System.out.print("New name: ");
                            String newName = scanner.nextLine();
                            System.out.print("New schedule: ");
                            String newSchedule = scanner.nextLine();
                            workoutClassService.updateWorkoutClass(id, newName, newSchedule, currentUser.getName());
                        }
                        case "3" -> {
                            System.out.print("Class ID to delete: ");
                            int id = Integer.parseInt(scanner.nextLine());
                            workoutClassService.deleteWorkoutClass(id);
                        }
                        case "4" -> gymMerchService.printStockReport();
                        case "0" -> running = false;
                        default -> System.out.println("Invalid choice.");
                    }
                }

                case "Member" -> {
                    System.out.println("1. View all workout classes");
                    System.out.println("2. Purchase membership");
                    System.out.println("3. View all merchandise");
                    System.out.println("0. Logout");
                    switch (scanner.nextLine()) {
                        case "1" -> workoutClassService.getAllWorkoutClasses().forEach(System.out::println);
                        case "2" -> {
                            System.out.print("Membership ID: ");
                            int id = Integer.parseInt(scanner.nextLine());
                            System.out.print("Member ID: ");
                            int memberId = Integer.parseInt(scanner.nextLine());
                            System.out.print("Type: ");
                            String type = scanner.nextLine();
                            System.out.print("Start Date: ");
                            String start = scanner.nextLine();
                            System.out.print("End Date: ");
                            String end = scanner.nextLine();
                            Membership m = new Membership(id, memberId, type, start, end);
                            membershipService.createMembership(m);
                        }
                        case "3" -> gymMerchService.printStockReport();
                        case "0" -> running = false;
                        default -> System.out.println("Invalid choice.");
                    }
                }

                default -> {
                    System.out.println("Unknown role.");
                    running = false;
                }
            }
        }
    }
}
