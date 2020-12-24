package com.servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dao.ProductService;
import com.model.Product;

/**
 * Servlet implementation class Retrieve
 */
@WebServlet("/Retrieve")
public class Retrieve extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.setContentType("text/html");
		Product find = new Product();
		ProductService ps = new ProductService();
		
		find.setProductId(Integer.parseInt(request.getParameter("productID")));
		System.out.println("before retrieve method");
		Product temp = ps.RetrieveProduct(find);
		
		find.setProductId(temp.getProductId());
		
		if (find.getProductId() == 0) {
			response.sendRedirect("home.html");
			
		}else 
		{
			System.out.println(find.toString());
			response.sendRedirect("dashboard.html");
		}
		
		
	}

}
