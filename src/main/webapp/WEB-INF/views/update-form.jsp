<%--
  Created by IntelliJ IDEA.
  User: ACER
  Date: 22.09.2023
  Time: 19:55
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form action="/update/${st.id}" method="post">
    <label>name</label>
    <input type="text" name="name" value="${st.name}">
    <label>age</label>
    <input type="number" name="age" value="${st.age}">
    <input type="submit" value="update">
</form>
</body>
</html>
