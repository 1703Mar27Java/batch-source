<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@ page
	import="com.revature.domain.*,com.revature.dao.*, com.revature.util.*,com.revature.bankExceptions.*"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/myCoolStyles.css">
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

	<div class="login">
		<form action="check" method="post">
			<table>

				<tr>
					<td>Username:</td>
					<td><input type="text" name="username"
						style="height: 80px; border: solid 3px cyan; width: 600px; font-size: 25pt;"></td>
				</tr>
				<tr>
					<td>Password:</td>
					<td><input type="password" name="password"
						style="height: 80px; border: solid 3px cyan; width: 600px; font-size: 25pt;"></td>
				</tr>
			</table>
			<br> <input class="front" type="submit" value="Login"
				style="width: 200px;" />
		</form>
		<form action="register.jsp">
			<br> <br> <input class="front" type="submit"
				value="Register" style="width: 200px;" />
		</form>
		<br> <br> <span style="color: red; float: right"> <font
			size="2"> <c:if test="${not empty error}">
					<c:out value="${error}" />

				</c:if>
		</font></span> <span style="float: right;"> <c:if test="${not empty logout}">
				<c:out value="${logout}" />
			</c:if>
		</span>

	</div>

	<%
		session.setAttribute("error", null);
		session.setAttribute("logout", null);
	%>

	<img id="beach" src="beach.png" />

	<%
		session.invalidate();
	%>

</body>
</html>