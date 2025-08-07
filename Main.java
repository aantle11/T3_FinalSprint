import Classes.*;
import Services.*;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        GymMerchService merchService = new GymMerchService();
        WorkoutClassService classService = new WorkoutClassService();
        MembershipService membershipService = new MembershipService();

        boolean running = true;
        while (running) {
            System.out.println("\n=== Gym Management System ===");
            System.out.println("1. Add Gym Merchandise");
            System.out.println("2. View Merchandise & Stock Report");
            System.out.println("3. View Total Merchandise Value");
            System.out.println("4. Add Workout Class");
            System.out.println("5. View All Classes");
            System.out.println("6. Add Membership");
            System.out.println("7. View All Memberships");
            System.out.println("8. View Membership Revenue");
            System.out.println("9. Exit");
            System.out.print("Choose an option: ");

            String choice = scanner.nextLine();

            switch (choice) {
                case "1" -> {
                    System.out.print("Enter merch name: ");
                    String name = scanner.nextLine();
                    System.out.print("Enter price: ");
                    double price = Double.parseDouble(scanner.nextLine());
                    System.out.print("Enter stock: ");
                    int stock = Integer.parseInt(scanner.nextLine());
                    GymMerch merch = new GymMerch(0, name, price, stock);
                    merchService.addMerch(merch);
                }
                case "2" -> {
                    merchService.printStockReport();
                }
                case "3" -> {
                    merchService.getTotalMerchValue();
                }
                case "4" -> {
                    System.out.print("Enter class name: ");
                    String className = scanner.nextLine();
                    System.out.print("Enter schedule: ");
                    String schedule = scanner.nextLine();
                    System.out.print("Enter trainer name: ");
                    String trainerName = scanner.nextLine();
                    WorkoutClass wc = new WorkoutClass(0, className, schedule, trainerName);
                    classService.addWorkoutClass(wc);
                }
                case "5" -> {
                    for (WorkoutClass wc : classService.getAllClasses()) {
                        System.out.println(wc);
                    }
                }
                case "6" -> {
                    System.out.print("Enter membership ID: ");
                    int id = Integer.parseInt(scanner.nextLine());
                    System.out.print("Enter member ID: ");
                    int memberId = Integer.parseInt(scanner.nextLine());
                    System.out.print("Enter type: ");
                    String type = scanner.nextLine();
                    System.out.print("Enter start date: ");
                    String startDate = scanner.nextLine();
                    System.out.print("Enter end date: ");
                    String endDate = scanner.nextLine();
                    Membership m = new Membership(id, memberId, type, startDate, endDate);
                    membershipService.createMembership(m);
                }
                case "7" -> {
                    for (Membership m : membershipService.getAllMemberships()) {
                        System.out.println(m);
                    }
                }
                case "8" -> {
                    double revenue = membershipService.calculateTotalRevenue();
                    System.out.println("Total revenue: $" + revenue);
                }
                case "9" -> {
                    running = false;
                    System.out.println("Exiting the application.");
                }
                default -> {
                    System.out.println("Invalid option. Try again.");
                }
            }
        }

        scanner.close();
    }
}
