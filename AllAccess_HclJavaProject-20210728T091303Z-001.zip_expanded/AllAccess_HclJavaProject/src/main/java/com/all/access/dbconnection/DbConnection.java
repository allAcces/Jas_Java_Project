package com.all.access.dbconnection;

import java.sql.DriverManager;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class DbConnection 
{
	public static Connection getConnection()
	{
		Connection connection = null;
		ResourceBundle resourceBundle = ResourceBundle.getBundle("oracle");
		String dburl = resourceBundle.getString("db.url");
		String dbusername = resourceBundle.getString("db.username");
		String dbpassword = resourceBundle.getString("db.password");
		
		try
		{
			Class.forName("oracle.jdbc.driver.OracleDriver");
			connection = DriverManager.getConnection(dburl,dbusername,dbpassword);
		}
		catch(ClassNotFoundException | SQLException excep)
		{
			System.out.println(excep);
		}
		return connection;
	}
}

