// ManagerDashboard.java
import java.awt.event.*;
import java.awt.BorderLayout;
import java.awt.GridLayout;
import javax.swing.*;
import java.util.List;
import java.util.ArrayList;
import java.io.*;



public class ManagerDashboard extends JFrame {
    public ManagerDashboard(String username) {
        setTitle("Manager Dashboard - " + username);
        setSize(400, 300);
        setLayout(new GridLayout(4, 1, 10, 10));

        JButton viewIssuesBtn = new JButton("View and Update Issues");
        JButton viewSalesBtn = new JButton("View Sales Summary");
        JButton logoutBtn = new JButton("Logout");

        add(viewIssuesBtn);
        add(viewSalesBtn);
        add(logoutBtn);

        viewIssuesBtn.addActionListener(e -> new IssueManager());
        viewSalesBtn.addActionListener(e -> new SalesViewer());
        logoutBtn.addActionListener(e -> {
            dispose();
            new RoleSelectionFrame();
        });

        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setVisible(true);
    }
}

