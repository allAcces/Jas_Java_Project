package com.all.access.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import com.all.access.model.City;
import com.all.access.dbconnection.DbConnection;

public class CityDAO 
{
	Connection connection;
	PreparedStatement preparedStatement;
	int insertresult,updateresult,deleteresult;
	City city;

	public int insertcities(City cities) 
	{
		connection=DbConnection.getConnection();

		try {	 

			preparedStatement=connection.prepareStatement("insert into City(city_id,City_name,state_id) values(?,?,?)");


			preparedStatement.setInt(1,cities.getCityId());
			preparedStatement.setString(2,cities.getCityName());
			preparedStatement.setInt(3,cities.getCityId());

			insertresult=preparedStatement.executeUpdate();

			if(insertresult>0) {
				System.out.println("New City inserted");
			}
		}
		catch(SQLException s) {
			System.out.println(s);
		}
		return insertresult;
	}

	List<City> displayAllCities(){

		List<City> citylist=new ArrayList<City>();

		City cities=null;
		connection=DbConnection.getConnection();
		try {
			preparedStatement=connection.prepareStatement("select * from CITY");


			ResultSet rs=preparedStatement.executeQuery();


			while(rs.next())
			{

				//cities=new City(rs.getInt(1),rs.getString(2),rs.getString(3));

				citylist.add(cities);
			}


		}
		catch(SQLException s) 

		{

			System.out.println(s);
		}

		return citylist;
	}

	public City findCityById(int city_id)
	{
		City city = null;
		connection=DbConnection.getConnection();
		try {
			preparedStatement=connection.prepareStatement("select * from CITY where city_id = ?");
			preparedStatement.setInt(1, city_id);
			ResultSet rs=preparedStatement.executeQuery();
			while(rs.next())
			{
				//city=new City(rs.getInt(1), rs.getString(2));
			}
		}
		catch(SQLException s) 
		{
			System.out.println(s);
		}
		return city;
	}

	public void updateCities(City ct)
	{
		connection=DbConnection.getConnection();
		try {
			preparedStatement=connection.prepareStatement("update CITY set City_name = ? where city_id = ?");
			preparedStatement.setString(1, ct.getCityName());
			preparedStatement.setInt(2, ct.getCityId());
			updateresult = preparedStatement.executeUpdate();
		}
		catch(SQLException s) 
		{
			System.out.println(s);
		}
	}

	public int deleteCity(String city_name) 
	{
		boolean flag=false;
		connection=DbConnection.getConnection();
		try {
			preparedStatement=connection.prepareStatement("delete from states where city_name=?");
			preparedStatement.setString(1, city_name);

			deleteresult =	preparedStatement.executeUpdate();

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
