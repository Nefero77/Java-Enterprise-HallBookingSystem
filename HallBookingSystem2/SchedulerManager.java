// SchedulerManager.java
import java.awt.BorderLayout;
import java.awt.GridLayout;
import javax.swing.*;
import java.util.List;
import java.util.ArrayList;
import java.io.*;


public class SchedulerManager extends JFrame {
    public SchedulerManager() {
        setTitle("Manage Schedulers");
        setSize(400, 300);
        setLayout(new BorderLayout());

        JTextArea area = new JTextArea();
        area.setEditable(false);

        JButton addBtn = new JButton("Add Scheduler");

        try (BufferedReader reader = new BufferedReader(new FileReader("schedulers.txt"))) {
            String line;
            while ((line = reader.readLine()) != null) {
                area.append(line + "\n");
            }
        } catch (IOException e) {
            area.setText("Error loading scheduler data.");
        }

        addBtn.addActionListener(e -> {
            String user = JOptionPane.showInputDialog(this, "Enter scheduler username:");
            String pass = JOptionPane.showInputDialog(this, "Enter scheduler password:");
            if (user != null && pass != null) {
                try (BufferedWriter writer = new BufferedWriter(new FileWriter("schedulers.txt", true))) {
                    writer.write(user + "," + pass);
                    writer.newLine();
                    JOptionPane.showMessageDialog(this, "Scheduler added.");
                    dispose();
                } catch (IOException ex) {
                    JOptionPane.showMessageDialog(this, "Error writing file.");
                }
            }
        });

        add(new JScrollPane(area), BorderLayout.CENTER);
        add(addBtn, BorderLayout.SOUTH);

        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);
        setVisible(true);
    }
}
