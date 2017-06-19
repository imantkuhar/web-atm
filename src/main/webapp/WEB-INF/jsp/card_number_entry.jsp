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
    <spring:form method="POST" modelAttribute="client" action="redirect-pin-code-entry">

        <p><label>Entry you card number</label></p>
        <spring:input path="number" placeholder="You card number..." maxlength="4"/><br/>

        <input class="second" type="submit" value="OK">

        <input type="reset" value="CLEAN">

    </spring:form>
</div>
</body>
</html>

