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

	<img src="town.png" id="background">

	<div class="content" style="width: 60%;">
		<form style="font-size: 25pt; margin-top: 5%;" action="updateuser"
			method="get">
			<table id="reg">
				<tr>
					<td>Username:</td>
					<td><input type="text" name="username"
						style="height: 80px; border: solid 3px cyan; width: 400px; font-size: 25pt;"></td>
				</tr>
				<tr>
					<td>Password:</td>
					<td><input type="password" name="password"
						style="height: 80px; border: solid 3px cyan; width: 400px; font-size: 25pt;"></td>
				</tr>
				<tr>
					<td></td>
					<td style=""><input class="submit" type="submit"
						style="float: right; height: 80px;"></td>
				</tr>
			</table>
		</form>
		<c:if test="${not empty error}">
			<span style="color: red; float: right;"><c:out
					value="${error}" /></span>
		</c:if>

		<form action="deleteuser">
			<input id="newAccount" type="submit" value="Delete"
				style="height: 80px; width: 305px; float: right;">
		</form>
	</div>

	<%
		session.setAttribute("error", null);
	session.setAttribute("success", null);
	%>
	<img id="beach" src="beach.png" />


</body>
</html>