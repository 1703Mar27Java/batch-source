<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
   <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>User page</title>
<link rel="stylesheet" href="bankpage.css">
</head>
<body>
	<h2>Local Bank</h2>
	<div class="white-box">
		<h1>User page for ${viewuser.getUsername()}</h1>
		<div style="float:left;">
			<p>
			<h4 style="margin-left:40px;">User ID: ${viewuser.getUserID()}</h4>
			<h4 style="margin-left:40px;">Password: ${viewuser.getPassword()}</h4>
			<h4 style="margin-left:40px;">Super User: 	
				<c:choose> 
					<c:when test="${viewuser.isSuperPriv()>0}">Yes</c:when>
					<c:otherwise>No</c:otherwise>
				</c:choose></h4>
			</p>
			<a href="userlist.jsp" style="margin-left:40px;">Return to user list</a>
		</div>
		
		<a href="edituser.jsp"><div class="firstButton">
			<img src="images/editButton.png"></img>
		</div></a>
		<a href="deleteuser"><div class="secondButton">
			<img src="images/deleteButton.png"></img>
		</div></a>
		
	</div>
</body>
</html>