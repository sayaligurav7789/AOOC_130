import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import javax.swing.*;

public class SimpleLoginForm {

    private static final String URL = "jdbc:mysql://localhost:3306/user_db";
    private static final String USER = "root";  
    private static final String PASSWORD = "";  

    private static Connection con;

    public static void main(String[] args) {
        JFrame frame = new JFrame("Login Form");
        frame.setSize(300, 150);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new FlowLayout());

        // UI Components
        JLabel usernameLabel = new JLabel("Username:");
        JTextField usernameField = new JTextField(20);
        JLabel passwordLabel = new JLabel("Password:");
        JPasswordField passwordField = new JPasswordField(20);
        JButton loginButton = new JButton("Login");

        frame.add(usernameLabel);
        frame.add(usernameField);
        frame.add(passwordLabel);
        frame.add(passwordField);
        frame.add(loginButton);

        loginButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String username = usernameField.getText();
                String password = new String(passwordField.getPassword());
                if (con != null && loginUser(username, password)) {
                    JOptionPane.showMessageDialog(frame, "Login Successful!");
                } else {
                    JOptionPane.showMessageDialog(frame, "Invalid username or password.");
                }
            }
        });

        // Display the form
        frame.setVisible(true);

        // Connect to the database
        connectToDatabase();
    }

    // Method to connect to the MySQL database
    private static void connectToDatabase() {
        try {
            // Explicitly load the MySQL JDBC driver
            Class.forName("com.mysql.cj.jdbc.Driver");

            // Establish the connection
            con = DriverManager.getConnection(URL, USER, PASSWORD);
            System.out.println("Database connection established!");

        } catch (ClassNotFoundException e) {
            System.out.println("MySQL JDBC Driver not found!");
            e.printStackTrace();
        } catch (SQLException e) {
            System.out.println("Connection to the database failed!");
            e.printStackTrace();
        }
    }

    // Method to handle user login
    private static boolean loginUser(String username, String password) {
        PreparedStatement pst = null;
        ResultSet rs = null;
        try {
            String query = "SELECT * FROM users WHERE username = ? AND password = ?";
            pst = con.prepareStatement(query);
            pst.setString(1, username);
            pst.setString(2, password);
            rs = pst.executeQuery();

            // If user exists, return true, else false
            return rs.next(); // If result exists, it means valid user

        } catch (SQLException e) {
            System.out.println("Error executing query.");
            e.printStackTrace();
            return false;
        } finally {
            // Close resources
            try {
                if (rs != null) rs.close();
                if (pst != null) pst.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
