package allAccess.DAO;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import allAccessModel.Payment;
import allAccessdbconnection.DbConnection;

public class PaymentDAO {
	
	Connection connection;
	PreparedStatement preparedStatement;
	
	int insertResult,deleteResult;

	public int addPayemnt(Payment payment) {

		connection = DbConnection.getConnection();

		try {

			preparedStatement = connection.prepareStatement("INSERT into Payment (Payment_Id, Payment_Amount, Payment_Date,Payment_Due_Date,shop_Id) values(?,?,?,?,?)");
			preparedStatement.setInt(1,payment.getPaymentID());
			preparedStatement.setInt(2,payment.getPaymentAmount());
			preparedStatement.setDate(3, (Date) payment.getPaymentDate());
			preparedStatement.setDate(4,(Date) payment.getPaymentDueDate());
			preparedStatement.setInt(5,payment.getShopID());

			insertResult=preparedStatement.executeUpdate();

			if(insertResult>0) {
				System.out.println("Payment Added");
			}	
		}
		catch(SQLException s) {
			System.out.println(s);
		}
		return insertResult;
	}
	
	

	List<Payment> displayAllPayments(){

		List<Payment> paymentList=new ArrayList<Payment>();
		Payment payment = null;

		connection=DbConnection.getConnection();
		try {
			preparedStatement=connection.prepareStatement("select * from Payment");
			ResultSet res=preparedStatement.executeQuery();

			while(res.next())
			{
				payment =new Payment(res.getInt(1),res.getInt(2),res.getDate(3),res.getDate(4),res.getInt(5));
				paymentList.add(payment);
			}
		}
		catch(SQLException s){
			System.out.println(s);
		}
		return paymentList ;
	}

	
	public Payment findSpecificPayment(int paymentId)
	{
		Payment payment = null;
		connection=DbConnection.getConnection();
		try {
			preparedStatement=connection.prepareStatement("select * from Payment where Payment_id = ?");
			preparedStatement.setInt(1, paymentId);
			ResultSet res=preparedStatement.executeQuery();
			while(res.next())
			{
				payment =new Payment(res.getInt(1),res.getInt(2),res.getDate(3),res.getDate(4),res.getInt(5));

			}
		}
		catch(SQLException s) 
		{
			System.out.println(s);
		}
		return payment;
	}
	

	
	public int deletePayment(int paymentId) 
	{
		connection=DbConnection.getConnection();
		try {
			preparedStatement=connection.prepareStatement("delete from Payment where Payment_Id =?");
			preparedStatement.setInt(1,paymentId);

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
