<%@ taglib prefix="form"
           uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form:form method="post" modelAttribute="author">
    <form:hidden path="id"/>
    firstName:
    <form:input path="firstName"/>
    lastName:
    <form:input path="lastName"/>

    <input type="submit" value="submit">

</form:form>
</body>
</html>
