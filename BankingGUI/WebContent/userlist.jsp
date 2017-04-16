<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>User List</title>
<link rel="stylesheet" href="bankpage.css">
</head>
<body>
	<h2>Local Bank</h2>
	<div class="white-box">
		<h1>User List</h1>
		<ul>
			<c:forEach var="row" items="${users}">
			<li><a href="/SelfLoginPage/viewuseracc?uid=${row.userID}"><div class="accountCard">
					<h3><c:out value="${row.username}"/></h3>
					</div></a>
			</li>
			</c:forEach>
			<a href="homepage.jsp" style="padding:40px 0px;">Return to homepage</a>
		</ul>
		
	</div>
	
</body>
</html>