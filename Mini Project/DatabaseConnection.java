import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnection {

    public static Connection connect() {
        try {
            // Load MySQL JDBC driver
            // Replace the path below with the actual path of your .jar file
            String jdbcDriverPath = "C:\\Users\\archa\\Downloads\\mysql-connector-j-9.1.0\\mysql-connector-j-9.1.0\\mysql-connector-j-9.1.0.jar";
            
            // Add the driver to the classpath dynamically
            System.setProperty("jdbc.drivers", jdbcDriverPath);
            
            // Database URL
            String url = "jdbc:mysql://localhost:3306/student_grading";  // Adjust if necessary
            String user = "root";  // Username (default for XAMPP)
            String password = "";  // Password (leave blank for XAMPP)
            
            // Establish connection
            Connection connection = DriverManager.getConnection(url, user, password);
            return connection;
            
        } catch (SQLException e) {
            System.out.println("Database connection failed: " + e.getMessage());
            e.printStackTrace();  // Print detailed stack trace
            return null;
        }
    }
}
