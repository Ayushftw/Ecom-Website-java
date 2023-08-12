<%@ page language="java" contentType="text/html; charset=UTF-8" 
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
    <%

String e = (String) session.getAttribute("email");
                     
%>
<style>
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
    </style>	
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

</body>
</html>