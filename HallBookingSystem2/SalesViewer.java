// SalesViewer.java
import java.awt.BorderLayout;
import java.awt.GridLayout;
import javax.swing.*;
import java.util.List;
import java.util.ArrayList;
import java.io.*;


public class SalesViewer extends JFrame {
    public SalesViewer() {
        setTitle("Sales Summary");
        setSize(300, 200);
        setLayout(new BorderLayout());

        JLabel totalLabel = new JLabel("", SwingConstants.CENTER);
        int total = 0;

        try (BufferedReader reader = new BufferedReader(new FileReader("bookings.txt"))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(",");
                total += Integer.parseInt(parts[3]);
            }
        } catch (IOException e) {
            totalLabel.setText("Error reading sales data.");
        }

        totalLabel.setText("Total Sales: RM " + total);
        add(totalLabel, BorderLayout.CENTER);

        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);
        setVisible(true);
    }
}
