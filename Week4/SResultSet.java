package Week4;

import java.sql.*;

public class SResultSet {

        static String url = "jdbc:mysql://localhost:3306/studentdb";
        static String user = "root";
        static String password = "Akhil@9866";

        public static void main(String[] args) {

                try {

                        Connection con = DriverManager.getConnection(url, user, password);

                        Statement st = con.createStatement(
                                        ResultSet.TYPE_SCROLL_INSENSITIVE,
                                        ResultSet.CONCUR_READ_ONLY);

                        ResultSet rs = st.executeQuery("SELECT * FROM Student");

                        System.out.println("Forward");

                        while (rs.next()) {
                                System.out.println(rs.getInt(1) + "\t" +
                                                rs.getString(2) + "\t" +
                                                rs.getString(3));
                        }

                        System.out.println("\nBackward");

                        while (rs.previous()) {
                                System.out.println(rs.getInt(1) + "\t" +
                                                rs.getString(2) + "\t" +
                                                rs.getString(3));
                        }

                        rs.first();
                        System.out.println("\nFirst Record");
                        System.out.println(rs.getInt(1) + "\t" +
                                        rs.getString(2) + "\t" +
                                        rs.getString(3));

                        rs.last();
                        System.out.println("\nLast Record");
                        System.out.println(rs.getInt(1) + "\t" +
                                        rs.getString(2) + "\t" +
                                        rs.getString(3));

                        rs.relative(-1);
                        System.out.println("\nSecond Record From Last");
                        System.out.println(rs.getInt(1) + "\t" +
                                        rs.getString(2) + "\t" +
                                        rs.getString(3));

                        rs.absolute(2);
                        System.out.println("\nSecond Record");
                        System.out.println(rs.getInt(1) + "\t" +
                                        rs.getString(2) + "\t" +
                                        rs.getString(3));

                        rs.close();
                        st.close();
                        con.close();

                } catch (Exception e) {
                        System.out.println(e);
                }
        }
}