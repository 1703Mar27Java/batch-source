<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page import="java.io.*,java.util.*,java.sql.*"%>
<%@ page import="javax.servlet.http.*,javax.servlet.*"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>LocalBank</title>
<link rel="stylesheet" href="bankpage.css">
</head>
<body>
	<h2>Local Bank</h2>
	<div class="white-box">
		<h1>Welcome, ${user.getUsername()}</h1>
		<ul>
			<c:forEach var="row" items="${accounts}">
			<li><a href="/SelfLoginPage/viewbankacc?pid=${row.accountID}"><div class="accountCard">
					<h3><c:out value="${row.accountName}"/>
						<c:out value="${row.balance}"/></h3>
					</div></a>
			</li>
			</c:forEach>
		</ul>
		
		<a href="createAccount.jsp"><div class="firstButton">
			<img src="images/createButton.png"></img> 
		</div></a>
		<a href="logout.jsp"><div class="secondButton">
			<img src="images/logoutButton.png"></img>
		</div></a>
		
		<c:if test="${user.isSuperPriv()>0}">
			<a href="createaccount.html"><div class="thirdButton" style="margin-right: 50px;">
				<img src="images/createuserButton.png"></img> 
			</div></a>
			<a href="userlist"><div class="fourthButton" style="margin-right:50px;">
				<img src="images/userlistButton.png"></img>
			</div></a>
		</c:if>
	</div>
</body>
</html>