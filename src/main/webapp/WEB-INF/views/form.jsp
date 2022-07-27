<%--
  Created by IntelliJ IDEA.
  User: tomasz
  Date: 10.07.2022
  Time: 12:08
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form"
           uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form:form method="POST" modelAttribute="student">
    firstName:
    <form:input path="firstName"/>
    lastname:
    <form:input path="lastName"/>
        <input type="submit" value="Wyśl"/>
</form:form>

</form>
</body>
</html>
