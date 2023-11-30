<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 11/30/2023
  Time: 12:56 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form method="post" action="<%=request.getContextPath()%>/employee">
    <input type="text" name="name" value="${employeee.name}">
    <input type="number" value="${employeee.phone}" name="phone">
    <input type="text" name="address" value="${employeee.address}">
    <input type="date" name="birthday" value="${employeee.birthday}">
    <input type="radio" name="sex" value="${employeee.sex}" checked><span>nu</span>
    <input type="radio" name="sex" value="${employeee.sex}"><span>nam</span>
    <input type="number" name="salary" value="${employeee.salary}">
    <button type="submit" name="action" value="edit">Edit</button>
</form>
</body>
</html>
