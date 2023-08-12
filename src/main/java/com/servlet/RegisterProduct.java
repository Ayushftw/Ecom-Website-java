package com.servlet;

import java.io.IOException;

import com.conn.DBConnect;
import com.dao.ProductDAO;
import com.entity.Product;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

/**
 * Servlet implementation class RegisterProduct
 */
@WebServlet("/register")
public class RegisterProduct extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String  ProductName = request.getParameter("ProductName");
		String  Description = request.getParameter("Description");
		int Quantity = Integer.parseInt(request.getParameter("Quantity"));
		int UnitPrice = Integer.parseInt(request.getParameter("UnitPrice"));
		
        Product product = new Product (ProductName,Description, Quantity, UnitPrice);
        
        ProductDAO dao = new ProductDAO( DBConnect.getConn());
        HttpSession session=request.getSession();

        
        
        boolean f=dao.addProduct(product);
	
          
        if(f) {
        	session.setAttribute("succMsg", "Products Details submit sucessfully..");
        	response.sendRedirect("AddProducts.jsp");
        	System.out.println("Success");

        }
        else {
        	session.setAttribute("errorMsg", "Products Details Not Submitted");
        	response.sendRedirect("AddProducts.jsp");
        	System.out.println("Error!!");

        }
 	}

}
