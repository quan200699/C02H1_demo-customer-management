<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Order Detail List</title>
</head>
<body>
<h1>List Order Detail</h1>
<a href="/order-details?action=create">Create new order detail</a>
<table>
    <tr>
        <td>Id</td>
        <td>CustomerId</td>
        <td>Amount</td>
        <td>Price</td>
        <td>Edit</td>
        <td>Delete</td>
    </tr>
    <c:forEach items="${orderDetails}" var="orderDetail">
        <tr>
            <td><c:out value="${orderDetail.id}"/></td>
            <td><c:out value="${orderDetail.customerId}"/></td>
            <td><c:out value="${orderDetail.amount}"/></td>
            <td><c:out value="${orderDetail.price}"/></td>
            <td><a href="/order-details?action=edit&id=${orderDetail.id}">Edit</a></td>
            <td><a href="/order-details?action=delete&id=${orderDetail.id}">Delete</a></td>
        </tr>
    </c:forEach>
</table>
</body>
</html>
