<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>


<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Login</title>
</head>
<style>

body{

    background-image: url("images/bankback.jpg");
    background-repeat: no-repeat;
    background-size: 100%;
    overflow:hidden;
    border-color:black;
}

.p1{
        font-family: fantasy;
 }  
.logo{
        width: 120px;
    }

form{
            margin: 130px;
            width: 20px;
            padding: 30px;
		}

#employeelogin{
        color: white;
        background-color: rgb(213, 39, 114);
        border:1px solid rgb(213, 39, 114) ;
        border-radius: 5px;
        padding: 5px;
        text-decoration:none;
}       

#customerlogin{
		color: white;
        background-color: rgb(213, 39, 114);
        border:1px solid rgb(213, 39, 114) ;
        border-radius: 5px;
        padding: 5px;
        text-decoration:none;
}
</style>
<body>
<form>

	<p class="p1">Welcome!</p>
    <img class="logo" src="images/logo.png" alt="sbilogo" >
	<br><br>
	<pre><a href="EmployeeLogin.jsp" id = "employeelogin">Employee Login</a></pre>
	<br>
	<pre><a href="CustomerLogin.jsp" id = "customerlogin">Customer Login</a></pre>


</form>


</body>
</html>