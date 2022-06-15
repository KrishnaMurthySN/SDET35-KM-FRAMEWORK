package practice;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.cj.jdbc.Driver;

public class SelectQueryCollege {
//Register to the database
   
	public static void main(String[] args) throws Throwable  {
		Connection conn = null;
		try {
			
			Driver driverRef = new Driver();
			DriverManager.registerDriver(driverRef);//cj jdbc
			
		
		//get the connection
		
	 conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/college", "root", "root");
	//create the query
	 Statement stat = conn.createStatement();
	 		String query = "select * from students_info";
	 		
	 		//execute the query
	 	  ResultSet resultSet = stat.executeQuery(query);
	 	  while(resultSet.next()) {
	 		  System.out.println(resultSet.getInt(1)+"\n"+resultSet.getString(2)+"\n"+resultSet.getString(3)+"\n"+resultSet.getString(4));
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

