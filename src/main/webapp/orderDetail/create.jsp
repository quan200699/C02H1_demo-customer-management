<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Customer List</title>
</head>
<body>
<h1>Create new order detail</h1>
<a href="/order-details">List order detail</a>
<c:if test="${message!= null}">
    <p style="color: red"><c:out value="${message}"/></p>
</c:if>
<form method="post">
    <table>
        <tr>
            <td>Customer:</td>
            <td>
                <select name="customerId">
                    <c:forEach items="${customers}" var="customer">
                        <option value="${customer.id}">
                            <c:out value="${customer.name}"/>
                        </option>
                    </c:forEach>
                </select>
            </td>
        </tr>
        <tr>
            <td>Amount:</td>
            <td><input type="text" name="amount"></td>
        </tr>
        <tr>
            <td>Price:</td>
            <td><input type="text" name="price"></td>
        </tr>
        <tr>
            <td></td>
            <td><button>Create</button></td>
        </tr>
    </table>
</form>
</body>
</html>
