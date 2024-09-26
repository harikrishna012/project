import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        BikeRentalSystem system = new BikeRentalSystem();
        Scanner scanner = new Scanner(System.in);

        // Sample Data
        system.addCustomer(1, "John Doe", "123-456-7890");
        system.addCustomer(2, "Jane Smith", "098-765-4321");
        system.addBike(1, "Mountain Bike");
        system.addBike(2, "Road Bike");

        boolean running = true;
        while (running) {
            System.out.println("\n--- Bike Rental System ---");
            System.out.println("1. View Customers");
            System.out.println("2. View Bikes");
            System.out.println("3. Rent Bike");
            System.out.println("4. Return Bike");
            System.out.println("5. View Active Rentals");
            System.out.println("6. Exit");
            System.out.print("Choose an option: ");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    system.viewCustomers();
                    break;
                case 2:
                    system.viewBikes();
                    break;
                case 3:
                    System.out.print("Enter customer ID: ");
                    int customerId = scanner.nextInt();
                    System.out.print("Enter bike ID: ");
                    int bikeId = scanner.nextInt();
                    system.rentBike(customerId, bikeId);
                    break;
                case 4:
                    System.out.print("Enter customer ID: ");
                    int returnCustomerId = scanner.nextInt();
                    System.out.print("Enter bike ID: ");
                    int returnBikeId = scanner.nextInt();
                    system.returnBike(returnCustomerId, returnBikeId);
                    break;
                case 5:
                    system.viewActiveRentals();
                    break;
                case 6:
                    running = false;
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
                    break;
            }
        }

        scanner.close();
    }
}
