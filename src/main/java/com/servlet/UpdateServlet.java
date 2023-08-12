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
 * Servlet implementation class UpdateServlet
 */
@WebServlet("/update")
public class UpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			
		String  ProductName = request.getParameter("ProductName");
		String  Description = request.getParameter("Description");
		int Quantity = Integer.parseInt(request.getParameter("Quantity"));
		int UnitPrice = Integer.parseInt(request.getParameter("UnitPrice"));
		int Pid = Integer.parseInt(request.getParameter("Pid"));
		
        Product product = new Product (ProductName, Description,Quantity, UnitPrice,Pid);
        
        ProductDAO dao = new ProductDAO( DBConnect.getConn());
        HttpSession session=request.getSession();
        
        
        boolean f=dao.updateProduct(product);
        
        if(f) {
        	session.setAttribute("succMsg", "Products Details Updated sucessfully..");
        	response.sendRedirect("product-list.jsp");
        	System.out.println("Success");

        }
        else {
        	session.setAttribute("errorMsg", "Products Details Not Updated");
        	response.sendRedirect("product-list.jsp");
        	System.out.println("Error!!");

        }

	}

}
