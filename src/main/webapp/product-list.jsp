<%@page import="com.entity.Product"%>
<%@page import="java.util.List"%>
<%@page import="com.dao.ProductDAO"%>
<%@page import="com.conn.DBConnect"%>
<%@page import="java.sql.Connection"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page isELIgnored="false" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<%@include file="CssProducts.jsp" %>
</head>
<body  class="bg-light">
<%@include file="navProducts.jsp" %> 

<!--Connection conn = DBConnect.getConn();
out.print(conn);
-->


<div class="container p-3">
<p class ="text-center fs-1"> All Products Details</p>
 <c:if test="${not empty succMsg}">
                     <p class="text-center text-success">${succMsg}</p>
                     <c:remove var="succMsg" />
                     </c:if>
                     <c:if test="${not empty errorMsg}">
                     <p class="text-center text-success">${succMsg}</p>
                     <c:remove var="errorMsg" />
                     </c:if>

<table class="table">
  <thead>
    <tr>
      <th scope="col">Product Name</th>
      <th scope="col">Quantity</th>
      <th scope="col">UnitPrice</th>
      <th scope="col">Action</th>
    </tr>
  </thead>
  <tbody>
  
  <%
     ProductDAO dao = new ProductDAO(DBConnect.getConn());
    // List<Product> list = dao.getAllProducts();
      //for(Product p :list){
      
    	  List <Product> list = dao.getAllProducts();
    	  for(Product p : list){
  %>
  
      <tr>
      <th scope="row"><%=p.getProductName() %></th>
      <td><%=p.getQuantity()%></td>
      <td><%=p.getUnitPrice()%> </td>
     
      <td><a href="EditProducts.jsp?Pid=<%=p.getPid()%>" class= "btn btn-sm btn-primary">Edit</a>
           <a href="delete?Pid=<%=p.getPid()%>" class="btn btn-sm btn-danger ms-1">Delete</a>
 </td>
    </tr>
    <%} %>
  </tbody>
</table>

</div>


</body>
</html>