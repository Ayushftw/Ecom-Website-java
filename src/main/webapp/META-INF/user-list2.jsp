<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
 <table class="table table-bordered">
                        <thead>
                            <tr>
                                <th>ID</th>
                                <th>Name</th>
                                <th>Email</th>
                                <th>Country</th>
                                <th>Actions</th>
                            </tr>
                        </thead>
                        <tbody>
                            <!--   for (Todo todo: todos) {  -->
                           <c:forEach var="product" items="${listProduct}">

                                <tr>
                                    <td>
                                        <c:out value="${product.Pid}" />
                                    </td>
                                    <td>
                                        <c:out value="${Product.ProductName}" />
                                    </td>
                                    <td>
                                        <c:out value="${Product.SupplierID}" />
                                    </td>
                                    <td>
                                        <c:out value="${product.CategoryID}" />
                                    </td>
                                    <td>
                                        <c:out value="${product.Quantity}" />
                                    </td>
                                    <td>
                                        <c:out value="${product.UnitPrice}" />
                                    </td>
                                    <td><a href="edit?id=<c:out value='${product.Pid}' />">Edit</a> &nbsp;&nbsp;&nbsp;&nbsp; <a href="delete?id=<c:out value='${product.id}' />">Delete</a></td>
                                </tr>
                            </c:forEach>
                            <!-- } -->
                        </tbody>

                    </table>

</body>
</html>