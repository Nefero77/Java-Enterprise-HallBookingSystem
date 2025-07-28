// IssueForm.java
import java.awt.BorderLayout;
import java.awt.GridLayout;
import javax.swing.*;
import java.util.List;
import java.util.ArrayList;
import java.io.*;


public class IssueForm extends JFrame {
    public IssueForm(String username) {
        setTitle("Raise an Issue");
        setSize(400, 250);
        setLayout(new GridLayout(4, 2, 10, 10));

        JTextField hallField = new JTextField();
        JTextArea issueArea = new JTextArea();
        JButton submitBtn = new JButton("Submit Issue");

        add(new JLabel("Hall Name:"));
        add(hallField);
        add(new JLabel("Describe Issue:"));
        add(new JScrollPane(issueArea));
        add(new JLabel());
        add(submitBtn);

        submitBtn.addActionListener(e -> {
            try (BufferedWriter writer = new BufferedWriter(new FileWriter("issues.txt", true))) {
                writer.write(username + "," + hallField.getText().trim() + "," + issueArea.getText().trim() + ",Pending");
                writer.newLine();
                JOptionPane.showMessageDialog(this, "Issue submitted.");
                dispose();
            } catch (IOException ex) {
                JOptionPane.showMessageDialog(this, "Error saving issue.");
            }
        });

        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);
        setVisible(true);
    }
}