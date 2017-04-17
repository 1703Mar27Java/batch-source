<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<link rel="stylesheet" href="homepage.css">
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<head>
<title>Banking Application</title>

</head>
<body>


	<div class="btn-group">
  		
  		<a href="LoginUser.jsp">
  		<button class="button">Login</button>
  		</a>
  		
  		<a href="CreateUser.jsp">
  		<button onClick="CreateUser()" class="button">Create User</button>
  		</a>
  		
  		<button class="button">Next Action</button>
  		
  		<button class="button">Free Money</button>
	</div>
	
	<img src="department_money_large.jpg" alt="Mountain View"
		style="width:100%; height:auto;">
	
	<h1>Hello</h1>
	
<%-- 	<% session.setAttribute("currentPage", "HomePage"); %> --%>
	
	<p style="clear:both">
	<audio controls autoplay>

  <br><br><br><source src="Thanks.mp3" type="audio/mpeg">
Your browser does not support the audio element.
</audio>
	</body>
</html>