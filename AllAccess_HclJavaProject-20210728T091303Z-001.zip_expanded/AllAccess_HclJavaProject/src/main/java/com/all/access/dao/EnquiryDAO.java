package allAccess.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import allAccessModel.Enquiry;
import allAccessdbconnection.DbConnection;

public class EnquiryDAO {

	Connection connection;
	PreparedStatement preparedStatement;
	
	List<Enquiry> showAllEnqueries(){

		List<Enquiry> enquiryList=new ArrayList<Enquiry>();
		Enquiry enquiry = null;

		connection=DbConnection.getConnection();
		try {
			preparedStatement=connection.prepareStatement("select * from Enquiry");
			ResultSet res=preparedStatement.executeQuery();

			while(res.next())
			{
				enquiry =new Enquiry(res.getInt(1),res.getString(2),res.getDate(3),res.getString(4),res.getDate(5),res.getInt(6),res.getInt(7));
				enquiryList.add(enquiry);
			}
		}
		catch(SQLException s){
			System.out.println(s);
		}
		return enquiryList ;
	}
	
	
	
	
	public Enquiry findSpeceficEnquiry(int enquiryId)
	{
		Enquiry enquiry = null;
		connection=DbConnection.getConnection();
		try {
			preparedStatement=connection.prepareStatement("select * from Enquiry where Enquiry_id = ?");
			preparedStatement.setInt(1, enquiryId);
			ResultSet res=preparedStatement.executeQuery();
			while(res.next())
			{
				enquiry =new Enquiry(res.getInt(1),res.getString(2),res.getDate(3),res.getString(4),res.getDate(5),res.getInt(6),res.getInt(7));
			}
		}
		catch(SQLException s) 
		{
			System.out.println(s);
		}
		return enquiry;
	}
	
}
