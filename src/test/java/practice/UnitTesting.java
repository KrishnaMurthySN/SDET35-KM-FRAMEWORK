package practice;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.cj.jdbc.Driver;

public class UnitTesting {

	
	public static void main(String[]args) throws Throwable {
		
		String ProjectName="tam";
		Connection conn=null;
		
		try {
		//Register to database
		Driver driverRef = new Driver();
		DriverManager.registerDriver(driverRef);
		
		//get the connection
		
		conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/college", "root", "root");
		
		//create the query
		
		Statement stat = conn.createStatement();
		
		String query = "select * from students_info";
		
		//execute query
		 ResultSet resultset = stat.executeQuery(query);

		 while(resultset.next())
		 {
			 String actProjectName=resultset.getString(2);
			 if(actProjectName.equalsIgnoreCase(ProjectName))
		
			 {	 
				 System.out.println("Pass:Project present");
				break;
			 }
			 else
			 {
				 System.out.println("Fail:Project is not present");
			 }
		 }
			 
		 }
 
		
		catch(Exception e) {
			System.out.println("Handling....");
			e.printStackTrace();
		}
		finally {
			//close the connection
		
		
			conn.close();
		
	 	  }
	}
	 		

}

