
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="ISO-8859-1">
    <title>Update Customer Details</title>
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

        #updateAcc {
            color: white;
            background-color: rgb(213, 39, 114);
            border: 1px solid rgb(213, 39, 114);
            border-radius: 5px;
            padding: 5px;
            text-decoration: none;
        }

        center {
            margin: 50px;
            width: 100px;
           padding: 100px;
        }
        .error-message{
		color:red;
		font-family: Verdana, Geneva, Tahoma, sans-serif;
} 
.success-message{
        color:green;
		font-family: Verdana, Geneva, Tahoma, sans-serif;
}
    </style>
</head>
<body>
<% String error = (String) request.getAttribute("error");%>
	<% if (error != null){%>
	<div class="error-message"><%= error %></div>
	<% } %>
	<% String success = (String) request.getAttribute("success");%>
	<% if (success != null){%>
	<div class="success-message"><%= success %></div>
	<% } %>
    <form action="UpdateCustomerAccount" method="post">
        <center>
            <img class="logo" src="images/logo.png" alt="sbilogo">
            <br>
            <pre><h2>Update Customer Details</h2></pre>
            <input type="text" name="accNum" id="accountNum" placeholder="Account Number">
            <br><br>
            <input type="text" name="cusName" id="name" placeholder="Customer Name">
            <br><br>
            <input type="text" name="phoneNo" id="no" placeholder="Phone Number">
            <br><br>
            <input type="text" name="email" id="mail" placeholder="Email">
            <br><br>
            
            <input type="submit" id="updateAcc" value="Update Account">
        </center>
    </form>
</body>
</html>
