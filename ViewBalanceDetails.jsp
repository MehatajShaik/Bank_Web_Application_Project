
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
        
        #view {
			color: white;
        	background-color: rgb(213, 39, 114);
      		border:1px solid rgb(213, 39, 114) ;
        	border-radius: 5px;
        	padding: 5px;
        	text-decoration:none;
		}

</style>
<body>

  <form action="ViewCustomerBalance" method="post">
 
    <center>
        <img class="logo" src="images/logo.png" alt="sbilogo">
        <br><br>
            <input type="text" name="accNum" placeholder="Enter Account Number">
            <br><br>
            <input type="password" name="pinNum" id="pin" placeholder="Enter PIN Number">
            <br>
            <pre><input type="checkbox" onclick="myFunction()" id="showpass">Show Password</pre>
            <input type="submit" id="view" value="View Balance">
    </center>
    </form>
        <script>
function myFunction() {
  var x = document.getElementById("pin");
  if (x.type === "password") {
    x.type = "text";
  } else {
    x.type = "password";
  }
}
</script>
</body>
</html>
