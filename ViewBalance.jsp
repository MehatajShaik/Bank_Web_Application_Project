
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="ISO-8859-1">
    <title>View Balance</title>
    <!-- Include any necessary styles or scripts -->
</head>
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

        center {
            margin: 130px;
            width: 20px;
            padding: 30px;
        }

</style>
<body>

    <center>
        <img class="logo" src="images/logo.png" alt="sbilogo">
        <br><br>
            <pre><h2>Your Current Balance</h2></pre>
            <br>
    	<pre><b>Account Number : </b><%= request.getAttribute("accNum") %></pre>
    	<pre><b>Customer Name : </b><%= request.getAttribute("cusName") %></pre>
    	<pre><b>Phone : </b><%= request.getAttribute("phone") %></pre>
    	<pre><b>Email : </b><%= request.getAttribute("email") %></pre>
    	<pre><b>Balance: </b><%= request.getAttribute("balance") %></pre>
    </center>
       
</body>
</html>
