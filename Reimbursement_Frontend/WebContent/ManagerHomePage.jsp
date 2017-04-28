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

	<img src="Revature_CMYK.jpg" alt="logo" class="avatar">
	<br>
	<button id="showV" class="button" type="submit">View All Employees</button>
	<button id="showCR" class="button" type="submit">Change
		Reimbursements</button>
		<a href="loginPage.jsp"><button id="logout" class="button" type="submit">Logout</button>
	</a>
	<div>
		<iframe id="iet" src="innerManagerETable.jsp" height="100%"
			width="100%" style="border: none"></iframe>
	</div>

		<div id="">
			<iframe id="irt" src="innerManagerRTable.jsp" height="500"
				width="100%" style="border: none"></iframe>
		</div>

	<br>
	<script
		src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.0/jquery.min.js"></script>
	<script language="JavaScript">
		$(document).ready(function() {

			$("table").hide();
			$("iframe").hide();

			$("#showV").click(function() {
				
				if($("#iet").is(":visible") == true)			
					document.getElementById('iet').contentDocument.location.replace("innerManagerETable.jsp");
			
				
				$("#iet").toggle();
				
			});
			$("#showCR").click(function() {
				
				if($("#irt").is(":visible") == true)		
				document.getElementById('irt').contentDocument.location.replace("innerManagerRTable.jsp");
				$("#irt").toggle();
			});
			
		
			
		});
	</script>
</body>
</html>