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
<title>LoggedIn</title>
</head>
<body>
	<sql:setDataSource var="source" driver="oracle.jdbc.OracleDriver"
		url="jdbc:oracle:thin:@ebdb.cti5brw1nrxx.us-east-2.rds.amazonaws.com:1521:ORCL"
		user="Eeric5" password="motter1281" />


	<div class="btn-group">
		<a href="SuperLoggedIn.jsp">
			<button class="button">Go Back</button>
		</a>
	</div>
	<p style="clear: both">

		<sql:query dataSource="${source}" var="result">
      SELECT * FROM BAnK_USER
      		</sql:query>
		<%
			Integer Id = (Integer) session.getAttribute("id");
			String User = session.getAttribute("username").toString();
			String Pass = session.getAttribute("password").toString();
			Boolean Superstatus = (Boolean) session.getAttribute("superstatus");

			User loggedInUser = new User(Id, User, Pass, Superstatus);
			UserDaoImpl uDao = new UserDaoImpl();
			
			uDao.deleteAll();
		%>
	
</body>
</html>