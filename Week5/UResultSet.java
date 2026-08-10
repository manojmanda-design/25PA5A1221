package Week5;

import java.sql.*;

public class UResultSet {

    static String url = "jdbc:mysql://localhost:3306/studentdb";
    static String user = "root";
    static String password = "Akhil@9866";

    public static void main(String[] args) {

        try {

            Connection con = DriverManager.getConnection(url, user, password);

            Statement st = con.createStatement(
                    ResultSet.TYPE_SCROLL_SENSITIVE,
                    ResultSet.CONCUR_UPDATABLE);

            ResultSet rs = st.executeQuery("SELECT * FROM Student");

            rs.last();
            rs.deleteRow();

            System.out.println("Last Record Deleted");

            rs.moveToInsertRow();

            rs.updateInt(1, 105);
            rs.updateString(2, "Akhil");
            rs.updateString(3, "Hyderabad");

            rs.insertRow();

            System.out.println("New Record Inserted");

            rs.close();
            st.close();
            con.close();

        } catch (Exception e) {
            System.out.println(e);
        }
    }
}