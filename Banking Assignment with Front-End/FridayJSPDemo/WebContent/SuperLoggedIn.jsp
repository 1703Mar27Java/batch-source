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
<title>LoggedIn</title>
</head>
<body>
	<sql:setDataSource var="source" driver="oracle.jdbc.OracleDriver"
		url="jdbc:oracle:thin:@ebdb.cti5brw1nrxx.us-east-2.rds.amazonaws.com:1521:ORCL"
		user="Eeric5" password="motter1281" />

	<div class="btn-group">

		<a href="AddAccount.jsp">
			<button class="button">Add an Account</button>
		</a> <a href="Withdraw.jsp">
			<button class="button">Withdraw</button>
		</a> <a href="deposit.jsp">
			<button class="button">Deposit</button>
		</a> <a href="Delete.jsp">
			<button class="button">Delete</button>
		</a> <a href="Homepage.jsp">
			<button class="button">Log Out</button>
		</a> <a href="ViewAll.jsp">
			<button class="button">View All Users</button>
		</a> <a href="CreateUser.jsp">
			<button class="button">Create User</button>
		</a> <a href="UpdateUser.jsp">
			<button class="button">Update User</button>
		</a> <a href="DeleteAll.jsp">
			<button class="button">Delete all Users</button>
		</a>
	</div>

	<p style="clear: both">


		<%
			Integer Id = (Integer) session.getAttribute("id");
			String User = session.getAttribute("username").toString();
			String Pass = session.getAttribute("password").toString();
			Boolean Superstatus = (Boolean) session.getAttribute("superstatus");

			User loggedInUser = new User(Id, User, Pass, Superstatus);

			BankDaoImpl bDao = new BankDaoImpl();
			Bank newBank = new Bank();
			newBank.setUserID(loggedInUser.getUserID());
			List<Bank> banks = bDao.retrieveBankAccounts(newBank, loggedInUser);

			// 		request.setAttribute("username", loggedInUser.getUserName());
			// 		request.setAttribute("password", loggedInUser.getPassword());
			// 		request.setAttribute("superstatus", loggedInUser.getSuperUser());
			// 		request.setAttribute("id", loggedInUser.getUserID());
			// 		request.getRequestDispatcher("LoggedIn.jsp").forward(request, response);
		%>

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

</body>
</html>