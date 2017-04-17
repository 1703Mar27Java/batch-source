<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@ page import="com.revature.Dao.*"%>
<%@ page import="com.revature.Domain.*"%>

<%@ page import="java.io.*,java.util.*,java.sql.*"%>
<%@ page import="javax.servlet.http.*,javax.servlet.*"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link rel="stylesheet" href="homepage.css">
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Withdrawing</title>
</head>
<body>

	<sql:setDataSource var="source" driver="oracle.jdbc.OracleDriver"
		url="jdbc:oracle:thin:@ebdb.cti5brw1nrxx.us-east-2.rds.amazonaws.com:1521:ORCL"
		user="Eeric5" password="motter1281" />

	<div class="btn-group">
		<a href="LoggedIn.jsp">
			<button class="button">Go Back</button>
		</a>
	</div>
	<p style="clear: both">
	<sql:query dataSource="${source}" var="result">
      SELECT * FROM BAnK_ACCOUNT WHERE USER_ID = ?
      <sql:param value='${sessionScope["id"]}' />
	</sql:query>
	<table border="1" width="auto" bgcolor="#FFFFFF" align="center">
		<tr>
			<th>Bank ID</th>
			<th>Bank Account Name</th>
			<th>Balance</th>
		</tr>
		<c:forEach var="row" items="${result.rows}">
			<tr>
				<td><c:out value="${row.BANK_ACCOUNT_ID}" /></td>
				<td><c:out value="${row.BANK_ACCOUNT_NAME}" /></td>
				<td><c:out value="${row.BALANCE}" /></td>
			</tr>
		</c:forEach>
	</table>


	<table border="1" bgcolor="#FFFFFF" align="center">
		<tr>
			<form method="post">
				<td>Withdraw</td>
				<td><input type="text" name="AccountName" value="Account Name"></td>
				<td><input type="text" name="amount" value="Amount"></td>
				<td><a href="Withdraw.jsp"> <input type="submit"></a></td>
			</form>
		</tr>
	</table>

	<%
		String accountName = request.getParameter("AccountName");
		String amount = request.getParameter("amount");

		if (accountName != null && Float.valueOf(amount) != 0) {
			Integer Id = (Integer) session.getAttribute("id");
			String User = session.getAttribute("username").toString();
			String Pass = session.getAttribute("password").toString();
			Boolean Superstatus = (Boolean) session.getAttribute("superstatus");

			User loggedInUser = new User(Id, User, Pass, Superstatus);

			BankDaoImpl bDao = new BankDaoImpl();
			Bank bank = new Bank();
			bank.setUserID(loggedInUser.getUserID());
			List<Bank> banks = bDao.retrieveBankAccounts(bank, loggedInUser);

			for (int i = 0; i < banks.size(); i++) {
				if (accountName.equals(banks.get(i).getBankName())) {
					if (Float.valueOf(amount) > banks.get(i).getBalance() || Float.valueOf(amount) < 0)
						out.println("You can't take out more than the amount in the Account or a Negative Amount");
					else
						bDao.withdralBankAccount(banks.get(i), loggedInUser, Float.valueOf(amount));

				}
			}

		}
	%>

</body>
</html>