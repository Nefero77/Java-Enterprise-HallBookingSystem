// BookingViewer.java
import java.awt.BorderLayout;
import java.awt.GridLayout;
import javax.swing.*;
import java.util.List;
import java.util.ArrayList;
import java.io.*;


public class BookingViewer extends JFrame {
    public BookingViewer(String username) {
        setTitle("My Bookings");
        setSize(400, 300);
        setLayout(new BorderLayout());

        JTextArea area = new JTextArea();
        area.setEditable(false);

        try (BufferedReader reader = new BufferedReader(new FileReader("bookings.txt"))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(",");
                if (parts[0].equals(username)) {
                    area.append("Hall: " + parts[1] + " | Hours: " + parts[2] + " | Total: RM " + parts[3] + "\n");
                }
            }
        } catch (IOException e) {
            area.setText("Error loading bookings.");
        }

        add(new JScrollPane(area), BorderLayout.CENTER);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);
        setVisible(true);
    }
}