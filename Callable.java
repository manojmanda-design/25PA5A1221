import java.sql.*;
public class Callable{
	public static void main(String[] args){
		Strin url="jdbc:mysql://localhost:3306/your_database";//change DB name
		String user="root";
		String password="root";
		try(Connection conn=DriverManager.getConnection(url,user,password)){
			System.out.println("Database connected");
			CallableStatement insertStmt=conn.prepareCall("{call insert_employee(?,?,?)}");
			insertStmt.setInt(1,101);
			insertStmt.setString(2,"john Doe");
			insertStmt.setDouble(3,55000.00);
			insertStmt.execute();
			System.out.println("Record inserted seccessfully");
			CallableStatement getSalaryStmt=co
	`	}
	}
}
