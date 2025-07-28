// BookingFrame.java
import java.awt.event.*;
import java.awt.BorderLayout;
import java.awt.GridLayout;
import javax.swing.*;
import java.util.List;
import java.util.ArrayList;
import java.io.*;



public class BookingFrame extends JFrame {
    private String username;
    private JComboBox<String> hallBox;
    private JTextField hoursField;
    private JLabel totalLabel;
    private List<String[]> hallData = new ArrayList<>();

    public BookingFrame(String username) {
        this.username = username;

        setTitle("Book a Hall");
        setSize(400, 300);
        setLayout(new GridLayout(5, 2, 10, 10));

        loadHallData();

        hallBox = new JComboBox<>();
        for (String[] hall : hallData) {
            hallBox.addItem(hall[0] + " (RM " + hall[2] + "/hr)");
        }

        hoursField = new JTextField();
        totalLabel = new JLabel("Total: RM 0");
        JButton calcBtn = new JButton("Calculate");
        JButton confirmBtn = new JButton("Confirm Booking");

        add(new JLabel("Select Hall:"));
        add(hallBox);
        add(new JLabel("Hours:"));
        add(hoursField);
        add(calcBtn);
        add(totalLabel);
        add(new JLabel());
        add(confirmBtn);

        calcBtn.addActionListener(e -> calculateTotal());
        confirmBtn.addActionListener(e -> confirmBooking());

        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);
        setVisible(true);
    }

    private void loadHallData() {
        try (BufferedReader reader = new BufferedReader(new FileReader("halls.txt"))) {
            String line;
            while ((line = reader.readLine()) != null) {
                hallData.add(line.split(","));
            }
        } catch (IOException e) {
            JOptionPane.showMessageDialog(this, "Error loading halls.");
        }
    }

    private void calculateTotal() {
        try {
            int index = hallBox.getSelectedIndex();
            int rate = Integer.parseInt(hallData.get(index)[2]);
            int hours = Integer.parseInt(hoursField.getText().trim());
            totalLabel.setText("Total: RM " + (rate * hours));
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Please enter valid hours.");
        }
    }

    private void confirmBooking() {
        try {
            int index = hallBox.getSelectedIndex();
            String hall = hallData.get(index)[0];
            int rate = Integer.parseInt(hallData.get(index)[2]);
            int hours = Integer.parseInt(hoursField.getText().trim());
            int total = rate * hours;

            try (BufferedWriter writer = new BufferedWriter(new FileWriter("bookings.txt", true))) {
                writer.write(username + "," + hall + "," + hours + "," + total);
                writer.newLine();
            }
            JOptionPane.showMessageDialog(this, "Booking Confirmed!");
            dispose();
        } catch (IOException | NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Booking failed.");
        }
    }
}
