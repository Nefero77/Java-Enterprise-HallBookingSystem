import java.awt.event.*;
import java.awt.BorderLayout;
import java.awt.GridLayout;
import javax.swing.*;
import java.util.List;
import java.util.ArrayList;
import java.io.*;



public class CustomerLoginFrame extends JFrame {
    private JTextField userField;
    private JPasswordField passField;

    public CustomerLoginFrame() {
        setTitle("Customer Login");
        setSize(300, 200);
        setLayout(new GridLayout(4, 1, 5, 5));

        userField = new JTextField();
        passField = new JPasswordField();

        JButton loginBtn = new JButton("Login");
        JButton registerBtn = new JButton("Register");

        add(new JLabel("Username:"));
        add(userField);
        add(new JLabel("Password:"));
        add(passField);
        add(loginBtn);
        add(registerBtn);

        loginBtn.addActionListener(e -> login());
        registerBtn.addActionListener(e -> register());

        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);
        setVisible(true);
    }

    private void login() {
        String username = userField.getText().trim();
        String password = new String(passField.getPassword()).trim();

        try (BufferedReader br = new BufferedReader(new FileReader("users.txt"))) {
            String line;
            boolean success = false;

            while ((line = br.readLine()) != null) {
                String[] parts = line.split(",");
                if (parts[0].equals(username) && parts[1].equals(password)) {
                    success = true;
                    break;
                }
            }

            if (success) {
                JOptionPane.showMessageDialog(this, "Login Successful!");
                dispose();
                new CustomerDashboard(username);
            } else {
                JOptionPane.showMessageDialog(this, "Invalid credentials.");
            }

        } catch (IOException e) {
            JOptionPane.showMessageDialog(this, "Error: " + e.getMessage());
        }
    }

    private void register() {
        String username = userField.getText().trim();
        String password = new String(passField.getPassword()).trim();

        try (BufferedWriter writer = new BufferedWriter(new FileWriter("users.txt", true))) {
            writer.write(username + "," + password);
            writer.newLine();
            JOptionPane.showMessageDialog(this, "Registered Successfully!");
        } catch (IOException e) {
            JOptionPane.showMessageDialog(this, "Error: " + e.getMessage());
        }
    }
}
