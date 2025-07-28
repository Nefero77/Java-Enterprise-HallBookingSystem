import java.awt.event.*;
import java.awt.BorderLayout;
import java.awt.GridLayout;
import javax.swing.*;
import java.util.List;
import java.util.ArrayList;
import java.io.*;


public class CustomerDashboard extends JFrame {
    private String username;

    public CustomerDashboard(String username) {
        this.username = username;

        setTitle("Customer Dashboard - " + username);
        setSize(400, 300);
        setLayout(new GridLayout(6, 1, 10, 10));

        JButton bookBtn = new JButton("Book a Hall");
        JButton viewBtn = new JButton("View My Bookings");
        JButton cancelBtn = new JButton("Cancel a Booking");
        JButton issueBtn = new JButton("Raise an Issue");
        JButton logoutBtn = new JButton("Logout");

        bookBtn.addActionListener(e -> {
            new BookingFrame(username);
        });

        viewBtn.addActionListener(e -> {
            new BookingViewer(username);
        });

        cancelBtn.addActionListener(e -> {
            new BookingCanceller(username);
        });

        issueBtn.addActionListener(e -> {
            new IssueForm(username);
        });

        logoutBtn.addActionListener(e -> {
            dispose();
            new RoleSelectionFrame();
        });

        add(bookBtn);
        add(viewBtn);
        add(cancelBtn);
        add(issueBtn);
        add(logoutBtn);

        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setVisible(true);
    }
}
