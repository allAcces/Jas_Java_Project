package com.all.access.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import com.all.access.dbconnection.DbConnection;
import com.all.access.model.States;

public class StatesDAO 
{
	Connection connection;
	PreparedStatement ps;
	int insertresult,updateresult,deleteresult;
	
	public int insertstates(States states) 
	{
		connection=DbConnection.getConnection();

		try {	 
			
		ps=connection.prepareStatement("insert into states(state_id,state_name) values(?,?)");


		ps.setInt(1,states.getStateId());
		ps.setString(2,states.getStateName());

		insertresult=ps.executeUpdate();

		if(insertresult>0) {
			System.out.println("New State inserted");
		}
		}
		catch(SQLException s) {
			System.out.println(s);
		}
		return insertresult;
	}
	
	List<States> displayAllStates(){

		List<States> statelist=new ArrayList<States>();

		States states=null;
		connection=DbConnection.getConnection();
		try {
			ps=connection.prepareStatement("select * from States");


			ResultSet rs=ps.executeQuery();


			while(rs.next())
			{

				states=new States(rs.getInt(1),rs.getString(2));

				statelist.add(states);
			}


		}
		catch(SQLException s) 

		{

			System.out.println(s);
		}

		return statelist;
	}
	
	public States findStateById(int stateid)
	{
		States sts = null;
		connection=DbConnection.getConnection();
		try {
			ps=connection.prepareStatement("select * from states where state_id = ?");
			ps.setInt(1, stateid);
			ResultSet rs=ps.executeQuery();
			while(rs.next())
			{
				sts=new States(rs.getInt(1), rs.getString(2));
			}
		}
		catch(SQLException s) 
		{
			System.out.println(s);
		}
		return sts;
	}
	
	public void updateState(States stds)
	{
		connection=DbConnection.getConnection();
		try {
			ps=connection.prepareStatement("update States set state_name = ? where state_id = ?");
			ps.setString(1, stds.getStateName());
			ps.setInt(2, stds.getStateId());
			updateresult = ps.executeUpdate();
		}
		catch(SQLException s) 
		{
			System.out.println(s);
		}
	}
	
	public int deleteState(String state_name) 
	{
		boolean flag=false;
		connection=DbConnection.getConnection();
		try {
			ps=connection.prepareStatement("delete from states where state_name=?");
			ps.setString(1, state_name);

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
