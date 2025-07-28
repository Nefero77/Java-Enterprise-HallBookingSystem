// SchedulerDashboard.java
import java.awt.event.*;
import java.awt.BorderLayout;
import java.awt.GridLayout;
import javax.swing.*;
import java.util.List;
import java.util.ArrayList;
import java.io.*;



public class SchedulerDashboard extends JFrame {
    public SchedulerDashboard(String username) {
        setTitle("Scheduler Dashboard - " + username);
        setSize(400, 400);
        setLayout(new GridLayout(7, 1, 10, 10));

        JButton addHallBtn = new JButton("Add New Hall");
        JButton viewHallBtn = new JButton("View All Halls");
        JButton editHallBtn = new JButton("Edit Hall");
        JButton deleteHallBtn = new JButton("Delete Hall");
        JButton setAvailBtn = new JButton("Set Hall Availability");
        JButton setMaintBtn = new JButton("Set Maintenance Schedule");
        JButton logoutBtn = new JButton("Logout");

        add(addHallBtn);
        add(viewHallBtn);
        add(editHallBtn);
        add(deleteHallBtn);
        add(setAvailBtn);
        add(setMaintBtn);
        add(logoutBtn);

        addHallBtn.addActionListener(e -> new HallEditor(null));
        viewHallBtn.addActionListener(e -> new HallViewer());
        editHallBtn.addActionListener(e -> new HallEditor("edit"));
        deleteHallBtn.addActionListener(e -> new HallEditor("delete"));
        setAvailBtn.addActionListener(e -> new ScheduleEditor("availability.txt", "Availability"));
        setMaintBtn.addActionListener(e -> new ScheduleEditor("maintenance.txt", "Maintenance"));
        logoutBtn.addActionListener(e -> {
            dispose();
            new RoleSelectionFrame();
        });

        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setVisible(true);
    }
}
