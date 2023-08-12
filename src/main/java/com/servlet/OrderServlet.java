package com.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import org.apache.catalina.ha.backend.Sender;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import com.entity.Product;

import jakarta.servlet.*;
import jakarta.servlet.http.*;


/**
 * Servlet implementation class OrderServlet
 */
@WebServlet("/OrderServlet")
public class OrderServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
Connection con = null;
PreparedStatement psInsert = null;
PreparedStatement psUpdate = null;
	
try {
    Class.forName("com.mysql.cj.jdbc.Driver");
    con = DriverManager.getConnection("jdbc:mysql://localhost:3306/ecommerce?useSSL=false", "root", "root");
    
    int Pid = Integer.parseInt(request.getParameter("Pid"));
    int UnitsPurchased = Integer.parseInt(request.getParameter("UnitsPurchased"));
    int Price = Integer.parseInt(request.getParameter("Price"));
    int Quantity = Integer.parseInt(request.getParameter("Quantity"));
  //  String e= request.getParameter("e");
    int UpdatedQuantity = Quantity - UnitsPurchased;
    
    HttpSession session = request.getSession();
    String email = (String) session.getAttribute("email");
    // Insert the order into the orderT table
    psInsert = con.prepareStatement("INSERT INTO orderss (product_id,UnitsPurchased,customer_email) VALUES(?,?,?)");
    psInsert.setInt(1, Pid);
    psInsert.setInt(2, UnitsPurchased);
    psInsert.setString(3, email);
    int rowCountInsert = psInsert.executeUpdate();
    
    // Update the product table with the new quantity
    psUpdate = con.prepareStatement("UPDATE product SET Quantity = ? WHERE Pid = ?");
    psUpdate.setInt(1, UpdatedQuantity);
    psUpdate.setInt(2, Pid);
    int rowCountUpdate = psUpdate.executeUpdate();
    
    if (rowCountInsert > 0 && rowCountUpdate > 0) {
        System.out.println("Success!!");
        request.setAttribute("UnitsPurchased", UnitsPurchased);
        request.setAttribute("Price", Price);
        RequestDispatcher dispatcher = request.getRequestDispatcher("OrderSuccessfull.jsp");
        dispatcher.forward(request, response);
    } else {
        System.out.println("Failed!!");
    }
} catch (ClassNotFoundException | SQLException e) {
    e.printStackTrace();
} finally {
    try {
        if (psInsert != null) {
            psInsert.close();
        }
        if (psUpdate != null) {
            psUpdate.close();
        }
        if (con != null) {
            con.close();
        }
    } catch (SQLException e) {
        e.printStackTrace();
    }
}
			
			
			
			
}
}