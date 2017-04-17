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
<title>Adding an Account</title>
</head>
<body>
	<sql:setDataSource var="source" driver="oracle.jdbc.OracleDriver"
		url="jdbc:oracle:thin:@ebdb.cti5brw1nrxx.us-east-2.rds.amazonaws.com:1521:ORCL"
		user="Eeric5" password="motter1281" />

	<sql:query dataSource="${source}" var="result">
      SELECT * FROM BAnK_ACCOUNT WHERE USER_ID = ?
      <sql:param value='${sessionScope["id"]}' />
	</sql:query>
	
	<div class="btn-group">

		<a href="LoggedIn.jsp">
			<button class="button">Go Back</button>
		</a>
	</div>
	
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
				<td>Add a new Account</td>
				<td><input type="text" name="AccountName"
					value="Account Name"></td>
				<td><input type="text" name="balance"
					value="Staring Balance"></td>
				<td><a href="AddAccount.jsp"> <input type="submit"></a></td>
			</form>
			</tr>
	</table>

	

	<p style="clear: both">

		<%
			String accountName = request.getParameter("AccountName");
			String startBalance = request.getParameter("balance");

			if (accountName != null && startBalance != null) {
				Integer Id = (Integer) session.getAttribute("id");
				String User = session.getAttribute("username").toString();
				String Pass = session.getAttribute("password").toString();
				Boolean Superstatus = (Boolean) session.getAttribute("superstatus");

				User loggedInUser = new User(Id, User, Pass, Superstatus);

				BankDaoImpl bDao = new BankDaoImpl();
				Bank newBank = new Bank(loggedInUser.getUserID(), Float.valueOf(startBalance), accountName);
				bDao.creatBankAccount(newBank, loggedInUser);
				request.getRequestDispatcher("AddAccount.jsp");
			}
		%>
	
</body>
</html>