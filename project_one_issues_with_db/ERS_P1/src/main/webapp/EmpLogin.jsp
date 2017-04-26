<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
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
   <h2>Employee Login Portal</h2>
</header>
  
<nav>
  <ul>
    <li><a href="index.html"><strong>Return to home</strong></a></li>
  </ul>
</nav>

<content >
	<p>Current Employees Sign In Here:</p>
	<form action="verification.jsp" method="post" >
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
	<p>New Employees: Create an Account Here:</p>
	<form action="LoginServlet" method="post" >
<!--  <label>UR Id</label> -->	
<!--	<input id="ur" type="text" name="ur">  -->	
	<br/>
	<br/>
	<label>User Role</label>
	<input id="emp" type="text" name="emp">
	<br/>
	<br/>
	<input type="submit" value="Submit">
	</form>
	<br/>
	<br/>
	<form  action="EmpServlet" method="post">
<!--	<label>User Id</label>-->
<!--	<input id="id" type="text" name="id">-->
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
	<input type="submit" value="Submit">
	</form>
	<br/>
	<br/>
</content>

<footer>Copyright &copy; W3Schools.com</footer>

</div>

</body>
</html>