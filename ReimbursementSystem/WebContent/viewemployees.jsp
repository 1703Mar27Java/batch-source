<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>View Employees</title>
<link rel="stylesheet" href="radar.css">
</head>
<body>
	<img src="images/revradar.png"></img>
	<div class="orange-box">
		<h1>Employees</h1>
		<div id="list" class="listbox">
		<ul>
			<c:forEach var="row" items="${users}">
			<li><a href="/ReimbursementSystem/viewuser?uid=${row.userID}"><div class="accountCard">
					<h3><c:out value="${row.firstname}"/>
						<c:out value=" ${row.lastname}"/></h3>
					</div></a>
			</li>
			</c:forEach>
		</ul>
		</div>
		<a href="homepage.jsp" class="button">Back to Homepage</a>
	</div>
</body>
</html>