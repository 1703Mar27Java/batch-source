<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/sql"  %>    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Welcome!</title>
<link rel="stylesheet" href="stylesheet.css">
</head>
<body>



<div id="header">
	<h1>Welcome new user to PB and J Bank!</h1>
		</div>
	
<div id="nav">
<ul>
  <li><a href="index.html">Home</a></li>
  <li><a href="news.asp">News</a></li>
  <li><a href="contact.asp">Contact</a></li>
  <li><a href="about.asp">About</a></li>
</ul>
	</div>	

<h3>Please fill out the following information to create your bank account!
If you do not wish to create a bank account today, return to the home page.</h3>
<form action="BankAccountServlet" method="post">
<strong>Name of bank account: 	</strong>:<input type="text" name="baName"><br>
<strong>Starting balance:       </strong>:<input type="text" name="bal"><br>
<input type="submit" value="Create New Bank Account">
</form>
<br>

	
	
</body>
</html>