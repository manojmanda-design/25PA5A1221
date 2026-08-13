import java.sql.*;

public class SResultSet{

    public static void main(String[] args) {

        String url = "jdbc:mysql://localhost:3306/college";
        String username = "college";
        String password = "vit";

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");

            Connection con = DriverManager.getConnection(
                    url, username, password);

            Statement stmt = con.createStatement(
                    ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.CONCUR_READ_ONLY
            );

            String sql = "SELECT * FROM student ORDER BY id";

            ResultSet rs = stmt.executeQuery(sql);

            System.out.println("---- First Row ----");
            if (rs.first()) {
                displayStudent(rs);
            }

            System.out.println("\n---- Next Row ----");
            if (rs.next()) {
                displayStudent(rs);
            }

            System.out.println("\n---- Last Row ----");
            if (rs.last()) {
                displayStudent(rs);
            }

            System.out.println("\n---- Previous Row ----");
            if (rs.previous()) {
                displayStudent(rs);
            }

            System.out.println("\n---- Third Row ----");
            if (rs.absolute(3)) {
                displayStudent(rs);
            }

            System.out.println("\n---- Move 1 Row Forward ----");
            if (rs.relative(1)) {
                displayStudent(rs);
            }

            System.out.println("\n---- Move 1 Row Backward ----");
            if (rs.relative(-1)) {
                displayStudent(rs);
            }

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

    static void displayStudent(ResultSet rs) throws SQLException {

        System.out.println(
                "ID: " + rs.getInt("id") +
                ", Name: " + rs.getString("name") +
                ", Department: " + rs.getString("department") +
                ", Marks: " + rs.getInt("marks")
        );
    }
}
