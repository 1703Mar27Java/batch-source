<%@page import="java.util.*"%>
<%@page import="com.revature.bean.*"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@page contentType="text/html; charset=ISO-8859-1"%>
<%@page pageEncoding="ISO-8859-1"%>
<%@page session="true"%>
<%
	ERS_USERS currentUser = (ERS_USERS) session.getAttribute("currentUser");
%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN"
 "http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd">
<html>
<head>
<title>Employee Reimbursement System</title>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1" />
<link rel="stylesheet" href="/css/base.css" />
</head>

<body>
	<div id="container">

		<div id="header">
			<div id="subbar">
				<p>
					Welcome
					<%=currentUser == null ? "Guest" : currentUser.getU_FIRSTNAME() + " " + currentUser.getU_LASTNAME()%></p>
			</div>
		</div>
		<%
			if (currentUser != null) {
		%>
		<div id="nav">

			<ul>

				<li><a href="main.jsp">Home</a></li>
				<%
					if (currentUser.getUR_ID() == 1) {
				%>

				<li><a href="employees.jsp">Employees</a></li>
				<li><a href="register.jsp">Register</a></li>

				<%
					} else if (currentUser.getUR_ID() == 2) {
				%>

				<li><a href="submit.jsp">Submit</a></li>
				<li><a href="profile.jsp">Profile</a></li>

				<%
					}
				%>

				<li><a href="reimbursements.jsp">Reimbursements</a></li>
				<li><a href="logout.jsp">Logout</a></li>
			</ul>
		</div>
		<%
			}
		%>
	</div>