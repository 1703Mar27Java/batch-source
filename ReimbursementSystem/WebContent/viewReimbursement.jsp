<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Reimbursement Page</title>
<link rel="stylesheet" href="radar.css">
</head>
<body>
	<img src="images/revradar.png"></img>
	<div class="orange-box">
		<h1>Reimbursement Page</h1>
		<p>
		Reimbursement ID: ${reimb.id}<br>
		description: ${reimb.description}<br>
		amount: ${reimb.amount}<br>
		submitterID:${reimb.submitterID}<br>
		submission time: ${reimb.timestamp}<br>
		resolverID: ${reimb.resolverID}<br>
		statusID: ${reimb.statusID}<br>
		</p>
		<c:if test="${user.getUserRoleID()==2}">
			<form action="/ReimbursementSystem/approvereimb?rid=${reimb.id}">
				<input type="submit" class="button" value="Approve">
			</form>
			<form action="/ReimbursementSystem/denyreimb?rid=${reimb.id}">
				<input type="submit" class="button" value="Deny">
			</form>
		</c:if>
		<form action="homepage.jsp">
			<input type="submit" class="button" value="Back to Homepage">
		</form>
	</div>
</body>
</html>