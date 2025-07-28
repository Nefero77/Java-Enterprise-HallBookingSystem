// BookingCanceller.java
import java.awt.BorderLayout;
import java.awt.GridLayout;
import javax.swing.*;
import java.util.List;
import java.util.ArrayList;
import java.io.*;


public class BookingCanceller extends JFrame {
    public BookingCanceller(String username) {
        setTitle("Cancel Booking");
        setSize(400, 300);
        setLayout(new BorderLayout());

        DefaultListModel<String> model = new DefaultListModel<>();
        List<String> allBookings = new ArrayList<>();

        try (BufferedReader reader = new BufferedReader(new FileReader("bookings.txt"))) {
            String line;
            while ((line = reader.readLine()) != null) {
                allBookings.add(line);
                String[] parts = line.split(",");
                if (parts[0].equals(username)) {
                    model.addElement("Hall: " + parts[1] + ", Hours: " + parts[2] + ", Total: RM " + parts[3]);
                }
            }
        } catch (IOException e) {
            JOptionPane.showMessageDialog(this, "Error loading bookings.");
            return;
        }

        JList<String> list = new JList<>(model);
        JButton cancelBtn = new JButton("Cancel Selected Booking");

        cancelBtn.addActionListener(e -> {
            int selected = list.getSelectedIndex();
            if (selected >= 0) {
                String toRemove = null;
                int matchCount = 0;
                for (String booking : allBookings) {
                    if (booking.startsWith(username + ",")) {
                        if (matchCount == selected) {
                            toRemove = booking;
                            break;
                        }
                        matchCount++;
                    }
                }

                if (toRemove != null) {
                    allBookings.remove(toRemove);
                    try (BufferedWriter writer = new BufferedWriter(new FileWriter("bookings.txt"))) {
                        for (String b : allBookings) {
                            writer.write(b);
                            writer.newLine();
                        }
                    } catch (IOException ex) {
                        JOptionPane.showMessageDialog(this, "Error updating file.");
                    }
                    dispose();
                    JOptionPane.showMessageDialog(this, "Booking Cancelled.");
                }
            }
        });

        add(new JScrollPane(list), BorderLayout.CENTER);
        add(cancelBtn, BorderLayout.SOUTH);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);
        setVisible(true);
    }
}