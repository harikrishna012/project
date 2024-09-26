import java.util.*;

public class BikeRentalSystem {
    private Map<Integer, Customer> customers = new HashMap<>();
    private Map<Integer, Bike> bikes = new HashMap<>();
    private List<Rental> rentals = new ArrayList<>();

    // Add new customer
    public void addCustomer(int id, String name, String phoneNumber) {
        customers.put(id, new Customer(id, name, phoneNumber));
        System.out.println("Customer added: " + name);
    }

    // Add new bike
    public void addBike(int id, String model) {
        bikes.put(id, new Bike(id, model));
        System.out.println("Bike added: " + model);
    }

    // Rent a bike
    public void rentBike(int customerId, int bikeId) {
        Customer customer = customers.get(customerId);
        Bike bike = bikes.get(bikeId);
        
        if (customer == null) {
            System.out.println("Customer not found.");
            return;
        }
        
        if (bike == null || !bike.isAvailable()) {
            System.out.println("Bike not available.");
            return;
        }
        
        bike.setAvailable(false);
        Rental rental = new Rental(customer, bike);
        rentals.add(rental);
        System.out.println("Bike rented: " + bike.getModel() + " to " + customer.getName());
    }

    // Return a rented bike
    public void returnBike(int customerId, int bikeId) {
        Rental rental = rentals.stream()
                .filter(r -> r.getCustomer().getId() == customerId && r.getBike().getId() == bikeId && r.getRentalEndTime() == null)
                .findFirst()
                .orElse(null);
        
        if (rental == null) {
            System.out.println("No active rental found for customer ID: " + customerId + " and bike ID: " + bikeId);
            return;
        }
        
        rental.endRental();
        long fee = rental.calculateRentalFee();
        System.out.println("Bike returned by " + rental.getCustomer().getName() + ". Rental fee: " + fee);
    }

    // View all active rentals
    public void viewActiveRentals() {
        System.out.println("Active Rentals:");
        rentals.stream().filter(r -> r.getRentalEndTime() == null).forEach(System.out::println);
    }

    // View all customers
    public void viewCustomers() {
        customers.values().forEach(System.out::println);
    }

    // View all bikes
    public void viewBikes() {
        bikes.values().forEach(System.out::println);
    }
}