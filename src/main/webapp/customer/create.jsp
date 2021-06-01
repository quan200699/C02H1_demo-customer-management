<%--
  Created by IntelliJ IDEA.
  User: quan
  Date: 31/05/2021
  Time: 10:32
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Customer List</title>
</head>
<body>
<h1>Create new customer</h1>
<a href="/customers">List customer</a>
<form method="post">
    <table>
        <tr>
            <td>Name:</td>
            <td><input type="text" name="name"></td>
        </tr>
        <tr>
            <td>Address:</td>
            <td><input type="text" name="address"></td>
        </tr>
        <tr>
            <td></td>
            <td><button>Create</button></td>
        </tr>
    </table>
</form>
</body>
</html>
