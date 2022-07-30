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
<a href="<c:url value="/bookForm/addBook"/>">dodaj ksiazke</a>

<table>
    <tr>
        <th>description</th>
        <th>rating</th>
        <th>title</th>
        <th>publisher</th>
    </tr>
    <c:forEach items="${books}" var="book">
        <tr>
            <td>${book.description}</td>
            <td>${book.rating}</td>
            <td>${book.title}</td>
            <td>${book.publisher}</td>
            <td>
                <a href="<c:url value="/bookForm/delete?id=${book.id}"/>">usuń</a>
                <a href="<c:url value="/BookForm/edit?id=${book.id}"/>">edit</a>
            </td>
        </tr>

    </c:forEach>

</table>
</body>
</html>
