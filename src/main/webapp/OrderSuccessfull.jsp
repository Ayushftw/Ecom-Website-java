<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
 <style>
        body {
            font-family: Arial, sans-serif;
            background-color: #f5f5f5;
        }
        .container {
            max-width: 600px;
            margin: 0 auto;
            padding: 20px;
            background-color: #fff;
            border-radius: 5px;
            box-shadow: 0 2px 5px rgba(0, 0, 0, 0.1);
        }
        h1 {
            color: #2ecc71;
        }
    </style>
</head>
<body>
<% 
        // Retrieve the UnitsPurchased attribute
        int unitsPurchased = (int) request.getAttribute("UnitsPurchased");
        int Price = (int) request.getAttribute("Price");
        
        // Perform your calculations using the unitsPurchased value
        int TotalAmount = unitsPurchased * Price;%>
    <div class="container">
        <h1>Order Successful</h1>
        <p>Your order has been placed successfully. Thank you for shopping with us!</p>
         <p>Total Amount: Rs.<%= TotalAmount %></p>
        <p><a href="Index.jsp">Continue Shopping</a></p>
    </div>
</body>
</html>