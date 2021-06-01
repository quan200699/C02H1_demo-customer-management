<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Customer List</title>
</head>
<body>
<h1>Edit customer</h1>
<a href="/customers">List customer</a>
<form method="post">
    <table>
        <tr>
            <td></td>
            <td><input type="hidden" name="id" value="${customer.id}"></td>
        </tr>
        <tr>
            <td>Name:</td>
            <td><input type="text" name="name" value="${customer.name}"></td>
        </tr>
        <tr>
            <td>Address:</td>
            <td><input type="text" name="address" value="${customer.address}"></td>
        </tr>
        <tr>
            <td></td>
            <td><button>Edit</button></td>
        </tr>
    </table>
</form>
</body>
</html>
