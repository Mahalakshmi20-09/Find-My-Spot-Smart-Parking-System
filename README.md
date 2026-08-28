# Find My Spot - Smart Parking System

## Overview

**Find My Spot** is a Smart Parking Management System developed in Java to simplify the parking experience through parking spot availability tracking, spot selection, reservation, and payment calculation.

The project provides both a **console-based interface** and a **Java Swing graphical user interface (GUI)** for managing parking spots.

## Features

* View available parking spots
* Select a parking spot
* Reserve parking spots
* Prevent booking of already reserved spots
* Calculate parking charges based on the number of hours
* UPI-based payment input
* Generate a parking bill with:

  * Spot ID
  * Number of hours
  * Total amount
  * UPI ID
  * Date and time
* User-friendly Java Swing GUI
* Console-based parking management

## Project Structure

```text
Find-My-Spot-Smart-Parking-System/
│
├── README.md
│
└── Mini_project/
    ├── Main.java
    ├── ParkingSpot.java
    ├── ParkingSpotImpl.java
    ├── ParkingSystem.java
    └── ParkingSystemGUI.java
```

## How It Works

1. The system initializes 15 parking spots.
2. Spots `S5`, `S10`, and `S15` are initially reserved.
3. Users can view available parking spots.
4. Users can select an available spot.
5. Users enter the required parking duration.
6. The system calculates the total parking fee.
7. The user provides a UPI ID for payment.
8. The selected parking spot is reserved.
9. A parking bill containing the booking details is generated.

## Parking Rate

The current parking rate is:

**₹30 per hour**

The total parking cost is calculated as:

```text
Total Amount = Number of Hours × ₹30
```

## Technologies Used

* **Java**
* **Object-Oriented Programming (OOP)**
* **Java Swing**
* **Java AWT**
* **Java Collections Framework**
* **Exception Handling**

## OOP Concepts Used

This project demonstrates several important Object-Oriented Programming concepts:

* **Interface** – `ParkingSpot`
* **Implementation** – `ParkingSpotImpl`
* **Encapsulation** – Private variables with public methods
* **Inheritance** – `ParkingSystemGUI` extends `JFrame`
* **Polymorphism** – `ParkingSpot` reference referring to `ParkingSpotImpl`
* **Abstraction** – Parking operations defined through the `ParkingSpot` interface

## Running the Project

### Prerequisites

* Java JDK 8 or later
* Java-supported IDE such as VS Code, IntelliJ IDEA, or Eclipse

### Run the Console Version

Compile and run:

```bash
javac Mini_project/*.java
java Mini_project.Main
```

### Run the GUI Version

Compile the project and run:

```bash
javac Mini_project/*.java
java Mini_project.ParkingSystemGUI
```

## Future Enhancements

* Real-time parking availability
* Database integration
* User registration and login
* Booking history
* QR-code based parking verification
* Dynamic pricing
* Multiple payment methods
* Vehicle entry and exit tracking
* Mobile application support
* Admin dashboard
* Cloud-based parking management

## Use Cases

The system can be adapted for:

* Shopping malls
* Corporate offices
* Residential complexes
* Airports
* Railway stations
* Event venues
* Stadiums
* Educational institutions

## Benefits

* Simplifies parking spot selection
* Reduces manual parking management
* Improves parking space utilization
* Provides quick booking and payment calculation
* Generates a clear parking bill
* Provides an easy-to-use graphical interface

## Author

**Mahalakshmi**

B.Tech Computer Science and Engineering

---
