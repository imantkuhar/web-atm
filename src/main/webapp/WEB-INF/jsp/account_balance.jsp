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

    <p><label>NAME: ${client.fullName}</label></p>
    <p><label>ADDRESS: ${client.address}</label></p>
    <p><label>DATE: ${client.date}</label></p>
    <p><label>BALANCE: ${client.balance}</label></p>

    <form method="POST" action="redirect-operations">
        <input class="third" type="submit" value="BACK">
    </form>

    <form method="GET" action="/">
        <input class="third" type="submit" value="EXIT">
    </form>

</div>
</body>
</html>