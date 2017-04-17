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
		Account account = (Account) session.getAttribute("account");
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
			<%=account.getName()%>: &nbsp;&nbsp;&nbsp; $<%=account.getBalance()%><form
				action="main.jsp" style="display: inline; float: right">
				<input type="submit" value="Back" class="submit">
			</form>
			<br> <br>Transactions:
			<c:if test="${not empty success}">
				<span style="float: right;"><c:out value="${success}" /></span>
				<%
					session.setAttribute("success", null);
				%>
			</c:if>
			<span style="color: red; float: right; font-size: 14pt;"> <c:if
					test="${not empty error}">
					<c:out value="${error}" />

				</c:if>
			</span>
		</div>
		<div class="accounts">
			<table id="accountsTable">
				<%
					for (Transaction t : account.getTrans()) {
				%>
				<tr>
					<td>
						<%
							if (t.getType().equals("DEPOSIT")) {
						%><span style="color: #21d11b">
						<%=t.getType()%>
						</span> <%
 	} else {
 %><span style="color: red"><%=t.getType()%></span>
						<%
							}
						%>
					</td>
					<td>$ <%=t.getAmount()%></td>
					<td><%=t.getDate().substring(0,10)%></td>
				</tr>
				<%
					}
				%>
			</table>
		</div>


			<div>
			
				<form action="deposit" style="font-size: 20pt;">
						<input type="submit" value="Deposit" id="newAccount"  style="width: 50%;">
						: &nbsp;&nbsp;$<input id="newAccount" style ="width:300px; height: 35px;" type="number" name = "amount">
					</form>

				<form action="withdraw" style="font-size: 20pt;">
						<input type="submit" value="Withdraw" id="newAccount"  style="width: 50%;">
						: &nbsp;&nbsp;$<input id="newAccount" style ="width:300px; height: 35px;" type="number" name = "amount">
					</form>
			</div>
		
		<form action="deleteaccount">
			<input type="submit" value="Delete" id="newAccount" style="width: 50%;">
		</form>
	</div>
	
	<% session.setAttribute("error",null); %>

	<img id="beach" src="beach.png" />


</body>
</html>