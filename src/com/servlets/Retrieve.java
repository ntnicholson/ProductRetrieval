package com.servlets;

import java.io.IOException;
import java.io.PrintWriter;

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
		
		Product find = new Product();
		ProductService ps = new ProductService();
		
		find.setProductId(Integer.parseInt(request.getParameter("productID")));
		Product search = ps.RetrieveProduct(find);
		
		//Display result to user
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		
		if (search.getProductId() == 0) {
			
			out.println("<h1>[Error] Product ID #" + find.getProductId() + " could not be found.</h1>");
			out.print("Click the button to search for a new Product.<br/>");
			out.print("<a href='product.html'><button>Search</button></a>");
		}
		else 
		{
			out.println("<h1>Product Details</h1><br/>");
			out.print(
					"<table border=1 border-collapse=collapse width=90%>"
							+ "<tr>"
								+ "<th>ID</th>"
								+ "<th>Name</th>"
								+ "<th>Price</th>"
							+ "<tr/>"
							+ "<tr>"
								+ "<td>" + search.getProductId() + "</td>"
								+ "<td>" + search.getName() + "</td>"
								+ "<td>" + search.getPrice() + "</td>"
							+ "<tr/>"
				+ "</table><br/>");
			out.print("Click the button to search for a new Product.<br/>");
			out.print("<a href='product.html'><button>Search</button></a>");
		}
	}

}
