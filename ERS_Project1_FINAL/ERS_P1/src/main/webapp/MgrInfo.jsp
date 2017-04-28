<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="s" %>    


<%String str = request.getParameter("username"); 
session.setAttribute("username",request.getParameter("username"));%>
 Welcome <%=session.getAttribute("username")%>
<%if (session.getAttribute("username").equals("")){ %>
<a href="Login.jsp"><b>Login</b></a>
<%} 
else{%>
<a href="logout.jsp"><b>Logout</b></a>
<%}
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta charset="ISO-8859-1">
<title>Employee Reimbursement System</title>
<link rel="stylesheet" type="text/css" href="styles.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.0/jquery.min.js"></script>
<script src="ers.js"></script>	
</head>
<body>
<div class="container">
<header>
   <h1>Employee Reimbursement System</h1>
   <h2>Manager Information</h2>
</header> 
<nav>
  <ul>
    <li><a href="index.html"><strong>Return to Home</strong></a></li>
  </ul>
</nav>
<br/>
<br/>
<br/>
<content>
	
	<h3>Where all the bosses come to rant about our employees and to spy on them.</h3>
	<p>this page will use special effects</p>

 <br/>
 <br>
 <br/>
 <h3>Approve Reimbursement Requests</h3>
<form action="ReimbursementStatus" method="post">
<label>Status</label>
<select>
<option name="app" value="app"/>Approved</option>
<option name="deny" value="deny"/>Denied</option>
</select>
<br/>
<br/>
<label>Type</label>
<input type="text" name="type"/>
<br/>
<br/>
<label>Resolved?</label>
<select>
<option name="y" value="app"/>Yes</option>
<option name="n" value="deny"/>No</option><br/><br/>
<br/>
<br/>
<input type="submit" value="Submit"/>
</form>
</content>
<br/>
<br/>
<br/>
<br/>
<br/>
<footer>Copyright &copy; W3Schools.com</footer>

</div>

</body>
</html>