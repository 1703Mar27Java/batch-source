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
			<%="Admin"%><form action="Login.jsp"
				style="display: inline; float: right">
				<input type="submit" value="Logout" class="submit">
			</form>
			<br>
			<br>Users:
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
					BankDAOImp dao = new BankDAOImp();
					for (User u : dao.getUsers()) {
				%>
				<tr>
					<td><%=u.getUsername()%></td>
					<td><%=u.getPassword()%></td>
					<td><form action="userview" method="get" >
							<input style="width:150px;" type="submit" value="View User" name="<%=u.getUsername()%>">
						</form></td>
				</tr>
				<%
					}
				%>
			</table>
		</div>

		<form action="register.jsp">
			<input type="submit" value="Create New User" id="newAccount">
		</form>
	</div>

	<%
		session.setAttribute("logout", "*Successfully logged out");
	%>
	<img id="beach" src="beach.png" />


</body>
</html>