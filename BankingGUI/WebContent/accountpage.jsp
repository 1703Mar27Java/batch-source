<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="java.io.*,java.util.*,java.sql.*"%>
<%@ page import="javax.servlet.http.*,javax.servlet.*"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>account page</title>
<link rel="stylesheet" href="bankpage.css">
</head>
<body>
	<h2>Local Bank</h2>
	<div class="white-box">
		<h1>Account page</h1>
		<div style="float:left;">
			<h2 style="margin-left:40px;color:green;text-align:left;font-size:60px;">$ ${acct.getBalance()}</h2>
			<p>
			<h4 style="margin-left:40px;">Account name: ${acct.getAccountName()}</h4>
			<h4 style="margin-left:40px;">AccountID: ${acct.getAccountID()}</h4>
			</p>
			<a href="homepage.jsp" style="margin-left:40px;">Return to Home page</a>
		</div>
		
		<a href="depositToAccount.jsp"><div class="firstButton">
			<img src="images/depositButton.png"></img>
		</div></a>
		<a href="withdrawFromAccount.jsp"><div class="secondButton">
			<img src="images/withdrawButton.png"></img>
		</div></a>
		<a href="updateAccount.jsp"><div class="thirdButton">
			<img src="images/updateButton.png"></img>
		</div></a>
		<a href="deleteAccount.jsp"><div class="fourthButton">
			<img src="images/deleteButton.png"></img>
		</div></a>
	</div>
</body>
</html>