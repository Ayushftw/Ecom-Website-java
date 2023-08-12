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
 * Servlet implementation class SignUpServlet
 */
@WebServlet("/SignUpServlet")
public class SignUpServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	  
     // RequestDispatcher dispatcher = null;
      Connection con = null;
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			 con = DriverManager.getConnection("jdbc:mysql://localhost:3306/ecommerce?useSSL=false","root","root");
			
			String n= request.getParameter("name");
			String e= request.getParameter("email");
			String pn= request.getParameter("phonenumber");
		    String a= request.getParameter("address");
			String ci= request.getParameter("city");
			String co= request.getParameter("country");
			String p= request.getParameter("password");
			
			
			
			PreparedStatement ps = con.prepareStatement("insert into customer(name, email,Phone_Number,Address, city,country,Password)values(?,?,?,?,?,?,?)");
			ps.setString(1,n);
			ps.setString(2,e);
			ps.setString(3,pn);
			ps.setString(4,a);
			ps.setString(5,ci);
			ps.setString(6,co);
			ps.setString(7,p);
			
				
			int rowCount = ps.executeUpdate();
			//dispatcher =request.getRequestDispatcher("Index.html");
			
			if(rowCount>0) {
				request.setAttribute("status", "success");
				response.sendRedirect("Index.html");	
				
				
			//System.out.println("Success!!");
			}
			else {
				request.setAttribute("status", "failed");
				}
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			try {
				con.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
			
	}

}
