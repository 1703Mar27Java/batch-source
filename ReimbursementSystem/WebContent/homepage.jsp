<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>Homepage</title>
<link rel="stylesheet" href="radar.css">
<style>
form{
	clear: right;
	float: right;
	margin-right: 50px;
	margin-top:5px;
}
</style>
</head>
<body>
	<img src="images/revradar.png"></img>
	<div class="orange-box">
		<h1>Welcome, ${user.getUsername()}</h1>
		
		<ul>
			<!-- implement viewreimb to servlet -->
			<!--  
			<c:forEach var="row" items="${reimbs}">
			<li><a href="/ReimbursementSystem/viewreimb?rid=${row.accountID}"><div class="accountCard">
					<h3><c:out value="${row.accountName}"/>
						<c:out value="${row.balance}"/></h3>
					</div></a>
			</li>
			</c:forEach>
			-->
		</ul>
		
		<form action="createReimbursement.html">
			<input type="submit" class="button" value="New Reimbursement">
		</form>
		
	</div>
</body>
<script>
	
</script>
</html>