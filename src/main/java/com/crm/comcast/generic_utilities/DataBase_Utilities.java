package com.crm.comcast.generic_utilities;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.cj.jdbc.Driver;

public class DataBase_Utilities {
	Connection conn; Statement stat;
	public  void registerDB() throws Throwable {
		Driver driverRef = new Driver();
		DriverManager.registerDriver(driverRef);

	}
	public void connectToDB() throws Throwable 
	{
		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/office", "root", "root");
		
	}
	
	public void createQuery() throws Throwable
	{
		stat = conn.createStatement();
		
		
	}
	public void executeQuery(String query) throws Throwable
	{
		ResultSet resultSet = stat.executeQuery(query);
	 	 
	}
	public void closeDB() throws Throwable {
		conn.close();
	}

}
