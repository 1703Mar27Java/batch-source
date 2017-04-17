<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page
	import="com.revature.domain.*,com.revature.dao.BankDAOImp,com.revature.util.*,com.revature.bankExceptions.*, java.util.*"%>


<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link rel="stylesheet" href="myCoolStyles.css">
<link rel="icon" href="favicon.ico">

<title>SCU</title>
</head>
<body>
	<%
		User user = (User) session.getAttribute("user");
	%>
	<img src="clouds.png" id="clouds">
	<div class="header">
		<img src="logo.png" id="logo"> <img src="turtle.png" id="turtle"
			alt="Fish logo">
	</div>
	<br>
	<img src="town.png" id="background">

	<div class="content">
		<div id="welcome">
			Welcome
			<%=user.getUsername()%><form action="Login.jsp"
				style="display: inline; float: right">
				<input type="submit" value="Logout" class="submit">
			</form>
			<br> <br>Accounts:
			<c:if test="${not empty success}">
				<span style="float: right;"><c:out value="${success}" /></span>
				<%
					session.setAttribute("success", null);
				%>
			</c:if>
			
		</div>
		<div class="accounts">
			<table id="accountsTable">
				<%
					for (Account a : user.getAccounts()) {
				%>
				<tr>
					<td><%=a.getName()%></td>
					<td>$ <%=a.getBalance()%></td>
					<td style="float: left; width: 400px;"><form
							action="accountview" method="get">
							<input type="submit" value="View Account" name="<%=a.getName()%>">
						</form></td>
				</tr>
				<%
					}
				%>
			</table>
		</div>

		<form action="new.jsp">
			<input type="submit" value="Create New Account" id="newAccount">
		</form>
	</div>

	<%
		session.setAttribute("logout", "*Successfully logged out");
	%>
	<img id="beach" src="beach.png" />


</body>
</html>