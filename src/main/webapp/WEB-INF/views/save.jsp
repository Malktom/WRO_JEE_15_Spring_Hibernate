<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: tomasz
  Date: 10.07.2022
  Time: 12:08
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
${student.firstName}<br>
${student.lastName}<br>
<c:forEach items="${student.hobbies}" var="hobby">
    <li>${hobby}</li>
</c:forEach>
</body>
</html>
