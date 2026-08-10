import java.sql.*;
public class Procedure{
	public static void main(String args[])
	{
		String url="jdbc:mysql://localhost:3306/testdb";
		String user="root";
		String password="root";
		try(Connection conn=DriverManager.getConnection(url,user,password)){
			System.out.println("Database connected");
			CallableStatement insertStmt=conn.prepareCall("{call insert_employee(?,?,?)}");
			insertStmt.setInt(1,101);
			insertStmt.setString(2,"john Doe");
			insertStmt.setDouble(3,55000.00);
			insertStmt.execute();
			System.out.println("Record inserted successfully");
			CallableStatement getSalaryStmt=conn.prepareCall("{call get_salary_by_id(?,?)}");
			getSalaryStmt.setInt(1,101);
			getSalaryStmt.registerOutParameter(2,Types.DECIMAL);
			getSalaryStmt.execute();
			double salary=getSalaryStmt.getDouble(2);
			 System.out.println("salary for Employee ID 101 is:"+salary);
			insertStmt.close();
			getSalaryStmt.close();
		}catch(SQLException e){
					e.printStackTrace();
				}
	}
}
