<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags/form" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib prefix="c" uri="http://www.springframework.org/tags" %>
<!DOCTYPE html>
<html>
<head>
    <title>WebATM</title>
    <style>
        .container {
            height: 260px;
            width: 330px;
            position: absolute;
            left: 50%;
            top: 50%;
            margin: -130px 0 0 -190px;
            border-radius: 5px;
            background-color: #a2d6f2;
            padding: 20px;
        }

        input[type=submit] {
            background-color: #4CAF50;
            width: 100%;
            color: white;
            margin-top: 10px;
            padding: 12px 20px;
            border: none;
            border-radius: 4px;
            cursor: pointer;
        }

        input[type=submit]:hover {
            background-color: #45a049;
        }
    </style>
</head>
<body>
<div class="container">

    <form action="redirect-balance" method="POST">
        <input type="submit" value="BALANCE">
    </form>

    <form action="redirect-withdraw" method="POST">
        <input type="submit" value="WITHDRAWAL">
    </form>

    <form action="/" method="GET">
        <input type="submit" value="EXIT">
    </form>

</div>
</body>
</html>