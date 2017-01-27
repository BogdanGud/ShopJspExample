<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Customer Management Screen</title>
</head>
<body>
<div align="center">
    <h1>Customer List</h1>
    <h3>
        <a href="/">Main page<br></a>
        <a href="/shop/newCustomer">Add new customer</a>
    </h3>
    <table border="2">
        <tr>
            <th>Id</th>
            <th>Name</th>
            <th>Phone</th>
            <th>Address</th>

        </tr>
        <c:forEach var="customer" items="${customers}">
            <tr>

                <td>${customer.id}</td>
                <td>${customer.name}</td>
                <td>${customer.phone}</td>
                <td>${customer.address}</td>
                <td><a href="/shop/editCustomer?id=${customer.id}">Edit</a>
                    <a href="/shop/deleteCustomer?id=${customer.id}">Delete</a></td>
            </tr>
        </c:forEach>


    </table>
</div>
</body>
</html>
