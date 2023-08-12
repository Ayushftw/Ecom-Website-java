 package pack1;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;



import jakarta.servlet.*;
import jakarta.servlet.http.*;


import jakarta.servlet.annotation.WebServlet;




/**
 * Servlet implementation class LoginServlet
 */
	@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/ecommerce?useSSL=false","root","root");
			String e= request.getParameter("email");
			String p= request.getParameter("password");
			
			PreparedStatement ps = con.prepareStatement("select email from customer where email=? and password=?");
			ps.setString(1,e);
			ps.setString(2,p);
			
			ResultSet rs = ps.executeQuery();
			if(rs.next()) {
				// String customerEmail = request.getParameter("email");
			       // request.setAttribute("email", e);
			         
				HttpSession session = request.getSession();
				session.setAttribute("email", e);
				//response.sendRedirect("Index.jsp");	
			//System.out.println("Success!!");
			        RequestDispatcher dispatcher = request.getRequestDispatcher("Index.jsp");
			        dispatcher.forward(request, response);
			
			}
			else {
				PrintWriter output = response.getWriter();
				output.println("Wrong  Email or Password!!");
				}
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
