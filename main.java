package Mini_project;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ParkingSystem parkingSystem = new ParkingSystem();
        boolean exit = false;
        while (!exit) {
            System.out.println("\nWelcome to Find My Spot!");
            System.out.println("\nHere is your parking solution partner!");
            System.out.println("\nGo through the below options and select your booking spot");
            System.out.println("\nHave a nice day!");
            System.out.println("1. View Available Spots");
            System.out.println("2. Select a Parking Spot");
            System.out.println("3. Calculate and Pay");
            System.out.println("4. Exit");

            System.out.print("Please select an option: ");
            int option = scanner.nextInt();

            switch (option) {
                case 1:
                    parkingSystem.showAvailableSpots();
                    break;
                case 2:
                    System.out.print("Enter Spot ID to select: ");
                    String spotId = scanner.next();
                    parkingSystem.selectSpot(spotId);
                    break;
                case 3:
                    parkingSystem.calculateAndPay();
                    break;
                case 4:
                    exit = true;
                    System.out.println("Exiting... Thank you for using Find My Spot!");
                    break;
                default:
                    System.out.println("Invalid option. Please try again.");
            }
        }
        scanner.close();
    }
}