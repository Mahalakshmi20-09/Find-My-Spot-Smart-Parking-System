package Mini_project;

public interface ParkingSpot {
    String getSpotDetails();
    double getPricePerHour();
    boolean reserveSpot();
    boolean isReserved();
}