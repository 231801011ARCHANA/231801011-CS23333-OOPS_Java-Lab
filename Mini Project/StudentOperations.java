import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class StudentOperations {
    
    // Method to add a student and their subject marks
    public static void addStudent(String name, float subject1, float subject2, float subject3, float subject4, float subject5) {
    float average = (subject1 + subject2 + subject3 + subject4 + subject5) / 5;
    String Grade = calculateGrade(average);  // Calculate final grade based on average

    try (Connection connection = DatabaseConnection.connect()) {
        String sql = "INSERT INTO students (name, subject1, subject2, subject3, subject4, subject5, grade) VALUES (?, ?, ?, ?, ?, ?, ?)";
        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setString(1, name);
        statement.setFloat(2, subject1);
        statement.setFloat(3, subject2);
        statement.setFloat(4, subject3);
        statement.setFloat(5, subject4);
        statement.setFloat(6, subject5);
        statement.setString(7, Grade);
        statement.executeUpdate();
        System.out.println("Student and grade added successfully!");
    } catch (SQLException e) {
        e.printStackTrace();
    }
}

    // Helper method to calculate grade based on average score
    public static String calculateGrade(float average) {
        if (average >= 90) return "A";
        else if (average >= 80) return "B";
        else if (average >= 70) return "C";
        else if (average >= 60) return "D";
        else return "F";
    }

    // Method to display all student grades and averages
    public static void displayGrades() {
        try (Connection connection = DatabaseConnection.connect()) {
            String sql = "SELECT * FROM students";
            PreparedStatement statement = connection.prepareStatement(sql);
            ResultSet resultSet = statement.executeQuery();
            System.out.println("ID\tName\tSubject1\tSubject2\tSubject3\tSubject4\tSubject5\tGrade");
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String name = resultSet.getString("name");
                float subject1 = resultSet.getFloat("subject1");
                float subject2 = resultSet.getFloat("subject2");
                float subject3 = resultSet.getFloat("subject3");
                float subject4 = resultSet.getFloat("subject4");
                float subject5 = resultSet.getFloat("subject5");
                String Grade = resultSet.getString("grade");

                System.out.printf("%d\t%s\t%.2f\t%.2f\t%.2f\t%.2f\t%.2f\t%.2f\t%s\n", 
                                  id, name, subject1, subject2, subject3, subject4, subject5, Grade);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
