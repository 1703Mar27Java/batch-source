<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>LocalBank</title>
<link rel="stylesheet" href="bankpage.css">
</head>
<body>
	<h2>${message}</h2>
	<a href="loginpage.html" style="position: absolute; left:50%;">Return</a>
	<%session.invalidate(); %>
</body>
</html>