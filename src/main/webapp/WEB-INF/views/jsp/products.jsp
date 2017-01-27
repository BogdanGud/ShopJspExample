<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Product Management Screen</title>
</head>
<body>
<div align="center">
    <h1>Products List</h1>
    <h3>
        <a href="/">Main page<br></a>
        <a href="/shop/newProduct">Add new product</a>
    </h3>
    <table border="2">
        <tr>
            <th>Id</th>
            <th>Name</th>
            <th>Price</th>

        </tr>
        <c:forEach var="product" items="${products}">
            <tr>

                <td>${product.id}</td>
                <td>${product.name}</td>
                <td>${product.price}</td>
                <td><a href="/shop/editProduct?id=${product.id}">Edit</a>
                    <a href="/shop/deleteProduct?id=${product.id}">Delete</a></td>
            </tr>
        </c:forEach>


    </table>
</body>
</html>
