// ScheduleEditor.java
import java.awt.BorderLayout;
import java.awt.GridLayout;
import javax.swing.*;
import java.util.List;
import java.util.ArrayList;
import java.io.*;


public class ScheduleEditor extends JFrame {
    public ScheduleEditor(String fileName, String type) {
        setTitle("Set " + type);
        setSize(400, 300);
        setLayout(new GridLayout(5, 2, 10, 10));

        JTextField hallField = new JTextField();
        JTextField startField = new JTextField();
        JTextField endField = new JTextField();
        JTextField remarksField = new JTextField();
        JButton submitBtn = new JButton("Save");

        add(new JLabel("Hall Name:"));
        add(hallField);
        add(new JLabel("Start Date & Time:"));
        add(startField);
        add(new JLabel("End Date & Time:"));
        add(endField);
        add(new JLabel("Remarks:"));
        add(remarksField);
        add(new JLabel());
        add(submitBtn);

        submitBtn.addActionListener(e -> {
            try (BufferedWriter writer = new BufferedWriter(new FileWriter(fileName, true))) {
                writer.write(hallField.getText().trim() + "," + startField.getText().trim() + "," + endField.getText().trim() + "," + remarksField.getText().trim());
                writer.newLine();
                JOptionPane.showMessageDialog(this, type + " saved.");
                dispose();
            } catch (IOException e1) {
                JOptionPane.showMessageDialog(this, "Error saving " + type + ".");
            }
        });

        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);
        setVisible(true);
    }
}
