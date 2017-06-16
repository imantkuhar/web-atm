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

        p {
            text-align: center;
            font: normal 16px/18px Arial, Helvetica, Sans-serif;
        }
    </style>
</head>
<body>
<div class="container">

    <p><label>Name: ${client.fullName}</label></p>
    <p><label>Address: ${client.address}</label></p>
    <p><label>Date: ${client.date}</label></p>
    <p><label>Balance: ${client.balance}</label></p>

    <form method="POST" action="redirect-operations">
        <input type="submit" value="BACK">
    </form>

    <form method="GET" action="/">
        <input type="submit" value="EXIT">
    </form>

</div>
</body>
</html>