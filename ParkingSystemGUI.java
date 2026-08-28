package Mini_project;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

public class ParkingSystemGUI extends JFrame {
    private ParkingSystem parkingSystem;
    private JComboBox<String> spotList;
    private JTextField hourField;
    private JTextArea outputArea;
    private Set<String> reservedSpots;

    private final double ratePerHour = 30.0;

    public ParkingSystemGUI() {
        parkingSystem = new ParkingSystem();
        reservedSpots = new HashSet<>();

        // Pre-reserve spots
        reservedSpots.add("S5");
        reservedSpots.add("S10");
        reservedSpots.add("S15");

        setTitle("Find My Spot - GUI");
        setSize(600, 550);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());

        // Heading Label
        JLabel heading = new JLabel("Find My Spot", JLabel.CENTER);
        heading.setFont(new Font("Arial", Font.BOLD, 24));
        heading.setBorder(BorderFactory.createEmptyBorder(10, 0, 10, 0));
        add(heading, BorderLayout.NORTH);

        // Output Area
        outputArea = new JTextArea(10, 50);
        outputArea.setEditable(false);
        outputArea.setFont(new Font("Monospaced", Font.PLAIN, 14));
        JScrollPane scrollPane = new JScrollPane(outputArea);
        add(scrollPane, BorderLayout.CENTER);

        // Display welcome message
        displayWelcomeMessage();

        // Control Panel
        JPanel controlPanel = new JPanel();
        controlPanel.setLayout(new BoxLayout(controlPanel, BoxLayout.Y_AXIS));
        controlPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        add(controlPanel, BorderLayout.SOUTH);

        // Show Button
        JButton showBtn = new JButton("Show Available Spots");
        showBtn.setAlignmentX(Component.CENTER_ALIGNMENT);
        showBtn.setBackground(Color.CYAN);
        showBtn.addActionListener(this::handleShow);
        controlPanel.add(showBtn);
        controlPanel.add(Box.createVerticalStrut(10));

        // Spot Selector
        JPanel spotPanel = new JPanel();
        spotPanel.add(new JLabel("Select Spot:"));
        spotList = new JComboBox<>();
        refreshSpotList();
        spotPanel.add(spotList);
        spotPanel.setOpaque(false);
        controlPanel.add(spotPanel);
        controlPanel.add(Box.createVerticalStrut(10));

        // Hour Input
        JPanel hourPanel = new JPanel();
        hourPanel.add(new JLabel("Hours:"));
        hourField = new JTextField(5);
        hourPanel.add(hourField);
        hourPanel.setOpaque(false);
        controlPanel.add(hourPanel);
        controlPanel.add(Box.createVerticalStrut(10));

        // Pay Button
        JButton payBtn = new JButton("Select & Pay");
        payBtn.setAlignmentX(Component.CENTER_ALIGNMENT);
        payBtn.setBackground(Color.CYAN);
        payBtn.addActionListener(this::handleReserveAndPay);
        controlPanel.add(payBtn);
        controlPanel.add(Box.createVerticalStrut(10));

        // Exit Button
        JButton exitBtn = new JButton("Exit");
        exitBtn.setAlignmentX(Component.CENTER_ALIGNMENT);
        exitBtn.setBackground(Color.RED);
        exitBtn.setForeground(Color.WHITE);
        exitBtn.addActionListener(e -> System.exit(0));
        controlPanel.add(exitBtn);
    }

    private void displayWelcomeMessage() {
        outputArea.setText("Welcome to Find My Spot!\n" +
                "Here is your parking solution partner!\n\n" +
                "Go through the below options and select your booking spot.\n" +
                "View Available Spots\nSelect a Parking Spot\nCalculate and Pay\nExit\n\n" +
                "Have a nice day!\n");
    }

    private void refreshSpotList() {
        spotList.removeAllItems();
        for (int i = 1; i <= 15; i++) {
            String spotId = "S" + i;
            if (reservedSpots.contains(spotId)) {
                spotList.addItem(spotId + " (Reserved)");
            } else {
                spotList.addItem(spotId);
            }
        }
    }

    private void handleShow(ActionEvent e) {
        StringBuilder available = new StringBuilder("Available spots:\n");
        for (int i = 1; i <= 15; i++) {
            String spotId = "S" + i;
            if (!reservedSpots.contains(spotId)) {
                available.append(spotId).append(" ");
                if (i % 5 == 0) available.append("\n");
            }
        }
        outputArea.setText(available.toString());
    }

    private void handleReserveAndPay(ActionEvent e) {
        String selectedId = (String) spotList.getSelectedItem();
        if (selectedId == null) {
            JOptionPane.showMessageDialog(this, "Please select a spot.");
            return;
        }

        selectedId = selectedId.split(" ")[0];

        if (reservedSpots.contains(selectedId)) {
            JOptionPane.showMessageDialog(this, selectedId + " is already reserved. Please choose another.");
            return;
        }

        String hourText = hourField.getText();
        if (hourText.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Please enter number of hours.");
            return;
        }

        try {
            int hours = Integer.parseInt(hourText);
            if (hours <= 0) throw new NumberFormatException();

            String upiId = JOptionPane.showInputDialog(this, "Please enter your UPI ID:");
            if (upiId == null || upiId.isEmpty()) {
                JOptionPane.showMessageDialog(this, "UPI ID is required for payment.");
                return;
            }

            double total = ratePerHour * hours;
            reservedSpots.add(selectedId);
            refreshSpotList();

            outputArea.setText(String.format("Spot %s booked for %d hour(s). Total: ₹%.2f\nPay via UPI: findmyspot@upi",
                    selectedId, hours, total));

            showBill(selectedId, hours, upiId, total);
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this, "Invalid number of hours.");
        }
    }

    private void showBill(String spotId, int hours, String upiId, double amount) {
        String dateTime = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").format(new Date());
        String bill = String.format("---- Parking Bill ----\nSpot ID: %s\nHours: %d\nTotal: ₹%.2f\nUPI ID: %s\nDate & Time: %s\n--------------------",
                spotId, hours, amount, upiId, dateTime);
        JOptionPane.showMessageDialog(this, bill);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new ParkingSystemGUI().setVisible(true));
    }
}