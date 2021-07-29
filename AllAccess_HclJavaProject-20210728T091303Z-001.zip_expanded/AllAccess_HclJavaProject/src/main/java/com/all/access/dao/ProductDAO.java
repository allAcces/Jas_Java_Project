package com.all.access.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import com.all.access.dbconnection.DbConnection;
import com.all.access.model.Products;

public class ProductDAO 
{
	Connection connection;
	PreparedStatement ps;
	int insertresult,updateresult,deleteresult;
	
	public int insertProduct(Products prod) 
	{
		connection=DbConnection.getConnection();

		try {	 
			
		ps=connection.prepareStatement("insert into PRODUCT(product_id,product_title,price,product_manufacturing_date,vat,discount,Stock) values(?,?,?,?,?,?,?)");


		ps.setInt(1,prod.getProductId());
		ps.setString(2,prod.getProductTitle());
		ps.setFloat(3,prod.getPrice());
		//ps.setDate(4,prod.getProductManufacturingDate());
		ps.setFloat(5,prod.getVat());
		ps.setFloat(6,prod.getDiscount());
		ps.setInt(7,prod.getStock());

		insertresult=ps.executeUpdate();

		if(insertresult>0) {
			System.out.println("New Product inserted");
		}
		}
		catch(SQLException s) {
			System.out.println(s);
		}
		return insertresult;
	}
	
	List<Products> displayAllProducts(){

		List<Products> prodlist=new ArrayList<Products>();

		Products prods=null;
		connection=DbConnection.getConnection();
		try {
			ps=connection.prepareStatement("select * from PRODUCT");


			ResultSet rs=ps.executeQuery();


			while(rs.next())
			{

				prods=new Products(rs.getInt(1),rs.getString(2),rs.getFloat(3),rs.getDate(4),rs.getFloat(5),rs.getFloat(6),rs.getInt(7));

				prodlist.add(prods);
			}


		}
		catch(SQLException s) 

		{

			System.out.println(s);
		}

		return prodlist;
	}
	
	public Products findProductById(int product_id)
	{
		Products prod = null;
		connection=DbConnection.getConnection();
		try {
			ps=connection.prepareStatement("select * from PRODUCT where product_id = ?");
			ps.setInt(1, product_id);
			ResultSet rs=ps.executeQuery();
			while(rs.next())
			{
				prod=new Products(rs.getInt(1),rs.getString(2),rs.getFloat(3),rs.getDate(4),rs.getFloat(5),rs.getFloat(6),rs.getInt(7));
			}
		}
		catch(SQLException s) 
		{
			System.out.println(s);
		}
		return prod;
	}
	
	public void updateProduct(Products prods)
	{
		connection=DbConnection.getConnection();
		try {
			ps=connection.prepareStatement("update PRODUCT set price = ? , vat = ? where product_title = ?");
			ps.setFloat(1,prods.getPrice());
			ps.setFloat(2,prods.getVat());
			ps.setString(3, prods.getProductTitle());
			updateresult = ps.executeUpdate();
		}
		catch(SQLException s) 
		{
			System.out.println(s);
		}
	}
	
	public int deleteProduct(String product_title) 
	{
		connection=DbConnection.getConnection();
		try {
			ps=connection.prepareStatement("delete from PRODUCT where product_title=?");
			ps.setString(1, product_title);

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
