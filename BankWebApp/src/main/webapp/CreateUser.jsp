<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" href="BankStyle.css">
<title>Create User</title>
</head>
<body>
	<h1>Create User</h1>
	<table cellspacing="10">
		<tr>
			<th>Account</th>
			<th>Name</th>
			<th>Balance</th>
		</tr>

		<c:forEach var="row" items="${sessionAccounts}">
			<tr>
				<td><c:out value="${row.BANK_ACCOUNT_ID}" /></td>
				<td><c:out value="${row.BANK_ACCOUNT_NAME}" /></td>
				<td>$ <c:out value="${row.BANK_ACCOUNT_BALANCE}" /></td>
			</tr>
		</c:forEach>
	</table>
   	<form method="post" action="NewUser">
		User Name<br><input type="text" name="userName"><br/>
		Password<br><input type="text" name="userPassword"><br/>
		<input type="submit" value="Create New User"><br/>
	</form>
	<a href="Login">Login</a>
</body>
</html>