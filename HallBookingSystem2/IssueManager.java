// IssueManager.java
import java.awt.BorderLayout;
import javax.swing.*;
import java.util.List;
import java.util.ArrayList;
import java.io.*;


public class IssueManager extends JFrame {
    public IssueManager() {
        setTitle("Manage Issues");
        setSize(600, 400);
        setLayout(new BorderLayout());

        DefaultListModel<String> model = new DefaultListModel<>();
        List<String> issues = new ArrayList<>();

        try (BufferedReader reader = new BufferedReader(new FileReader("issues.txt"))) {
            String line;
            while ((line = reader.readLine()) != null) {
                issues.add(line);
                String[] parts = line.split(",", 4);
                if (parts.length == 4) {
                    model.addElement("User: " + parts[0] + ", Hall: " + parts[1] +
                            ", Issue: " + parts[2] + ", Status: " + parts[3]);
                }
            }
        } catch (IOException e) {
            JOptionPane.showMessageDialog(this, "Error loading issues.");
            return;
        }

        JList<String> issueList = new JList<>(model);
        JButton updateBtn = new JButton("Update Status");

        updateBtn.addActionListener(e -> {
            int index = issueList.getSelectedIndex();
            if (index >= 0) {
                String[] options = {"In progress", "Done", "Closed", "Cancelled"};
                String newStatus = (String) JOptionPane.showInputDialog(this, "Select new status:", "Update Status",
                        JOptionPane.PLAIN_MESSAGE, null, options, options[0]);

                if (newStatus != null) {
                    String[] parts = issues.get(index).split(",", 4);
                    if (parts.length == 4) {
                        issues.set(index, parts[0] + "," + parts[1] + "," + parts[2] + "," + newStatus);
                        try (BufferedWriter writer = new BufferedWriter(new FileWriter("issues.txt"))) {
                            for (String issue : issues) {
                                writer.write(issue);
                                writer.newLine();
                            }
                        } catch (IOException ex) {
                            JOptionPane.showMessageDialog(this, "Error updating file.");
                        }
                        dispose();
                        JOptionPane.showMessageDialog(this, "Issue status updated.");
                    }
                }
            }
        });

        add(new JScrollPane(issueList), BorderLayout.CENTER);
        add(updateBtn, BorderLayout.SOUTH);

        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);
        setVisible(true);
    }
}
