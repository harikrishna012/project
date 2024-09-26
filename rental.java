import java.time.LocalDateTime;
import java.time.Duration;

public class Rental {
    private Customer customer;
    private Bike bike;
    private LocalDateTime rentalStartTime;
    private LocalDateTime rentalEndTime;

    public Rental(Customer customer, Bike bike) {
        this.customer = customer;
        this.bike = bike;
        this.rentalStartTime = LocalDateTime.now();
    }

    public void endRental() {
        this.rentalEndTime = LocalDateTime.now();
        bike.setAvailable(true); // Make bike available again
    }

    public long calculateRentalFee() {
        if (rentalEndTime == null) {
            throw new IllegalStateException("Rental has not ended yet.");
        }
        Duration rentalDuration = Duration.between(rentalStartTime, rentalEndTime);
        long hours = rentalDuration.toHours();
        return hours * 10; // Assume 10 currency units per hour
    }

    public Customer getCustomer() {
        return customer;
    }

    public Bike getBike() {
        return bike;
    }

    public LocalDateTime getRentalStartTime() {
        return rentalStartTime;
    }

    public LocalDateTime getRentalEndTime() {
        return rentalEndTime;
    }

    @Override
    public String toString() {
        return "Rental [Customer=" + customer + ", Bike=" + bike + ", Start=" + rentalStartTime + ", End=" + rentalEndTime + "]";
    }
}