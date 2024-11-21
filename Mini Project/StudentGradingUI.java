import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class StudentGradingUI extends JFrame { // Ensure class name matches file name
    private JTextField nameField, subject1Field, subject2Field, subject3Field, subject4Field, subject5Field;

    public StudentGradingUI() {
        // Setting up the JFrame
        setTitle("Student Grading System");
        setSize(500, 600);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLayout(new BorderLayout());

        // Creating the input panel
        JPanel inputPanel = new JPanel(new GridLayout(8, 2, 10, 10));

        inputPanel.add(new JLabel("Student Name:"));
        nameField = new JTextField();
        inputPanel.add(nameField);

        inputPanel.add(new JLabel("Subject 1 Grade:"));
        subject1Field = new JTextField();
        inputPanel.add(subject1Field);

        inputPanel.add(new JLabel("Subject 2 Grade:"));
        subject2Field = new JTextField();
        inputPanel.add(subject2Field);

        inputPanel.add(new JLabel("Subject 3 Grade:"));
        subject3Field = new JTextField();
        inputPanel.add(subject3Field);

        inputPanel.add(new JLabel("Subject 4 Grade:"));
        subject4Field = new JTextField();
        inputPanel.add(subject4Field);

        inputPanel.add(new JLabel("Subject 5 Grade:"));
        subject5Field = new JTextField();
        inputPanel.add(subject5Field);

        // Add button
        JButton addButton = new JButton("Add Student and Grades");
        addButton.addActionListener(new AddButtonListener());
        inputPanel.add(addButton);

        // Display Grades button
        JButton displayButton = new JButton("Display Grades");
        displayButton.addActionListener(e -> {
            new DisplayGradesUI(); // Opens the DisplayGradesUI
            dispose(); // Closes the StudentGradingUI window
        });
        inputPanel.add(displayButton);

        // Back button to return to FrontPage
        JButton backButton = new JButton("Back");
        backButton.addActionListener(e -> {
            new FrontPage(); // Opens the FrontPage
            dispose(); // Closes the StudentGradingUI window
        });
        inputPanel.add(backButton);

        add(inputPanel, BorderLayout.NORTH);

        setVisible(true);
    }

    private class AddButtonListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            String name = nameField.getText();
            float subject1, subject2, subject3, subject4, subject5;

            try {
                subject1 = Float.parseFloat(subject1Field.getText());
                subject2 = Float.parseFloat(subject2Field.getText());
                subject3 = Float.parseFloat(subject3Field.getText());
                subject4 = Float.parseFloat(subject4Field.getText());
                subject5 = Float.parseFloat(subject5Field.getText());

                // Adding student to the database
                StudentOperations.addStudent(name, subject1, subject2, subject3, subject4, subject5);
                JOptionPane.showMessageDialog(null, "Student and grades added successfully!");

                // Clear input fields
                nameField.setText("");
                subject1Field.setText("");
                subject2Field.setText("");
                subject3Field.setText("");
                subject4Field.setText("");
                subject5Field.setText("");
                
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(null, "Please enter valid numbers for grades.");
            }
        }
    }
}
