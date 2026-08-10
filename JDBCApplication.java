import java.sql.*;
public class StudentJDBCApp
{
	public static void main(string[] args)
	{
		string url="jdbc:mysql://localhost:3306/testdb?
		string user="testuser";
		sring password="testpass";
		try{
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con=DriverManager.getconnection(url,user,password);
			Statement stmt=Con.CreateStudent();
			String CreateTable="CREATE TABLE IF NOT EXISTS student("
								+"RollNo INT PRIMARY KEY",
								+"Name VARCHAR(50)",
								+"Address VARCHAR(100)");
			stmt.executeUpdate(createTable);
			System.out.println("Table created successfully:");
			stmt.executeUpdate("INSERT INTO student VALUES(1,'ravi','Hyderabad');
			stmt.executeUpdate("INSERT INTO student VALUES(2,'sita','Chennai');
			stmt.executeUpdate("INSERT INTO student VALUES(3,'kiran','Bangalore');
			System.out.println("Initial records Inserted");
			System.out.println("\nInitial inserted");
			displayRecords(stmt);
			stmt.executeUpdate("INSERT INTO student VALUES(4,'meena','pune')")
			stmt.executeUpdate("INSERT INTO student VALUES(5,'Ramesh','mumbai')");
			System.out.println("\nTwo new records inserted");
			stmt.executeUpdate("Update student SET Address='Delhi'WHERE RollNo=2");
			System.out.println("One record updated");
			stmt.executeUpdate("Delete From student WHERE RollNo=3");
			System.out.println("One record deleted");
			System.out.println("\nFinal Records:");
			displayRecords(stmt);
			Con.close();
     		   }catch(Exception e){
				e.printStackTrace();
        }
}
public static void displayRecords(statement stmt)throws SQLException{
		Resultset rs=stmt.executeQuery("SELECT * FROM student");
		System.out.println("RollNo\tName\tAddress");
		while(rs.next()){
int roll=rs.getstring("RollNo");
string name=rs.getstring("Name");
string address=rs.getstring("Address");
System.out.println(roll+"\t"+name+"\t"+address);
}
}
}
