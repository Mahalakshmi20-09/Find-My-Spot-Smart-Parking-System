package Mini_project;

import java.util.ArrayList;
import java.util.List;

public class ParkingSystem {

    private List<ParkingSpot> availableSpots;
    private ParkingSpot selectedSpot;
    private int hours;

    public ParkingSystem() {
        this.availableSpots = new ArrayList<>();
        // Adding 15 parking spots, some reserved already
        for (int i = 1; i <= 15; i++) {
            double price = 30;// Just for variation in prices
            ParkingSpot spot = new ParkingSpotImpl("S" + i, price);
            if (i % 5 == 0) {
                ((ParkingSpotImpl) spot).reserveSpot(); // Mark every 5th spot as reserved
            }
            availableSpots.add(spot);
        }
    }

    public void showAvailableSpots() {
        System.out.println("Available Parking Spots:");
        for (ParkingSpot spot : availableSpots) {
            System.out.println(spot.getSpotDetails());
        }
    }

    public void selectSpot(String spotId) {
        for (ParkingSpot spot : availableSpots) {
            if (spot.getSpotDetails().contains(spotId)) {
                selectedSpot = spot;
                if (((ParkingSpotImpl) spot).isReserved()) {
                    System.out.println("Spot " + spotId + " is already reserved.");
                    return;
                } else {
                    System.out.println("Spot " + spotId + " selected.");
                    return;
                }
            }
        }
        System.out.println("Error: Invalid Spot ID!");
    }

    public List<ParkingSpot> getAvailableSpots() {
        return availableSpots;
    }

    public void calculateAndPay() {
        // Your payment logic here
        System.out.println("Proceeding to payment...");
    }
}