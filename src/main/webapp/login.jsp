<%@page import="java.sql.Connection"%>
<%@page import="java.sql.DriverManager"%>
	
	<%@ page language="java" contentType="text/html; charset=UTF-8" 
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>

<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<%@ include file="nav.jsp" %>
<body>


<div align=center>
<h1>User Login</h1>
<form action="LoginServlet" method=post>
<table>

<tr><td> Enter Email:</td><td><input type=email name=email></td></tr>
<tr><td> Enter Password:</td><td><input type=password name=password></td></tr>
<tr><td><input type=submit value=Login></td><td><a href="SignUp.jsp">SignUp</a></td></tr>
</table>
</form>
</div>

</body>
</html>