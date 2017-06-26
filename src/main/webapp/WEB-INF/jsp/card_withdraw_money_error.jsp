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

    <p class="title"><label>ERROR</label></p>
    <p class="massage"><label>${errorMassage}</label></p>
    <br><br>

    <form method="POST" action="redirect-withdraw">
            <input type="submit" value="BACK">
    </form>

</div>
</body>
</html>
