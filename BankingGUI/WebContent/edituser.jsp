<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Edit User</title>
<link rel="stylesheet" href="bankpage.css">
</head>
<body>
	<h2>Local Bank</h2>
	<div class="white-box">
		<h1>Edit user ${viewuser.getUsername()}</h1>
		<form action="edituser" method="post">
			<input type="text" placeholder="Enter new username" name="username" required><br>
			<input type="text" placeholder="Enter new password" name="password" required><br>
			<input type="submit" value="submit"/>
		</form>
	</div>
</body>
</html>