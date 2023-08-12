<%@page import="com.entity.Product"%>
<%@page import="java.util.List"%>
<%@page import="com.conn.DBConnect"%>
<%@page import="com.dao.ProductDAO"%>
<%@ page import="jakarta.servlet.http.HttpSession" %>
<%@ page import="jakarta.servlet.http.HttpServletRequest" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
 <title>E-commerce Website</title>
   <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
     <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-9ndCyUaIbzAi2FUVXJi0CjmCapSmO7SnpJef0486qhLnuZ2cdeRhO02iuK6FUUVM" crossorigin="anonymous">
     <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.bundle.min.js" integrity="sha384-geWF76RCwLtnZ8qwWowPQNguL3RmwHVBC9FhGdlKrxdiJJigb/j/68SIy3Te4Bkz" crossorigin="anonymous"></script>
      <style>
    /* Add your CSS styles here */
    body {
      font-family: Arial, sans-serif;
    }
    nav {
      background-color: #f2f2f2;
      padding: 10px;
    }
    nav ul {
      list-style-type: none;
      margin: 0;
      padding: 0;
      overflow: hidden;
    }
    nav li {
      display: inline;
      margin-right: 20px;
    }
    nav a {
      text-decoration: none;
      color: #333;
    }
    .container {
      max-width: 960px;
      margin: 0 auto;
      padding: 20px;
    }
    footer {
      background-color: #f2f2f2;
      padding: 10px;
      text-align: center;
    }
  </style>
</head>
<body>
 <%
     ProductDAO dao = new ProductDAO(DBConnect.getConn());
   List <Product> list = dao.getAllProducts();
   for(Product p:list);
 
  %>
 <%

String email = (String) session.getAttribute("email");
%>
<%-- <h1>Welconme :<%=e %></h1>
--%>
  <nav>
    <div class="container">
      <ul>
        <li><a href="Index.jsp">Home</a></li>
        <li><a href="#">Search</a></li>
       <li><a href="login.jsp">Login</a></li>
       
       <% if (session.getAttribute("email") != null) { %>
        <li><a href="logout">Logout</a>
         <li><a href="SignUp.jsp">Signup</a></li>
        <% } %>
        
      </ul>
    </div>
  </nav>
  <div class="container">
  <div class="card-header my-3">All Products</div>
  <div class="row">
  <%
    if(!list.isEmpty()){
    	for(Product p:list){%>
    		  <div class = "col-md-3">
    		  <div class="card w-100" style="width: 18rem;">
    		  <img src="..." class="card-img-top" alt="...">
    		  <div class="card-body">
    		    <h5 class="card-title"><%=p.getProductName() %></h5>
    		    <h6 class="Price">Price:<%=p.getUnitPrice()%></h6>
    			    <p class="card-text">Product Description: "The sun slowly dipped below the horizon, casting a warm golden glow across </p>
    		    <div class="mt-3 d-flex justify-content: space-between">
    		    <% if (session.getAttribute("email") != null) { %>
                  <a href="order.jsp?Pid=<%= p.getPid() %>" class="btn btn-primary">Buy Now</a>
                <% } else { %>
                 <a href="login.jsp" class="btn btn-secondary">Login to Buy</a>
                 
                <% } %>	
    		    </div>
    		    </div>
    		    </div>
    		  </div>
    	<%}
    }
  %>

  </div>
  </div>
  
  <footer>
    <div class="container">
      <p>&copy; 2023 Your E-commerce Website. All rights reserved.</p>
    </div>
  </footer>
</body>
</html>
