<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="ISO-8859-1">
    <title>Account not found</title>
    <style>
        body {
            background-image: url("images/bankback.jpg");
            background-repeat: no-repeat;
            background-size: 100%;
            overflow: hidden;
        }

        .logo {
            width: 120px;
        }

        #errorMessage{
            color: red;
            font-size: 20px;
            text-align: center;
        }

        center {
            margin-top: 100px;
        }
    </style>
</head>
<body>

    <center>
        <img class="logo" src="images/logo.png" alt="sbilogo">
        <br>
        <div id="errorMessage">
            No data found for Account Number : <%= request.getAttribute("accNum") %></pre>
        </div>
    </center>
</body>
</html>
