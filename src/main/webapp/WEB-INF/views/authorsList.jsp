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
<a href="<c:url value="/author/addAuthor"/>">dodaj autora</a>

<table>
    <tr>
        <th>id</th>
        <th>firstName</th>
        <th>lastName</th>
    </tr>
    <c:forEach items="${authors}" var="author">
        <tr>
            <td>${author.id}</td>
            <td>${author.firstName}</td>
            <td>${author.lastName}</td>

            <td>
                <a href="<c:url value="/author/delete/${author.id}"/>">usuń</a>
                <a href="<c:url value="/author/edit/${author.id}"/>">edit</a>
            </td>
        </tr>

    </c:forEach>

</table>
</body>
</html>
