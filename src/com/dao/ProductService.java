package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.dal.DBCon;
import com.model.Product;

public class ProductService 
{

	public Product RetrieveProduct(Product find) 
	{
		String sql = "SELECT * from Product WHERE (?) = productID";
		Product p = new Product();
		
		try {
			DBCon db = new DBCon();
			Connection conn = db.getConnection();
			System.out.println("Connection: " + conn.toString());
			
			//Write the Statement
			System.out.println(sql);
			PreparedStatement pst = conn.prepareStatement(sql);
			pst.setInt(1, find.getProductId());
			
			//Execute the statement		
			ResultSet rs = pst.executeQuery();	
			
			while (rs.next()) 
			{
				p.setProductId(rs.getInt(1));
				p.setName(rs.getString(2));
				p.setPrice(rs.getDouble(3));
			}
			
			conn.close();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return p;
	}
}
