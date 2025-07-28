// HallViewer.java
import java.awt.BorderLayout;
import java.awt.GridLayout;
import javax.swing.*;
import java.util.List;
import java.util.ArrayList;
import java.io.*;


public class HallViewer extends JFrame {
    public HallViewer() {
        setTitle("All Halls");
        setSize(400, 300);
        JTextArea area = new JTextArea();
        area.setEditable(false);
        try (BufferedReader reader = new BufferedReader(new FileReader("halls.txt"))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(",");
                area.append("Hall: " + parts[0] + ", Capacity: " + parts[1] + ", Rate: RM " + parts[2] + "\n");
            }
        } catch (IOException e) {
            area.setText("Error loading halls.");
        }
        add(new JScrollPane(area));
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);
        setVisible(true);
    }
}
