import java.sql.*;
import java.util.Scanner;

public class SchoolDatabaseOperations {

    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/school_db";
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

            while (true) {
                System.out.println("\n--- Students Info Menu ---");
                System.out.println("A. Select All");
                System.out.println("B. Insert");
                System.out.println("C. Update");
                System.out.println("D. Delete");
                System.out.println("E. Exit");
                System.out.print("Choose an option: ");
                String choice = scanner.nextLine().toUpperCase();

                switch (choice) {
                    case "A":
                        stmt = con.createStatement();
                        rs = stmt.executeQuery("SELECT * FROM students_info");
                        System.out.println("ID\tName\t\tDepartment");
                        System.out.println("-------------------------------------");
                        while (rs.next()) {
                            int id = rs.getInt("id");
                            String name = rs.getString("name");
                            String dept = rs.getString("department");
                            System.out.println(id + "\t" + name + "\t\t" + dept);
                        }
                        break;

                    case "B":
                        System.out.print("Enter ID: ");
                        int id = Integer.parseInt(scanner.nextLine());

                        System.out.print("Enter Name: ");
                        String name = scanner.nextLine();

                        System.out.print("Enter Department: ");
                        String dept = scanner.nextLine();

                        String insertSQL = "INSERT INTO students_info (id, name, department) VALUES (?, ?, ?)";
                        pstmt = con.prepareStatement(insertSQL);
                        pstmt.setInt(1, id);
                        pstmt.setString(2, name);
                        pstmt.setString(3, dept);
                        int inserted = pstmt.executeUpdate();
                        System.out.println(inserted > 0 ? "Inserted successfully." : "Insert failed.");
                        break;

                    case "C":
                        System.out.print("Enter ID to update: ");
                        int updateId = Integer.parseInt(scanner.nextLine());

                        System.out.print("Enter new Name: ");
                        String newName = scanner.nextLine();

                        System.out.print("Enter new Department: ");
                        String newDept = scanner.nextLine();

                        String updateSQL = "UPDATE students_info SET name = ?, department = ? WHERE id = ?";
                        pstmt = con.prepareStatement(updateSQL);
                        pstmt.setString(1, newName);
                        pstmt.setString(2, newDept);
                        pstmt.setInt(3, updateId);
                        int updated = pstmt.executeUpdate();
                        System.out.println(updated > 0 ? "Updated successfully." : "Update failed.");
                        break;

                    case "D":
                        System.out.print("Enter ID to delete: ");
                        int deleteId = Integer.parseInt(scanner.nextLine());

                        String deleteSQL = "DELETE FROM students_info WHERE id = ?";
                        pstmt = con.prepareStatement(deleteSQL);
                        pstmt.setInt(1, deleteId);
                        int deleted = pstmt.executeUpdate();
                        System.out.println(deleted > 0 ? "Deleted successfully." : "Delete failed.");
                        break;

                    case "E":
                        System.out.println("Exiting...");
                        scanner.close();
                        return;

                    default:
                        System.out.println("Invalid option. Try again.");
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try { if (rs != null) rs.close(); } catch (Exception e) {}
            try { if (stmt != null) stmt.close(); } catch (Exception e) {}
            try { if (pstmt != null) pstmt.close(); } catch (Exception e) {}
            try { if (con != null) con.close(); } catch (Exception e) {}
        }
    }
}
