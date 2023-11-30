<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 11/29/2023
  Time: 4:57 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<a href="employee?action=add">Them nhan vien</a>
<table cellspacing="0" border="1">
    <thead>
    <tr>
        <th>id</th>
        <th>name</th>
        <th>phone</th>
        <th>address</th>
        <th>birthday</th>
        <th>sex</th>
        <th>salary</th>
        <th>Action</th>
    </tr>
    </thead>
    <tbody>
  <c:forEach items="${employeeList}" var="item">
      <tr>
          <td>${item.id}</td>
          <td>${item.name}</td>
          <td>${item.phone}</td>
          <td>${item.address}</td>
          <td>${item.birthday}</td>
          <td>${item.sex}</td>
          <td>${item.salary}</td>
          <td><a href="/employee?action=edit&id=${item.id}">Edit</a></td>
          <td><a href="/employee?action=delete&id=${item.id}">Delete</a></td>
      </tr>
  </c:forEach>
    </tbody>
</table>
</body>
</html>
