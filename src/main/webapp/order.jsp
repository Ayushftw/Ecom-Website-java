<%@page import="com.entity.Product"%>
<%@page import="com.conn.DBConnect"%>
<%@page import="com.dao.ProductDAO"%>
<%@page import="pack1.LoginServlet"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
  
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
     <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-9ndCyUaIbzAi2FUVXJi0CjmCapSmO7SnpJef0486qhLnuZ2cdeRhO02iuK6FUUVM" crossorigin="anonymous">
     <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.bundle.min.js" integrity="sha384-geWF76RCwLtnZ8qwWowPQNguL3RmwHVBC9FhGdlKrxdiJJigb/j/68SIy3Te4Bkz" crossorigin="anonymous"></script>
       <style>
       #Quantity {
  font-weight: bold;
}
</style>
</head>

<body>
<%-- <script id="replace_with_navbar" src="nav.js"></script>
--%><%@ include file="nav.jsp" %>
                 <%
                  int Pid = Integer.parseInt(request.getParameter("Pid"));
                  ProductDAO dao= new ProductDAO(DBConnect.getConn());
                  Product p = dao.getProductById(Pid);
                     
                     %>
                     <%

String email = (String) session.getAttribute("email");
                     
%>

    <form action="OrderServlet" method=post> 
    <div class="card mb-3" style="max-width: 1000%;">
  <div class="row g-0">
    <div class="col-md-4">
      <img src="https://i.gadgets360cdn.com/products/large/redmi-note-12-5g-pro-plus-db-gadgets360-800x600-1673019783.jpg" class="img-fluid rounded-start" alt="...">
    </div>
    <div class="col-md-8">
      <div class="card-body">
        <h5 class="card-title">ProductName:<%=p.getProductName() %></h5>
         <input type="hidden" name="Pid" value=<%=p.getPid() %>>
          <input type="hidden" name="Quantity" value=<%=p.getQuantity()%>>
          <input type="hidden" name="Price" value="<%= p.getUnitPrice() %>">
    		    <h6 class="card-title">Price:<%=p.getUnitPrice()%></h6>
    		    <h6 class="card-title">Quantity:<%=p.getQuantity()%></h6>
    		   <label id="UnitsPurchased">Order Units</label>  
               <input type="number" name="UnitsPurchased" max=<%=p.getQuantity() %>>
    			    <p class="card-text">Product Description: "The sun slowly dipped below the horizon, casting a warm golden glow across </p>
    		    <div class="mt-3 d-flex justify-content: space-between">
    		    <input type="submit" name="Buy Now">
      </div>
    </div>
  </div>
</div>
</div>
</form>
</body>
</html>