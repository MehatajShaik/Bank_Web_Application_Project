<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="ISO-8859-1">
    <title>Employee Home</title>
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

        a {
            color: white;
            background-color: rgb(213, 39, 114);
            border: 1px solid rgb(213, 39, 114);
            border-radius: 5px;
            padding: 5px;
            text-decoration: none;
        }
    </style>
</head>
<body>

    <center>
        <img class="logo" src="images/logo.png" alt="sbilogo">
        <br><br>
        <pre><b>Employee ID Number : </b><%= request.getAttribute("empID") %></pre>
    	<pre><b>Employee Name : </b><%= request.getAttribute("empName") %></pre>
    	<br><br>
        <pre><a href="CreateAccount.jsp" id="createAccount">Create Account</a></pre>
        <pre><a href="UpdateAccount.jsp" id="updateAccount">Update Account</a></pre>
        <pre><a href="DeleteAccount.jsp" id="deleteAccount">Delete Account</a></pre>
        <pre><a href="ViewCustomer.jsp" id="viewAccount">View Account</a></pre>
    </center>


</body>
</html>
