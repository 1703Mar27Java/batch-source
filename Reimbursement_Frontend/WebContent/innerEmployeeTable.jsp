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
<title>Home Page</title>
</head>
<body>
	<sql:setDataSource var="source" driver="oracle.jdbc.OracleDriver"
		url="jdbc:oracle:thin:@ebdb.cti5brw1nrxx.us-east-2.rds.amazonaws.com:1521:ORCL"
		user="Eeric5" password="motter1281" />
	<table>
		<tr>
			<th>Employee Id</th>
			<th>Username</th>
			<th>Password</th>
			<th>Firstname</th>
			<th>Lastname</th>
			<th>Email</th>
			<th>Role</th>
		</tr>
		<sql:query dataSource="${source}" var="result">
      SELECT * FROM ERS_USERS WHERE U_ID = ?
      <sql:param value='${sessionScope["id"]}' />
		</sql:query>
		<c:forEach var="row" items="${result.rows}">
			<tr>
				<td><c:out value="${row.U_ID}" /></td>
				<td><c:out value="${row.U_USERNAME}" /></td>
				<td><c:out value="${row.U_PASSWORD}" /></td>
				<td><c:out value="${row.U_FIRSTNAME}" /></td>
				<td><c:out value="${row.U_LASTNAME}" /></td>
				<td><c:out value="${row.U_EMAIL}" /></td>
				<c:set var="Role" scope="session" value="${row.UR_ID}"/>
				<c:if test="${Role ==  1}">
					<td><c:out value="Employee"></c:out></td>
					</c:if>
				<c:if test="${Role ==  2}">
					<td><c:out value="Manager"></c:out></td>
					</c:if>
			</tr>
		</c:forEach>

		<form method="post" action="UpdateServlet" width="100%"
			enctype="multipart/form-data">
			<tr>
				<th></th>
				<th><input name="u" placeholder="Enter Username"></th>
				<th><input name="p" placeholder="Enter Password"></th>
				<th><input name="f" placeholder="Enter Firstname"></th>
				<th><input name="l" placeholder="Enter Lastname"></th>
				<th><input name="e" placeholder="Enter Email"></th>
				<th><input name="Add" class="button" type="submit"
					value="Update"></input></th>
			</tr>
		</form>
	</table>
	<script
		src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.0/jquery.min.js"></script>
	<script language="JavaScript">
		$(document).ready(function() {

			console.log($("#role").text("test"));

		});
	</script>
</body>
</html>