import javax.swing.*;
import java.awt.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.table.DefaultTableModel;

public class DisplayGradesUI extends JFrame {

    public DisplayGradesUI() {
        setTitle("All Student Grades");
        setSize(600, 400);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        // Panel for displaying grades
        JTable table = new JTable();
        JScrollPane scrollPane = new JScrollPane(table);
        add(scrollPane, BorderLayout.CENTER);

        // Add a back button at the bottom
        JButton backButton = new JButton("Back");
        add(backButton, BorderLayout.SOUTH);

        // Action listener for back button to go to front page
        backButton.addActionListener(e -> {
            dispose(); // Close the current window
            SwingUtilities.invokeLater(() -> new FrontPage()); // Open the front page on the EDT
        });

        // Retrieve and display data in the table
        displayAllGrades(table);

        setVisible(true);
    }

    private void displayAllGrades(JTable table) {
        // Define column names for the table
        String[] columnNames = {"ID", "Name", "Subject1", "Subject2", "Subject3", "Subject4", "Subject5", "Grade"};
        
        // Create a model to hold the data
        DefaultTableModel model = new DefaultTableModel(columnNames, 0);
        table.setModel(model);

        try (Connection connection = DatabaseConnection.connect()) {
            String sql = "SELECT * FROM students";
            PreparedStatement statement = connection.prepareStatement(sql);
            ResultSet resultSet = statement.executeQuery();

            // Loop through the result set and add rows to the table model
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String name = resultSet.getString("name");
                float subject1 = resultSet.getFloat("subject1");
                float subject2 = resultSet.getFloat("subject2");
                float subject3 = resultSet.getFloat("subject3");
                float subject4 = resultSet.getFloat("subject4");
                float subject5 = resultSet.getFloat("subject5");
                String grade = resultSet.getString("grade");

                // Add a row to the table
                model.addRow(new Object[]{id, name, subject1, subject2, subject3, subject4, subject5, grade});
            }
        } catch (SQLException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Error displaying grades.");
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new DisplayGradesUI()); // Start the DisplayGradesUI
    }
}
