<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: tomasz
  Date: 24.07.2022
  Time: 14:54
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<a href="<c:url value="/person/add"/>">dodaj</a>

<table>
    <tr>
        <th>login</th>
        <th>password</th>
        <th>email</th>
    </tr>
    <c:forEach items="${person}" var="person">
        <tr>
            <td>${person.login}</td>
            <td>${person.password}</td>
            <td>${person.email}</td>
            <td>
                <a href="<c:url value="/person/delete?id=${person.id}"/>">usuń</a>
                <a href="<c:url value="/person/edit?id=${person.id}"/>">edit</a>
            </td>
        </tr>

    </c:forEach>

</table>
</body>
</html>
