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

    <form action="redirect-balance" method="POST">
        <input class="second" type="submit" value="BALANCE">
    </form>

    <form action="redirect-withdraw" method="POST">
        <input class="third" type="submit" value="WITHDRAWAL">
    </form>

    <form action="/" method="GET">
        <input class="third" type="submit" value="EXIT">
    </form>

</div>
</body>
</html>