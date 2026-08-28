package Mini_project;

public class ParkingSpotImpl implements ParkingSpot {
    private String spotId;
    private double pricePerHour;
    private boolean isReserved;

    public ParkingSpotImpl(String spotId, double pricePerHour) {
        this.spotId = spotId;
        this.pricePerHour = pricePerHour;
        this.isReserved = false;
    }

    @Override
    public String getSpotDetails() {
        return "Spot ID: " + spotId + ", Price per Hour: ₹" + pricePerHour;
    }

    @Override
    public double getPricePerHour() {
        return pricePerHour;
    }

    @Override
    public boolean reserveSpot() {
        if (isReserved) {
            System.out.println("Error: Spot already reserved!");
            return false;
        } else {
            isReserved = true;
            System.out.println("Spot " + spotId + " has been reserved.");
            return true;
        }
    }

    @Override
    public boolean isReserved() {
        return isReserved;
    }
}