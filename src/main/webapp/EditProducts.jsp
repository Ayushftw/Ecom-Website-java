<%@page import="com.entity.Product"%>
<%@page import="java.util.List"%>
<%@page import="com.dao.ProductDAO"%>
<%@page import="com.conn.DBConnect"%>
<%@page import="java.sql.Connection"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<%@include file="CssProducts.jsp" %>
</head>
<body class="bg-light">
<%@include file="navProducts.jsp" %>

<div class= "container p-4">
    <div class="row">
        <div class= "col-md-6 offset-md-3">
            <div class= "card">
                <div class= "card-body">
                     <p class="fs-3 text-center">Edit Product</p>
                     
                     <%
                     int Pid = Integer.parseInt(request.getParameter("Pid"));
                     ProductDAO dao = new ProductDAO(DBConnect.getConn());
                     Product p = dao.getProductById(Pid);
                     
                     %>
                     
                     
	                   

  <form action="update" method="post">
  <div class="mb-3">
    <label  class="form-label">Product Name</label>
    <input type="text" value = "<%=p.getProductName() %>"  name="ProductName"  class="form-control">
    </div>
  <div class="mb-3">
    <label  class="form-label">Product Description</label>
    <input type="text" value = "<%=p.getDescription() %>"  name="Description"  class="form-control">
    </div>
  <div class="mb-3">
  <label  class="form-label">Quantity</label>
    <input type="number"  value = "<%=p.getQuantity() %>" name="Quantity"  class="form-control">
    </div>
  <div class="mb-3">
    <label  class="form-label"> UnitPrice</label>
    <input type="number" value="<%=p.getUnitPrice() %>"  name="UnitPrice" class="form-control">
    </div>
    
    <input type="hidden" name="Pid"  value ="<%=p.getPid() %>">
  
  <button type="submit" class="btn btn-primary col-md-12">Update</button>
</form>


</body>
</html>