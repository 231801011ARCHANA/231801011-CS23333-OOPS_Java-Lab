import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class FrontPage extends JFrame {
    public FrontPage() {
        // Set up JFrame
        setTitle("Student Grading System - Front Page");
        setSize(500, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        // Add logo
        JLabel logoLabel = new JLabel();
        ImageIcon logoIcon = new ImageIcon("logo.png"); // Ensure logo.png is in the same folder
        logoLabel.setIcon(logoIcon);
        logoLabel.setHorizontalAlignment(SwingConstants.CENTER);
        add(logoLabel, BorderLayout.NORTH);

        // Panel for buttons
        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new GridLayout(2, 1, 10, 10));

        // Button to open Grading System UI
        JButton openGradingSystemButton = new JButton("Open Grading System");
        openGradingSystemButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new StudentGradingUI(); // Opens the grading UI
                dispose(); // Close front page
            }
        });
        buttonPanel.add(openGradingSystemButton);

        // Button to display all grades
        JButton displayGradesButton = new JButton("Display All Grades");
        displayGradesButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new DisplayGradesUI(); // Opens the display grades UI
                dispose(); // Close front page
            }
        });
        buttonPanel.add(displayGradesButton);

        add(buttonPanel, BorderLayout.CENTER);
        setVisible(true);
    }

    public static void main(String[] args) {
        new FrontPage();
    }
}
