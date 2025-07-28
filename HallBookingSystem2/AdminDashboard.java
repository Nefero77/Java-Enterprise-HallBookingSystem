// AdminDashboard.java
import java.awt.event.*;
import java.awt.BorderLayout;
import java.awt.GridLayout;
import javax.swing.*;
import java.util.List;
import java.util.ArrayList;
import java.io.*;


public class AdminDashboard extends JFrame {
    public AdminDashboard(String username) {
        setTitle("Administrator Dashboard - " + username);
        setSize(400, 300);
        setLayout(new GridLayout(4, 1, 10, 10));

        JButton manageSchedulersBtn = new JButton("Manage Scheduler Accounts");
        JButton manageUsersBtn = new JButton("Manage Customer Accounts");
        JButton viewBookingsBtn = new JButton("View All Bookings");
        JButton logoutBtn = new JButton("Logout");

        add(manageSchedulersBtn);
        add(manageUsersBtn);
        add(viewBookingsBtn);
        add(logoutBtn);

        manageSchedulersBtn.addActionListener(e -> new SchedulerManager());
        manageUsersBtn.addActionListener(e -> new UserManager());
        viewBookingsBtn.addActionListener(e -> new AllBookingsViewer());
        logoutBtn.addActionListener(e -> {
            dispose();
            new RoleSelectionFrame();
        });

        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setVisible(true);
    }
}