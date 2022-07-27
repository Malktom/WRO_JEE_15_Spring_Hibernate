<%--
  Created by IntelliJ IDEA.
  User: tomasz
  Date: 24.07.2022
  Time: 15:49
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

<form:form modelAttribute ="absolwent">

<%--  <form:hidden path="id"/> // dodac przy edycji--%>
  <form:input path="firstName"/>


  <form:input path="lastName"/>
  <form:radiobutton path="gender" value="m"/>
  <form:radiobutton path="gender" value="w"/>

  <form:select path="country">
    <form:option value="-" label="--Please Select--"/>
    <form:options items="${countries}"/>
  </form:select>
  <form:textarea path="notes" rows="3" cols="20"/>
  <form:checkbox path="mailingList"/>

  <form:select path="programmingSkills">
    <form:option value="-" label="--Please Select--"/>
    <form:options items="${skills}"/>
  </form:select>

  <form:checkboxes path="hobbies" items="${hobbies}"/>

  <input type="submit">

</form:form>
</body>
</html>
