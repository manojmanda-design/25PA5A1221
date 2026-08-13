import java.sql.*;

public class SResultSet{

    public static void main(String[] args) {

        String url = "jdbc:mysql://localhost:3306/college";
        String username = "college";
        String password = "vit";

        try {
            // Load JDBC driver
            Class.forName("com.mysql.cj.jdbc.Driver");

            // Establish connection
            Connection con = DriverManager.getConnection(
                    url, username, password);

            // Create a scrollable ResultSet
            Statement stmt = con.createStatement(
                    ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.CONCUR_READ_ONLY
            );

            String sql = "SELECT * FROM student ORDER BY id";

            ResultSet rs = stmt.executeQuery(sql);

            // 1. Move to the first row
            System.out.println("---- First Row ----");
            if (rs.first()) {
                displayStudent(rs);
            }

            // 2. Move to the next row
            System.out.println("\n---- Next Row ----");
            if (rs.next()) {
                displayStudent(rs);
            }

            // 3. Move to the last row
            System.out.println("\n---- Last Row ----");
            if (rs.last()) {
                displayStudent(rs);
            }

            // 4. Move to the previous row
            System.out.println("\n---- Previous Row ----");
            if (rs.previous()) {
                displayStudent(rs);
            }

            // 5. Move directly to the third row
            System.out.println("\n---- Third Row ----");
            if (rs.absolute(3)) {
                displayStudent(rs);
            }

            // 6. Move relative to current position
            System.out.println("\n---- Move 1 Row Forward ----");
            if (rs.relative(1)) {
                displayStudent(rs);
            }

            // 7. Move relative backward
            System.out.println("\n---- Move 1 Row Backward ----");
            if (rs.relative(-1)) {
                displayStudent(rs);
            }

            // 8. Display all rows in reverse order
            System.out.println("\n---- Reverse Order ----");

            rs.afterLast();

            while (rs.previous()) {
                displayStudent(rs);
            }

            rs.close();
            stmt.close();
            con.close();

        } catch (ClassNotFoundException e) {
            System.out.println("JDBC Driver not found.");
            e.printStackTrace();

        } catch (SQLException e) {
            System.out.println("Database error.");
            e.printStackTrace();
        }
    }

    // Method to display current row
    static void displayStudent(ResultSet rs) throws SQLException {

        System.out.println(
                "ID: " + rs.getInt("id") +
                ", Name: " + rs.getString("name") +
                ", Department: " + rs.getString("department") +
                ", Marks: " + rs.getInt("marks")
        );
    }
}
