<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 11/30/2023
  Time: 12:13 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form method="post" action="<%=request.getContextPath()%>/employee">
    <input type="text" name="name">
    <input type="number" name="phone">
    <input type="text" name="address">
    <input type="date" name="birthday">
    <input type="radio" name="sex" value="nu" required><span>nu</span>
    <input type="radio" name="sex" value="nam" required><span>nam</span>
    <input type="number" name="salary">
    <button type="submit" name="action" value="add">Them</button>
</form>
</body>
</html>
