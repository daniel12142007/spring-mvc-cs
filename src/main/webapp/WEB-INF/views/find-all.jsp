<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: ACER
  Date: 22.09.2023
  Time: 19:27
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<table border="2px">
    <th>id</th>
    <th>name</th>
    <th>age</th>
    <th>update</th>
    <th>delete</th>
    <c:forEach items="${p}" var="per">
        <tr>
            <td>
                <a href="/find/by/${per.id}">
                        ${per.id}
                </a>
            </td>
            <td>${per.name}</td>
            <td>${per.age}</td>
            <td>
                <a href="/update/form/${per.id}">
                    UPDATE
                </a>
            </td>
            <td>
                <a href="/delete/${per.id}">
                    DELETE
                </a>
            </td>
        </tr>
    </c:forEach>
</table>
<a href="/save/form">register</a>
</body>
</html>
