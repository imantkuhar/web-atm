<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>

<%@ taglib prefix="spring" uri="http://www.springframework.org/tags/form" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib prefix="c" uri="http://www.springframework.org/tags" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <link href="<c:url value="/resources/css/home.css" />" rel="stylesheet">
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Title</title>
</head>
<spring:form method="GET" modelAttribute="pinCode" class="box login">

    <form method="post" action="id-card-entry">
        <fieldset class="boxBody">
            PinCode: <spring:input path="pinCode"/><br/>
        </fieldset>
        <p><input type="submit" class="btnLogin" value="Check"></p>
    </form>

</spring:form>
</body>
</html>