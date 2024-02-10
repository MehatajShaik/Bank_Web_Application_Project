<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="ISO-8859-1">
    <title>Customer Home</title>
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


<form action="CustomerHome" method="post">
    <center>
        <img class="logo" src="images/logo.png" alt="sbilogo">
        <br><br>
        <pre><a href="ViewBalanceDetails.jsp" id="viewBalance">View Balance</a></pre>
        <pre><a href="DepositDetails.jsp" id="deposit">Deposit</a></pre>
        <pre><a href="WithdrawDetails.jsp" id="withdraw">Withdraw</a></pre>
        <pre><a href="Transaction.jsp" id="transaction">Transaction</a></pre>
        <pre><a href="PinGeneration.jsp" id="pinGeneration">PIN Generation</a></pre>
    </center>
</form>

</body>
</html>
