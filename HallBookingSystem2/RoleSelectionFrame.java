import java.awt.event.*;
import java.awt.BorderLayout;
import java.awt.GridLayout;
import javax.swing.*;
import java.util.List;
import java.util.ArrayList;
import java.io.*;

public class RoleSelectionFrame extends JFrame {
    public RoleSelectionFrame() {
        setTitle("Hall Booking Management System");
        setSize(400, 300);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(new GridLayout(6, 1, 10, 10));

        JLabel label = new JLabel("Select Role", SwingConstants.CENTER);
        add(label);

        JButton customerBtn = new JButton("Customer");
        JButton schedulerBtn = new JButton("Scheduler");
        JButton adminBtn = new JButton("Administrator");
        JButton managerBtn = new JButton("Manager");

        // CUSTOMER
        customerBtn.addActionListener(e -> {
            dispose();
            new CustomerLoginFrame();
        });

        // SCHEDULER
        schedulerBtn.addActionListener(e -> {
            String user = JOptionPane.showInputDialog(this, "Enter scheduler username:");
            String pass = JOptionPane.showInputDialog(this, "Enter scheduler password:");
            if (user != null && pass != null && user.equals("scheduler") && pass.equals("admin123")) {
                dispose();
                new SchedulerDashboard(user);
            } else {
                JOptionPane.showMessageDialog(this, "Invalid scheduler credentials.");
            }
        });

        // ADMINISTRATOR
        adminBtn.addActionListener(e -> {
            String user = JOptionPane.showInputDialog(this, "Enter administrator username:");
            String pass = JOptionPane.showInputDialog(this, "Enter administrator password:");
            if (user != null && pass != null && user.equals("admin") && pass.equals("admin123")) {
                dispose();
                new AdminDashboard(user);
            } else {
                JOptionPane.showMessageDialog(this, "Invalid administrator credentials.");
            }
        });

        // MANAGER
        managerBtn.addActionListener(e -> {
            String user = JOptionPane.showInputDialog(this, "Enter manager username:");
            String pass = JOptionPane.showInputDialog(this, "Enter manager password:");
            if (user != null && pass != null && user.equals("manager") && pass.equals("admin123")) {
                dispose();
                new ManagerDashboard(user);
            } else {
                JOptionPane.showMessageDialog(this, "Invalid manager credentials.");
            }
        });

        add(customerBtn);
        add(schedulerBtn);
        add(adminBtn);
        add(managerBtn);

        setLocationRelativeTo(null);
        setVisible(true);
    }
}
