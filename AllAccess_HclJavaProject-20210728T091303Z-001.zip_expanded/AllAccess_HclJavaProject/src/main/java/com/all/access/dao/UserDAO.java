package com.all.access.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.all.access.dbconnection.DbConnection;
import com.all.access.model.Users;

public class UserDAO 
{
	Connection connection;
	PreparedStatement ps;
	int insertresult,updateresult,deleteresult;
	
	public int insertUser(Users us) 
	{
		connection=DbConnection.getConnection();

		try {	 
			
		ps=connection.prepareStatement("insert into INSERT INTO USERS(user_id,username,user_password,type,user_address,contact,gender,profile_photo) values(?,?,?,?,?,?,?,?)");


		ps.setInt(1,us.getUserId());
		ps.setString(2,us.getUsername());
		ps.setString(3,us.getUserPassword());
		ps.setInt(4,us.getType());
		ps.setString(5,us.getUserAddress());
		ps.setString(6,us.getContactNumber());
		ps.setString(7,us.getGender());
		ps.setBlob(8, us.getProfilePhoto());

		insertresult=ps.executeUpdate();

		if(insertresult>0) {
			System.out.println("New USERS inserted");
		}
		}
		catch(SQLException s) {
			System.out.println(s);
		}
		return insertresult;
	}
	
	List<Users> displayAllUsers(){

		List<Users> userlist=new ArrayList<Users>();

		Users users=null;
		connection=DbConnection.getConnection();
		try {
			ps=connection.prepareStatement("select * from USERS");


			ResultSet rs=ps.executeQuery();


			while(rs.next())
			{

				users=new Users(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getInt(4),rs.getString(5),rs.getString(6),rs.getString(7),rs.getBlob(8));

				userlist.add(users);
			}


		}
		catch(SQLException s) 

		{

			System.out.println(s);
		}

		return userlist;
	}
	
	public Users findUserById(int user_id)
	{
		Users users = null;
		connection=DbConnection.getConnection();
		try {
			ps=connection.prepareStatement("select * from USERS where user_id = ?");
			ps.setInt(1, user_id);
			ResultSet rs=ps.executeQuery();
			while(rs.next())
			{
				users=new Users(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getInt(4),rs.getString(5),rs.getString(6),rs.getString(7),rs.getBlob(8));
			}
		}
		catch(SQLException s) 
		{
			System.out.println(s);
		}
		return users;
	}
	
	public void updateUser(Users us)
	{
		connection=DbConnection.getConnection();
		try {
			ps=connection.prepareStatement("update USERS set username = ? where user_id = ?");
			ps.setString(1, us.getUsername());
			ps.setInt(2,us.getUserId());
			updateresult = ps.executeUpdate();
		}
		catch(SQLException s) 
		{
			System.out.println(s);
		}
	}
	
	public int deleteUser(String Username) 
	{
		connection=DbConnection.getConnection();
		try {
			ps=connection.prepareStatement("delete from USERS where username=?");
			ps.setString(1, Username);

			deleteresult =	ps.executeUpdate();

			if(deleteresult>0) 
			{
				deleteresult=1;
			}
		} catch (SQLException e) {

			e.printStackTrace();
		}
		return deleteresult;
	}

}
