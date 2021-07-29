package allAccess.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import allAccessModel.Area;
import allAccessdbconnection.DbConnection;

public class AreaDAO {

	Connection connection;
	PreparedStatement preparedStatement;
	int insertResult,updateResult,deleteResult;

	public int insertArea(Area area) {

		connection = DbConnection.getConnection();

		try {

			preparedStatement = connection.prepareStatement("INSERT into Area (Area_Id, Area_Name, City_Id) values(?,?,?)");
			preparedStatement.setInt(1,area.getAreaID());
			preparedStatement.setString(2,area.getAreaName());
			preparedStatement.setInt(3,area.getCityID());

			insertResult=preparedStatement.executeUpdate();

			if(insertResult>0) {
				System.out.println("New Area Inserted");
			}	
		}
		catch(SQLException s) {
			System.out.println(s);
		}
		return insertResult;
	}
	
	

	List<Area> displayAllArea(){

		List<Area> areaList=new ArrayList<Area>();
		Area area = null;

		connection=DbConnection.getConnection();
		try {
			preparedStatement=connection.prepareStatement("select * from Area");
			ResultSet res=preparedStatement.executeQuery();

			while(res.next())
			{
				area =new Area(res.getInt(1),res.getString(2),res.getInt(3));
				areaList.add(area);
			}
		}
		catch(SQLException s){
			System.out.println(s);
		}
		return areaList ;
	}

	

	public Area findAreaById(int areaId)
	{
		Area area = null;
		connection=DbConnection.getConnection();
		try {
			preparedStatement=connection.prepareStatement("select * from Area where Area_id = ?");
			preparedStatement.setInt(1, areaId);
			ResultSet res=preparedStatement.executeQuery();
			while(res.next())
			{
				area=new Area(res.getInt(1), res.getString(2),res.getInt(3));
			}
		}
		catch(SQLException s) 
		{
			System.out.println(s);
		}
		return area;
	}
	
	
	
	public void updateArea(Area area)
	{
		connection=DbConnection.getConnection();
		try {
			preparedStatement=connection.prepareStatement("update Area set Area_Name = ?,City_Id = ? where Area_Id = ?");
			preparedStatement.setString(1, area.getAreaName());
			preparedStatement.setInt(3, area.getCityID());
			preparedStatement.setInt(2, area.getAreaID());
			updateResult = preparedStatement.executeUpdate();
		}
		catch(SQLException s) 
		{
			System.out.println(s);
		}
	}
	
	
	
	public int deleteArea(String area_name) 
	{
		connection=DbConnection.getConnection();
		try {
			preparedStatement=connection.prepareStatement("delete from Area where Area_Name=?");
			preparedStatement.setString(1, area_name);

			deleteResult =	preparedStatement.executeUpdate();

			if(deleteResult>0) 
			{
				deleteResult=1;
			}
		} catch (SQLException e) {

			e.printStackTrace();
		}
		return deleteResult;
	}

}
