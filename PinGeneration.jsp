<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Pin Generation</title>
</head>
<style>

body{

    background-image: url("images/bankback.jpg");
    background-repeat: no-repeat;
    background-size: 100%;
    overflow:hidden;
}

.p1{
        font-family: fantasy;
 }    

.logo{
        width: 120px;
    }

#logbtn{
    	color: white;
        background-color: rgb(213, 39, 114);
        border:1px solid rgb(213, 39, 114) ;
        border-radius: 5px;
        padding: 5px;
        text-decoration:none;
}    
#me{
    font-family: Verdana, Geneva, Tahoma, sans-serif;
    font-size: small;
}


#btn{
    font-family: Verdana, Geneva, Tahoma, sans-serif;
    font-size: small;
    text-decoration:none;
  
}

center{
            margin: 130px;
            width: 20px;
            padding: 30px;
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
<body>
<% String error = (String) request.getAttribute("error");%>
	<% if (error != null){%>
	<div class="error-message"><%= error %></div>
	<% } %>
	<% String success = (String) request.getAttribute("success");%>
	<% if (success != null){%>
	<div class="success-message"><%= success %></div>
	<% } %>
<form action="CusForgotPinValidation" method="post">
<center>
    <img class="logo" src="images/logo.png" alt="sbilogo" >
	<br><br>
	<br><input type="text" name="accNum" id="acc" placeholder="Account number ">
	<br><br>
	<br> <input type="password" name="newPin" id="newPin" placeholder="Create New PIN">
    <br>
    <pre><input type="checkbox" onclick="myFunction()" id="me">Show Password</pre>
    <br> <input type="password" name="confirmPin" id="confirmPin" placeholder="Conform New PIN">
    <br>
    <pre><input type="submit" id = "logbtn" value="submit"></pre>
    <br>
</center>

</form>

    <script>
function myFunction() {
  var x = document.getElementById("newPin");
  if (x.type === "password") {
    x.type = "text";
  } else {
    x.type = "password";
  }
}

</script>
</body>
</html>