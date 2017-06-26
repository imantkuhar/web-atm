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
    <spring:form method="POST" modelAttribute="client" action="redirect-report">

        <p><label>ENTRY YOU AMOUNT</label></p>
        <spring:input type="number" pattern="[0-9]{10}" path="withdrawAmount" min="1" max="10000"/><br/>

        <input class="first" type="submit" value="OK">

    </spring:form>

    <form method="POST" action="redirect-operations">
        <input class="first" type="submit" value="BACK">
    </form>

    <form method="GET" action="/">
        <input class="first" type="submit" value="EXIT">
    </form>
</div>
</body>
</html>