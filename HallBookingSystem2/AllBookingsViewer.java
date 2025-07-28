// AllBookingsViewer.java
import java.io.*;
import java.awt.BorderLayout;
import java.awt.GridLayout;
import javax.swing.*;
import java.util.List;
import java.util.ArrayList;



public class AllBookingsViewer extends JFrame {
    public AllBookingsViewer() {
        setTitle("All Bookings");
        setSize(500, 300);
        setLayout(new BorderLayout());

        JTextArea area = new JTextArea();
        area.setEditable(false);

        try (BufferedReader reader = new BufferedReader(new FileReader("bookings.txt"))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(",");
                area.append("User: " + parts[0] + ", Hall: " + parts[1] + ", Hours: " + parts[2] + ", Total: RM " + parts[3] + "\n");
            }
        } catch (IOException e) {
            area.setText("Error reading bookings.");
        }

        add(new JScrollPane(area), BorderLayout.CENTER);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);
        setVisible(true);
    }
}
