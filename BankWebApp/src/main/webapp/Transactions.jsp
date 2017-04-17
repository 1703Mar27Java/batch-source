<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" href="BankStyle.css">
<title>Transactions</title>
</head>
<body>
	<h1>${sessionUser.getBANK_USER_NAME()}'s Transaction History</h1>
	<table>
		<tr>
			<th>Log</th>
		</tr>
	
	<c:forEach var="row" items="${sessionTransactions}">
		<tr>
			<td><c:out value="${row.BANK_TRANSACTION_DESC}"/></td>
		</tr>
	</c:forEach>
	</table>
</body>
</html>