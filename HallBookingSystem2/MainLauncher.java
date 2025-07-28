import java.awt.BorderLayout;
import java.awt.GridLayout;
import javax.swing.*;
import java.util.List;
import java.util.ArrayList;
import java.io.*;


public class MainLauncher {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new RoleSelectionFrame());
    }
}
