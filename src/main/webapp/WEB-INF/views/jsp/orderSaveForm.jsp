<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>New Order</title>
</head>
<body>
<div align="center">
    <h1>New Order</h1>
    <form:form action="/shop/saveBooking" method="post" modelAttribute="param">
        <table>
            <tr>
                <td>Customer Id:</td>
                <td><form:input path="customerId"/></td>
            </tr>
            <tr>
                <td>Date:</td>
                <td><form:input path="date"/></td>
            </tr>
            <tr>
                <td>Product Id:</td>
                <td><form:input path="productId"/></td>
            </tr>
            <tr>
                <td colspan="2" align="center"><input type="submit" value="Save"></td>
            </tr>
        </table>
    </form:form>
</div>
</body>
</html>
