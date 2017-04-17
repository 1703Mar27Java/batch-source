<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@ page import="com.revature.Dao.*"%>
<%@ page import="com.revature.Domain.*"%>

<%@ page import="java.io.*,java.util.*,java.sql.*"%>
<%@ page import="javax.servlet.http.*,javax.servlet.*"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql"%>


<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link rel="stylesheet" href="homepage.css">
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Create User</title>
</head>
<body>

	<sql:setDataSource var="source" driver="oracle.jdbc.OracleDriver"
		url="jdbc:oracle:thin:@ebdb.cti5brw1nrxx.us-east-2.rds.amazonaws.com:1521:ORCL"
		user="Eeric5" password="motter1281" />
	<%-- 	<sql:query dataSource="${source}" var="result"> --%>
	<!--         SELECT * FROM BANK_USER -->
	<%--         </sql:query> --%>

	<div class="btn-group">
		<a href="Homepage.jsp">
			<button class="button">Go Back</button>
		</a>
	</div>
	<br>
	<br>
	<br>

	<form method="post">
		Username: <input type="text" align="middle" name="userN"> <br>
		Password: <input type="password" align="middle" name="passW"><br>
		<a href="LoggedInUser.jsp"> <input type="submit">
		</a>
	</form>
	<%
		String username = request.getParameter("userN");
		String password = request.getParameter("passW");

		if (username != null & password != null) {

			User newuser = new com.revature.Domain.User(username, password, false);
			UserDaoImpl uDao = new UserDaoImpl();

			uDao.createUser(newuser);

			session.setAttribute("username", newuser.getUserName());
			session.setAttribute("password", newuser.getPassword());
			session.setAttribute("superstatus", newuser.getSuperUser());
			session.setAttribute("id", newuser.getUserID());

			request.setAttribute("username", newuser.getUserName());
			request.setAttribute("password", newuser.getPassword());
			request.setAttribute("superstatus", newuser.getSuperUser());
			request.setAttribute("id", newuser.getUserID());
			request.getRequestDispatcher("LoggedIn.jsp").forward(request, response);
		}
	%>

	<!-- 	<table border="1"> -->
	<!-- 		<tr> -->
	<!-- 			<td>Text:</td> -->
	<!-- 			<td><input type="text" name="myText" id="myText" value=""></td> -->
	<!-- 			<td><input type="Submit" value="Click to Submit"></td> -->
	<!-- 		</tr> -->
	<!-- 	</table> -->

</body>
</html>