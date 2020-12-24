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
		Product result = new Product();
		result.setProductId(0); //Flag: # should be greater than 0.
		
		try {
			DBCon db = new DBCon();
			Connection conn = db.getConnection();
			
			//Write the Statement
			PreparedStatement pst = conn.prepareStatement(sql);
			pst.setInt(1, find.getProductId());
			System.out.println(pst.toString());
			
			//Execute the statement		
			ResultSet rs = pst.executeQuery();	
			
			while (rs.next()) 
			{
				result.setProductId(rs.getInt(1));
				result.setName(rs.getString(2));
				result.setPrice(rs.getDouble(3));
			}
			conn.close();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result;
	}
}
