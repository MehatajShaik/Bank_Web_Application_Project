
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="ISO-8859-1">
    <title>Customer Details</title>
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
        
        #view {
			color: white;
        	background-color: rgb(213, 39, 114);
      		border:1px solid rgb(213, 39, 114) ;
        	border-radius: 5px;
        	padding: 5px;
        	text-decoration:none;
		}
.error-message{
		color:red;
		font-family: Verdana, Geneva, Tahoma, sans-serif;
} 
</style>
<body>
<% String error = (String) request.getAttribute("error");%>
	<% if (error != null){%>
	<div class="error-message"><%= error %></div>
	<% } %>
  <form action="EmployeeViewCustomerDetails" method="post">
 
    <center>
        <img class="logo" src="images/logo.png" alt="sbilogo">
        <br><br>
            <input type="text" name="accNum" placeholder="Enter Account Number">
            <br><br>
            <input type="submit" id="view" value="Login">
    </center>
    </form>

</script>
</body>
</html>
