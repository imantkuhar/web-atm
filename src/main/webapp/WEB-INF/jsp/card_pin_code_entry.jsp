<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags/form" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib prefix="c" uri="http://www.springframework.org/tags" %>
<!DOCTYPE html>
<html>
<head>
    <title>WebATM</title>
    <link href="../../static/css/atm.css" st rel="stylesheet">
</head>
<body>
<div class="container">
    <spring:form action="redirect-operations" modelAttribute="client" method="POST">

        <p><label>Entry you password</label></p>
        <spring:input type="password" path="password" placeholder="You password..." maxlength="4"/><br/>
        <input class="third" type="submit" value="OK">

    </spring:form>

    <spring:form action="/" method="GET">

        <input class="third" type="submit" value="BACK">

    </spring:form>
</div>
</body>
</html>