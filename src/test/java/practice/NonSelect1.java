package practice;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.cj.jdbc.Driver;

public class NonSelect1 {

	
	public static void main(String[]args) throws Throwable {
		Connection conn=null;
		
		int resultset = 0;
		
		try {
		//Register to database
		Driver driverRef = new Driver();
		DriverManager.registerDriver(driverRef);
		
		//get the connection
		
		conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/college", "root", "root");
		
		//create the query
		
		Statement stat = conn.createStatement();
		
		String query = "insert into students_info values(22, 'manu', 'kumar', 'd')";
		
		//execute query
		 resultset = stat.executeUpdate(query);
		}
		catch(Exception e) {
			System.out.println("Handling....");
			e.printStackTrace();
		}
		finally {
			//close the connection
			
		if(resultset==1)
			{
			System.out.println("row is added successfully");
			}
			else
			{
				System.out.println("row is  not added ");
			}
		}
			conn.close();
		
	 	  }
	 		

}

