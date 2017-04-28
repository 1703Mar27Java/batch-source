<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
     <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="s" %>    

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>ERS Employee Login Portal</title>
<link rel="stylesheet" type="text/css" href="styles.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.0/jquery.min.js"></script>
<script src="ers.js"></script>	
</head>
<body>
<div class="container">

<header>
   <h1>Employee Reimbursement System</h1>
   <h2>Manager and Employee Login Portal</h2>
</header>
  
<nav>
  <ul>
    <li><a href="Login.jsp"><strong>Login</strong></a></li>
    <li><a href="index.html"><strong>Home</strong></a></li>
    <li><a href="About.html"><strong>About ERS</strong></a></li>
  </ul>

<content >
	<p>Current Managers and Employees Sign In Here:</p>
	<form action="Info.jsp" method="post" name="name" onkeyup="sendInfo()" >
	<label>Username</label>
	<input id="ename" type="text" name="username">
	<br/>
	<br/>
	<label>Password</label>
	<input id="password" type="password" name="password"><br/><br/>
	<input type="submit" value="Submit">
	</form>
	<br/>
	<br/>
	<br/>
	<p>New Managers and Employees: Create an Account Here:</p>
	<form action="LoginServlet" method="post">
 	<label>User Role Id</label> 
	<input id="ur" type="text" name="ur">
	<br/>
	<br/>
	<label>User Role</label>
	<select name="role">
	<option value="employee">Employee</option>
	<option value="manager">Manager</option>
	</select>
	<br/>
	<br/>
	<input type="submit" value="Submit">
	</form>
	<br/>
	<br/>
	<form  action="EmpServlet" method="post">
	<label>User Id (Same as User Role Id)</label>
	<input id="id" type="text" name="id">
	<br/>
	<br/>	
	<label>Username</label>
	<input id="ename" type="text" name="username">
	<br/>
	<br/>
	<label>Password</label>
	<input id="password" type="password" name="password">
	<br/>
	<br/>
	<label>First Name</label>
	<input id="fname" type="text" name="first">
	<br/>
	<br/>
	<label>Last Name</label>
	<input id="lname" type="text" name="last">
	<br/>
	<br/>
	<label>Email</label>
	<input id="email" type="text" name="email"><br/><br/>
	<label>User Role Id Again</label>
	<input id="ur" type="text" name="urid">
	<br/>
	<br/>	
	<input type="submit" value="Submit">
	</form>
</content>
<span id="out"></span>
<footer>Copyright &copy; W3Schools.com</footer>

</div>

</body>
</html>