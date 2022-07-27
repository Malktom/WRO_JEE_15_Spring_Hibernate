<%--
  Created by IntelliJ IDEA.
  User: tomasz
  Date: 24.07.2022
  Time: 14:43
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
<form:form method="post" modelAttribute ="book">
    <form:input path="title"/>
    <form:input path="rating"/>
    <form:input path="description"/>
    <form:select path="publisher" items="${publishers}" itemValue ="id" itemLabel="name"/>
    <input type="submit">

</form:form>
</body>
</html>
