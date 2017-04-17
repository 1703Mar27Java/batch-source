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

	<img src="town.png" id="background">

	<div class="content">
		<form style="font-size: 25pt; margin-top: 5%;" action="create"
			method="post">
			Name your new account: <br> <br> <input type="text"
				name="name" style="height: 80px; border: solid 3px cyan; width: 60%; font-size: 25pt ;"><br>
			<input class="submit" type="submit"
				style="width: 30%; height: 80px; margin-top: 10px;">
		</form>
		<c:if test="${not empty error}">
			<span style="color: red"><c:out value="${error}" /></span>
		</c:if>
		<br><br><br><br>
		<form style="font-size: 25pt;" action="main.jsp" method="get">
			<input class="submit" type="submit" value="Back"
				style="width: 30%; height: 80px; margin-top: 10px;">
		</form>

	</div>

	<% session.setAttribute("error", null); %>
	<img id="beach" src="beach.png" />


</body>
</html>