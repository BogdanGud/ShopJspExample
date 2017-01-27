<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Orders Management Screen</title>
</head>
<body>
<div align="center">
    <h1>Orders List</h1>
    <h3>
        <a href="/">Main page<br></a>
        <a href="/shop/newBooking">Add new order</a>
    </h3>
    <table style="align-items: center" border="2">
        <tr>
            <th>Id</th>
            <th>Date</th>
            <th>Customer Name</th>
            <th>Customer Phone</th>
            <th>Customer Address</th>
            <th>Product Name</th>
            <th>Product Price</th>
        </tr>
        <c:forEach var="booking" items="${bookings}">
            <tr>
                <td>${booking.id}</td>
                <td>${booking.date}</td>
                <td>${booking.customerName}</td>
                <td>${booking.customerPhone}</td>
                <td>${booking.customerAddress}</td>
                <td>${booking.productsNames}</td>
                <td>${booking.productsPrices}</td>
                <td><a href="/shop/editBooking?id=${booking.id}">Edit</a>
                    <a href="/shop/deleteBooking?id=${booking.id}">Delete</a></td>

            </tr>
        </c:forEach>
    </table>
</div>
</body>
</html>
