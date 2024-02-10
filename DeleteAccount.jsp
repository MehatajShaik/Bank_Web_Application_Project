<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="ISO-8859-1">
    <title>Delete Account</title>
</head>
<style>

body{

    background-image: url("images/bankback.jpg");
    background-repeat: no-repeat;
    background-size: 100%;
    overflow:hidden;
}

.logo{
        width: 120px;
    }

#deleteAcc{
    	color: white;
        background-color: rgb(213, 39, 114);
        border:1px solid rgb(213, 39, 114) ;
        border-radius: 5px;
        padding: 5px;
        text-decoration:none;
}
 

center{
            margin: 130px;
            width: 20px;
           
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
    <form action="DeleteCustomerAccount" method="post">
        <center>
        
        <img class="logo" src="images/logo.png" alt="sbilogo">
        <br>
         <pre><h2>Delete Account</h2></pre>
        <input type="text" name="accNum" id="accNo" placeholder="Account Number">
		<br><br>

        <input type="submit" id="deleteAcc" value="Delete Account">
        </center>
    </form>

</body>
</html>
