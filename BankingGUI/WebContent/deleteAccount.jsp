<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>delete account</title>
<link rel="stylesheet" href="bankpage.css">
</head>
<body>
	<h2>Local Bank</h2>
	<div class="white-box">
		<h1>Are you sure?</h1>
		<form action="delete" method="post">
			<input type="radio" name="ans" value="Yes"> Yes<br>
			<input type="radio" name="ans" value="No" checked> No<br>
			<input type="submit" value="submit">
		</form>
</body>
</html>