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

        input[type=text], select, textarea {
            width: 100%;
            padding: 12px;
            border: 1px solid #ccc;
            border-radius: 4px;
            box-sizing: border-box;
            margin-top: 10px;
            margin-bottom: 16px;
            resize: vertical;
        }

        input[type=submit] {
            background-color: #4CAF50;
            width: 100%;
            color: white;
            padding: 12px 20px;
            border: none;
            border-radius: 4px;
            cursor: pointer;
        }

        input[type=reset] {
            background-color: #4CAF50;
            width: 100%;
            color: white;
            padding: 12px 20px;
            margin-top: 10px;
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
    <spring:form method="POST" modelAttribute="client" action="redirect-pin-code-entry">

        <p><label>Entry you card number</label></p>
        <spring:input path="number" placeholder="You card number..." maxlength="4"/><br/>

        <input type="submit" value="OK">

        <input type="reset" value="CLEAN">

    </spring:form>
</div>
</body>
</html>

