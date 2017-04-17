<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" href="BankStyle.css">
<title>Welcome</title>
</head>
<body>
	<h1>Welcome ${sessionUser.getBANK_USER_NAME()}</h1>
	<table>
		<tr>
			<th>Account</th>
			<th>Name</th>
			<th>Balance</th>
		</tr>
	
	<c:forEach var="row" items="${sessionAccounts}">
		<tr>
			<td><c:out value="${row.BANK_ACCOUNT_ID}"/></td>
			<td><c:out value="${row.BANK_ACCOUNT_NAME}"/></td>
			<td>$ <c:out value="${row.BANK_ACCOUNT_BALANCE}"/></td>
		</tr>
	</c:forEach>
	</table>
	
	<a href="OpenAccount.jsp">Open New Account</a><br>
	<a href="CloseAccount.jsp">Close Account</a><br>
	<a href="UpdateAccount.jsp">Change Account Name</a><br>
	<a href="Deposit.jsp">Make a Deposit</a><br>
	<a href="Withdraw.jsp">Make a Withdrawal</a><br>
	<a href="Transactions.jsp">Transaction History</a><br>
	<a href="Logout.jsp">Logout</a><br>
	
</body>
</html>