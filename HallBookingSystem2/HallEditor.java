// HallEditor.java
import java.awt.BorderLayout;
import java.awt.GridLayout;
import javax.swing.*;
import java.util.List;
import java.util.ArrayList;
import java.io.*;


public class HallEditor extends JFrame {
    public HallEditor(String mode) {
        setTitle("Hall Management");
        setSize(400, 300);
        setLayout(new GridLayout(5, 2, 10, 10));

        JTextField nameField = new JTextField();
        JTextField capField = new JTextField();
        JTextField rateField = new JTextField();
        JButton actionBtn = new JButton(mode == null ? "Add Hall" : (mode.equals("edit") ? "Edit Hall" : "Delete Hall"));

        add(new JLabel("Hall Name:"));
        add(nameField);
        add(new JLabel("Capacity:"));
        add(capField);
        add(new JLabel("Rate per Hour (RM):"));
        add(rateField);
        add(new JLabel());
        add(actionBtn);

        actionBtn.addActionListener(e -> {
            String name = nameField.getText().trim();
            String cap = capField.getText().trim();
            String rate = rateField.getText().trim();
            try {
                List<String> halls = new ArrayList<>();
                File file = new File("halls.txt");
                if (file.exists()) {
                    try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
                        String line;
                        while ((line = reader.readLine()) != null) {
                            halls.add(line);
                        }
                    }
                }
                if (mode == null) {
                    try (BufferedWriter writer = new BufferedWriter(new FileWriter(file, true))) {
                        writer.write(name + "," + cap + "," + rate);
                        writer.newLine();
                    }
                    JOptionPane.showMessageDialog(this, "Hall Added.");
                } else {
                    boolean updated = false;
                    for (int i = 0; i < halls.size(); i++) {
                        if (halls.get(i).startsWith(name + ",")) {
                            if (mode.equals("edit")) {
                                halls.set(i, name + "," + cap + "," + rate);
                                updated = true;
                            } else if (mode.equals("delete")) {
                                halls.remove(i);
                                updated = true;
                            }
                            break;
                        }
                    }
                    try (BufferedWriter writer = new BufferedWriter(new FileWriter(file))) {
                        for (String h : halls) {
                            writer.write(h);
                            writer.newLine();
                        }
                    }
                    JOptionPane.showMessageDialog(this, updated ? "Operation Successful." : "Hall not found.");
                }
                dispose();
            } catch (IOException ex) {
                JOptionPane.showMessageDialog(this, "Error performing operation.");
            }
        });

        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);
        setVisible(true);
    }
}
