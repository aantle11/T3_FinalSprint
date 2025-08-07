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
    }

    public Menu(UserService us, MembershipService ms, GymMerchService gs, WorkoutClassService wcs) {
        this.userService = us;
        this.membershipService = ms;
        this.gymMerchService = gs;
        this.workoutClassService = wcs;
    }

    public void displayMenu(User currentUser) {
        Scanner scanner = new Scanner(System.in);
        String role = currentUser.getRole();
        }

        boolean running = true;
        while (running) {
            System.out.println("\nWelcome " + currentUser.getUserName() + " (" + role + ")");
            System.out.println("Select an option:");
        }

            switch (role) {
                case "Admin" -> {
                    System.out.println("1. View all users");
                    System.out.println("2. View all memberships");
                    System.out.println("3. View total revenue");
                    System.out.println("4. View merchandise stock");
                    System.out.println("5. Add merchandise");
                    System.out.println("6. View total merch value");
                    System.out.println("0. Logout");
                    switch (scanner.nextLine()) {
                        case "1" -> userService.printAllUsers();
                        case "2" -> membershipService.getAllMemberships().forEach(System.out::println);
                        case "3" -> System.out.println("Total revenue: $" + membershipService.getAllMemberships()
                                .stream().mapToDouble(Membership::getCost).sum());
                        case "4" -> gymMerchService.printStockReport();
                        case "5" -> {
                            System.out.print("Item name: ");
                            String name = scanner.nextLine();
                            System.out.print("Type: ");
                            String type = scanner.nextLine();
                            System.out.print("Price: ");
                            double price = Double.parseDouble(scanner.nextLine());
                            System.out.print("Quantity: ");
                            int qty = Integer.parseInt(scanner.nextLine());
                            GymMerch merch = new GymMerch(name, type, price, qty);
                            gymMerchService.addMerch(merch);
                        }
                        case "6" -> System.out.println("Total value: $" + gymMerchService.getTotalMerchValue());
                        case "0" -> running = false;
                        default -> System.out.println("Invalid choice.");
                    }
                }
            }
                case "Trainer" -> {
                    System.out.println("1. Add workout class");
                    System.out.println("2. Update workout class");
                    System.out.println("3. Delete workout class");
                    System.out.println("4. View my classes");
                    System.out.println("5. View all merchandise");
                    System.out.println("6. Purchase membership");
                    System.out.println("0. Logout");
                    switch (scanner.nextLine()) {
                        case "1" -> {
                            System.out.print("Class type: ");
                            String type = scanner.nextLine();
                            System.out.print("Description: ");
                            String desc = scanner.nextLine();
                            WorkoutClass wc = new WorkoutClass(0, type, desc, currentUser.getUserId());
                            workoutClassService.addWorkoutClass(wc);
                        }
                        case "2" -> {
                            System.out.print("Class ID: ");
                            int id = Integer.parseInt(scanner.nextLine());
                            System.out.print("New type: ");
                            String newType = scanner.nextLine();
                            System.out.print("New description: ");
                            String newDesc = scanner.nextLine();
                            workoutClassService.updateWorkoutClass(id, newType, newDesc);
                        }
                        case "3" -> {
                            System.out.print("Class ID to delete: ");
                            int id = Integer.parseInt(scanner.nextLine());
                            workoutClassService.deleteWorkoutClass(id);
                        }
                        case "4" -> workoutClassService.getClassesByTrainer(currentUser).forEach(System.out::println);
                        case "5" -> gymMerchService.printStockReport();
                        case "6" -> {
                            System.out.print("Membership type: ");
                            String type = scanner.nextLine();
                            System.out.print("Description: ");
                            String desc = scanner.nextLine();
                            System.out.print("Cost: ");
                            double cost = Double.parseDouble(scanner.nextLine());
                            Membership m = new Membership(type, desc, cost);
                            membershipService.createMembership(currentUser, m);
                        }
                        case "0" -> running = false;
                        default -> System.out.println("Invalid choice.");
                    }
                }
                case "Member" -> {
                    System.out.println("1. View workout classes");
                    System.out.println("2. View my membership expenses");
                    System.out.println("3. Purchase membership");
                    System.out.println("4. View merchandise");
                }