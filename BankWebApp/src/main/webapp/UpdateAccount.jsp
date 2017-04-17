<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" href="BankStyle.css">
<title>Update Account Name</title>
</head>
<body>
	<h1>Update Account Name</h1>
	<table>
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
	<form action="UpdateAccount" method="post">
		Enter Account Number<br><input type="text" name="accountId"><br>
		Enter New Account Name<br><input type="text" name="accountName"><br>
		<input type="submit" value="Update"/>
	</form>
</body>
</html>