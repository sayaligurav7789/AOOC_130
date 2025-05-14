import java.sql.*;
import java.util.Scanner;

public class StudentDatabaseViewer {
    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/college";
        String user = "root";
        String password = "";

        Connection con = null;
        PreparedStatement pstmt = null;
        Statement stmt = null;
        ResultSet rs = null;
        Scanner scanner = new Scanner(System.in);

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection(url, user, password);

            // --- INSERT new student from user input ---
            System.out.println("Enter Student ID: ");
            int id = scanner.nextInt();
            scanner.nextLine(); // consume newline

            System.out.println("Enter Student Name: ");
            String name = scanner.nextLine();

            System.out.println("Enter Department: ");
            String dept = scanner.nextLine();

            String insertSQL = "INSERT INTO student (id, name, department) VALUES (?, ?, ?)";
            pstmt = con.prepareStatement(insertSQL);
            pstmt.setInt(1, id);
            pstmt.setString(2, name);
            pstmt.setString(3, dept);

            int rowsInserted = pstmt.executeUpdate();
            if (rowsInserted > 0) {
                System.out.println("Student inserted successfully.\n");
            }

            // --- DISPLAY all students ---
            stmt = con.createStatement();
            rs = stmt.executeQuery("SELECT * FROM student");

            System.out.println("ID\tName\t\tDepartment");
            System.out.println("-------------------------------------");
            while (rs.next()) {
                int studentId = rs.getInt("id");
                String studentName = rs.getString("name");
                String studentDept = rs.getString("department");
                System.out.println(studentId + "\t" + studentName + "\t\t" + studentDept);
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try { if (rs != null) rs.close(); } catch (Exception e) {}
            try { if (stmt != null) stmt.close(); } catch (Exception e) {}
            try { if (pstmt != null) pstmt.close(); } catch (Exception e) {}
            try { if (con != null) con.close(); } catch (Exception e) {}
            scanner.close();
        }
    }
}
