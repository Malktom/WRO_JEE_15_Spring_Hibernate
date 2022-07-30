<%@ taglib prefix="form"
           uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form:form method="post" modelAttribute="book">
    <form:hidden path="id"/>
    title:
    <form:input path="title"/>
    rating:
    <form:input path="rating"/>
    description:
    <form:input path="description"/>
    Publisher:
    <form:select path="publisher" items="${publishers}" itemValue="id" itemLabel="name"/>
    <form:select path="authors" items="${authors}"/>
    <input type="submit" value="submit">

</form:form>
</body>
</html>
