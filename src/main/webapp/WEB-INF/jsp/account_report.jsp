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

    <p><label>Card number: ${client.number}</label></p>
    <p><label>Date: ${client.date}</label></p>
    <p><label>Amount to withdraw: ${client.withdrawAmount}</label></p>
    <p><label>Balance: ${client.balance}</label></p>

    <form method="POST" action="redirect-withdraw">
        <input class="first" type="submit" value="BACK">
    </form>

    <form method="GET" action="/">
        <input class="first" type="submit" value="EXIT">
    </form>

</div>
</body>
</html>
