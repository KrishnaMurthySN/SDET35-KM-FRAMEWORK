package practice;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.cj.jdbc.Driver;

public class NonSelect2 {

	
	public static void main(String[]args) throws Throwable {
		Connection conn=null;
		
		int resultset = 0;
		
		try {
		//Register to database
		Driver driverRef = new Driver();
		DriverManager.registerDriver(driverRef);
		
		//get the connection
		
		conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/office", "root", "root");
		
		//create the query
		
		Statement stat = conn.createStatement();
		
		//String query = "insert into emplyee_info values( 26, 'shama', 'quality')";
		  String query ="rename table employer_info to employees_info";
		//execute query
		 resultset = stat.executeUpdate(query);
		}
		catch(Exception e) {
			System.out.println("Handling....");
			e.printStackTrace();
		}
		finally {
			//close the connection
			
		if(resultset==0)
			{
			System.out.println("Table renamed successfully");
			//System.out.println("row is added successfully");
			}
			else
			{
				//System.out.println("row is  not added ");
				System.out.println("table not renamed");
			}
		}
			conn.close();
		
	 	  }
	 		

}

