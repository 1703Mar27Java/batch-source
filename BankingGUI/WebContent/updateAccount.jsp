<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Update Account</title>
</head>
<link rel="stylesheet" href="bankpage.css">
<body>
	<h2>Local Bank</h2>
	<div class="white-box">
		<h1>Update account page</h1>
		<form action="update" method="post">
			<input type="text" placeholder="Change account name" name="name" required><br>
			<input type="submit" value="change"/>
		</form>
</body>
</html>