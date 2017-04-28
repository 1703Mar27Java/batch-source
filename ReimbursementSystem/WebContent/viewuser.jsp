<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>User Page</title>
<link rel="stylesheet" href="radar.css">
</head>
<body>
	<img src="images/revradar.png"></img>
	<div class="orange-box">
		<h1>User Page</h1>
		<p>
		UserID: ${viewuser.userID}<br>
		Username: ${viewuser.username}<br>
		Password: ${viewuser.password}<br>
		First name:${viewuser.firstname}<br>
		Last name: ${viewuser.lastname}<br>
		Email: ${viewuser.email}<br>
		User Role: <c:if test="${viewuser.getUserRoleID()==1}">Employee</c:if>
				   <c:if test="${viewuser.getUserRoleID()==2}">Manager</c:if><br>
		
		<c:if test="${user.getUserRoleID()==2}"><a href="/ReimbursementSystem/viewemployees" class="button">Employee page</a></c:if>
		<c:if test="${user.getUserRoleID()==1}">
			<a href="/ReimbursementSystem/homepage.jsp" class="button">Homepage</a>
			<form action="edituser.jsp">
				<input type="submit" class="button" value="Edit">
			</form>
		</c:if>
	</div>
</body>
</html>