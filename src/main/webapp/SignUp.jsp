<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="alert/dist/sweetalert.css">
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<input type="hidden" id="status" value="<%= request.getAttribute("status") %>">

<body>
<%@ include file="nav.jsp" %>
	

<div align= center>
<h1>SignUp</h1>
<form action="SignUpServlet" method=post>
<table>
<tr><td> Enter Name:</td><td><input type=text name=name></td></tr>
<tr><td> Enter Email:</td><td><input type=email name=email></td></tr>
<tr><td> Enter Phone Number:</td><td><input type=tel name=phonenumber></td></tr>
<tr><td> Enter Address:</td><td><input type=text name=address></td></tr>
<tr><td> Enter City:</td><td><input type=text name=city></td></tr>
<tr><td> Enter Country:</td><td><input type=text name=country></td></tr>
<tr><td> Enter Password:</td><td><input type=password name=password></td></tr>
<tr><td><input type=submit value=SignUp></td><td><a href="login.jsp">Login</a></td></tr>
</table>
</form>

</div>
<script src="https://unpkg.com/sweetalert/dist/sweetalert.min.js"></script>
	
	<script type = "text/javascript">
	var status =documnet.getElementById("status").value;
	if(status == "success"){
		swal("Congrats", "Account Created Successfully");
	}
	</script>
	
</body>
</html>