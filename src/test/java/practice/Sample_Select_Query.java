package practice;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.cj.jdbc.Driver;

public class Sample_Select_Query {
//Register to the database
   
	public static void main(String[] args) throws Throwable  {
		Connection conn = null;
		try {
			
			Driver driverRef = new Driver();
			DriverManager.registerDriver(driverRef);//cj jdbc
			
		
		//get the connection
		
	 conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/student", "root", "root");
	//create the query
	 Statement stat = conn.createStatement();
	 		String query = "select * from student_info";
	 		
	 		//execute the query
	 	  ResultSet resultSet = stat.executeQuery(query);
	 	  while(resultSet.next()) {
	 		  System.out.println(resultSet.getInt(1)+"\n"+resultSet.getString(2));
	 	  }
		}
		
		catch(Exception e) {
			System.out.println("Handling....");
		}
		finally {
			//close the connection
			conn.close();
		
	 	  }
	 		
		
		
		}
	}

