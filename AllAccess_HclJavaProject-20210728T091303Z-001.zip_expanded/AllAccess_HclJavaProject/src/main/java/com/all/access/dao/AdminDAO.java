package com.all.access.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import com.all.access.dbconnection.*;
import com.all.access.model.Admin;

public class AdminDAO 
{
	Connection connection;
	PreparedStatement ps;
	int queryresult;
	
	public int insertadmin(Admin adm) 
	{
		connection=DbConnection.getConnection();

		try {	 
			
		ps=connection.prepareStatement("insert into admin(Email,password,type) values(?,?,?)");


		ps.setString(1,adm.getEmailAddress());
		ps.setString(2,adm.getPassword());
		ps.setInt(3,adm.getLoginType());

		queryresult=ps.executeUpdate();

		if(queryresult>0) {
			System.out.println("Admin inserted");
		}
		}
		catch(SQLException s) {
			System.out.println(s);
		}
		return queryresult;
	}
	
	//function to display all product
	List<Admin> displayAdmin(){

		List<Admin> admlist=new ArrayList<Admin>();

		Admin admin=null;
		connection=DbConnection.getConnection();
		try {
			ps=connection.prepareStatement("select * from admin");


			ResultSet rs=ps.executeQuery();


			while(rs.next())
			{

				admin=new Admin(rs.getString(1),rs.getString(2),rs.getInt(3));

				admlist.add(admin);
			}


		}
		catch(SQLException s) 

		{

			System.out.println(s);
		}

		return admlist;
	}

}
