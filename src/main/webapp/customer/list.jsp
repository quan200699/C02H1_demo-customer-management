<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Customer List</title>
</head>
<body>
<h1>List Customer</h1>
<a href="/customers?action=create">Create new customer</a>
<form>
    <input type="text" placeholder="search" name="q">
    <button>Search</button>
</form>
<button><a href="/customers?sort=true">Sort</a></button>
<table>
    <tr>
        <td>Id</td>
        <td>Name</td>
        <td>Address</td>
        <td>Edit</td>
        <td>Delete</td>
    </tr>
    <c:forEach items="${customers}" var="customer">
        <tr>
            <td><c:out value="${customer.id}"/></td>
            <td><c:out value="${customer.name}"/></td>
            <td><c:out value="${customer.address}"/></td>
            <td><a href="/customers?action=edit&id=${customer.id}">Edit</a></td>
            <td><a href="/customers?action=delete&id=${customer.id}">Delete</a></td>
        </tr>
    </c:forEach>
</table>
</body>
</html>
