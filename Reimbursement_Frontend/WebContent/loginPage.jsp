<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@ page import="com.revature.dao.*"%>
<%@ page import="com.revature.domain.*"%>

<%@ page import="java.io.*,java.util.*,java.sql.*"%>
<%@ page import="javax.servlet.http.*,javax.servlet.*"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql"%>


<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<link rel="stylesheet" href="Style.css">
<head>


<title>RERP</title>
</head>
<body>

	<sql:setDataSource var="source" driver="oracle.jdbc.OracleDriver"
		url="jdbc:oracle:thin:@ebdb.cti5brw1nrxx.us-east-2.rds.amazonaws.com:1521:ORCL"
		user="Eeric5" password="motter1281" />

	<img src="Revature_CMYK.jpg" alt="logo" class="avatar">
	<br>
	<p class="header">Revature Employee Reimbursement Portal</p>
	<br>
	<form class="login">
		<div class="container">
			<label><b>Username:</b></label> <input id="user" type="text"
				placeholder="Enter Username" name="uname" required><br>

			<label><b>Password:</b></label> <input id="pass" type="password"
				placeholder="Enter Password" name="psw" required><br> <input
				type="radio" name="User" value="Employee" checked>Employee<br>
			<input type="radio" name="User" value="Manager">Manager<br>
			<button class="button" onClick="login()" type="submit">Login</button>
		</div>


	</form>
</body>
<script language="JavaScript">
	var space = " ";
	var speed = "500";
	var pos = 0;
	var msg = " Revature Employee Reimbursement Portal ";
	function Scroll() {
		document.title = msg.substring(pos, msg.length) + space
				+ msg.substring(0, pos);
		pos++;
		if (pos > msg.length)
			pos = 0;
		window.setTimeout("Scroll()", speed);
	}
	Scroll();
	function login() {
<%Employee loggingEmployee = new Employee();

			if (request.getParameter("uname") != null && request.getParameter("psw") != null) {
				loggingEmployee.setEmployeeUsername(request.getParameter("uname"));
				loggingEmployee.setEmployeePassword(request.getParameter("psw"));

				EmployeeDaoImpl eDao = new EmployeeDaoImpl();

				if (eDao.login(loggingEmployee) != true) {
					out.println("Invalid Username or Password");
					response.sendRedirect("loginPage.jsp");
				} else {
					session.setAttribute("user", loggingEmployee.getEmployeeUsername());
					session.setAttribute("pass", loggingEmployee.getEmployeePassword());
					session.setAttribute("first", loggingEmployee.getEmployeeFirstname());
					session.setAttribute("last", loggingEmployee.getEmployeeLastname());
					session.setAttribute("email", loggingEmployee.getEmployeeEmail());
					session.setAttribute("id", loggingEmployee.getEmployeeID());
					session.setAttribute("role", loggingEmployee.getUserRoleID());

					if (request.getParameter("User").equals("Employee"))
						response.sendRedirect("EmployeeHomePage.jsp");
					if (request.getParameter("User").equals("Manager")) {
						if (loggingEmployee.getUserRoleID() == Roles.Manager)
							response.sendRedirect("ManagerHomePage.jsp");
						else
							response.sendRedirect("loginPage.jsp");

					}
				}
			}%>
	}
</script>

</html>