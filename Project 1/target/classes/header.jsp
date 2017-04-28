<%@page import="java.util.*"%>
<%@page import="com.revature.bean.*"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@page contentType="text/html; charset=ISO-8859-1"%>
<%@page pageEncoding="ISO-8859-1"%>
<%@page session="true"%>
<%
	ERS_USERS currentUser = (ERS_USERS) session.getAttribute("currentUser");
%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN"
 "http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd">
<html>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.0/jquery.min.js"></script>
<head>
<title>Revature ERS</title>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1" />
<link rel="stylesheet" href="style.css" />
</head>

<body>
	<div id="container">
		<c:if test="${currentUser != null}">
			<div id="nav">

				<ul>
					<li><a class="active"> Welcome <c:if
								test="${currentUser == null}">Guest</c:if> <c:if
								test="${currentUser != null}">
								<c:out value="${currentUser.getU_FIRSTNAME()}" />
							</c:if>
					</a></li>
					<li><a href="main.jsp">Home</a></li>


					<c:if test="${currentUser.getUR_ID() == 1}">
						<li><a href="employees.jsp">Manage</a></li>
						<li><a href="register.jsp">Register</a></li>
					</c:if>
					<c:if test="${currentUser.getUR_ID() == 2}">
						<li><a href="profile.jsp">Profile</a></li>
					</c:if>
					<c:if test="${currentUser.getUR_ID() == 2}">
						<li><a href="submit.jsp">Submit</a></li>
					</c:if>
					<li><a href="reimbursements.jsp">Reimbursements</a></li>
					<li style="float: right"><a class="active" href="logout.jsp">Logout</a></li>
					<li style="float: right"><a id="currentTime"></a></li>
				</ul>
			</div>
		</c:if>
	</div>