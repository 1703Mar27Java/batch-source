<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" href="BankStyle.css">
<title>Admin Login</title>
</head>
<body>
	<h1>Administrator Login</h1>
   	<form method="post" action="LoginAdmin">
		Admin Name<br><input type="text" name="adminName"><br/>
		Admin Password<br><input type="text" name="adminPassword"><br/>
		<input type="submit" value="Login"><br/>
	</form>
	<a href="CreateUser.jsp">New User</a>
	<a href="Login.jsp">Login as User</a>
</body>
</html>