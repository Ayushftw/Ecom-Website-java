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
 * Servlet implementation class DeleteServlet
 */
@WebServlet("/delete")
public class DeleteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		int Pid = Integer.parseInt(request.getParameter("Pid"));
		
		ProductDAO dao = new ProductDAO(DBConnect.getConn());
		boolean f=dao.deleteProduct(Pid);
		  
		HttpSession session=request.getSession();
  
        if(f) {
        	session.setAttribute("succMsg", "Products Details Deleted sucessfully..");
        	response.sendRedirect("product-list.jsp");
        	System.out.println("Success");

        }
        else {
        	session.setAttribute("errorMsg", "Products Details Not Deleted");
        	response.sendRedirect("product-list.jsp");
        	System.out.println("Error!!");

        }


	}
	}
