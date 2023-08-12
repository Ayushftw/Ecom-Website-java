<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page isELIgnored="false" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body class="bg-light">
<%@include file="navProducts.jsp" %>
<%@include file="CssProducts.jsp" %>
<div class= "container p-4">
    <div class="row">
        <div class= "col-md-6 offset-md-3">
            <div class= "card">
                <div class= "card-body">
                     <p class="fs-3 text-center">Add Student</p>
                     
                     <c:if test="${not empty succMsg}">
                     <p class="text-center text-success">${succMsg}</p>
                     <c:remove var="succMsg" />
                     </c:if>
                     <c:if test="${not empty errorMsg}">
                     <p class="text-center text-success">${succMsg}</p>
                     <c:remove var="errorMsg" />
                     </c:if>

  <form action="register" method="post">
  <div class="mb-3">
    <label  class="form-label">Product Name</label>
    <input type="text" name="ProductName"  class="form-control">
    </div>
  <div class="mb-3">
    <label class="form-label">Description</label>
    <textarea name="Description" class="form-control"></textarea>
</div>
    <div class="mb-3">
  <label  class="form-label">Quantity</label>
    <input type="number"  name="Quantity"  class="form-control">
    </div>
  <div class="mb-3">
    <label  class="form-label"> UnitPrice</label>
    <input type="number" name="UnitPrice" class="form-control">
    </div>
  
  <button type="submit" class="btn btn-primary col-md-12">Submit</button>
</form>


</body>
</html>