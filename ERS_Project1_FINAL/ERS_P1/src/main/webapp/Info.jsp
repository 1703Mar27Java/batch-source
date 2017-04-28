<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
 <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="s" %>    
<%@ page import="java.util.*" %>
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
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Employee Information</title>
<link rel="stylesheet" type="text/css" href="styles.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.0/jquery.min.js"></script>
<script src="ers.js"></script>	
</head>
<body>
<header>
   <h1>Employee Reimbursement System</h1>
   <h2>General Information</h2>
</header>
  
<nav>
  <ul>
    <li><a href="Login.jsp"><strong>Login</strong></a></li>
    <li><a href="index.html"><strong>Home</strong></a></li>
    <li><a href="About.html"><strong>About ERS</strong></a></li>
     <li><a href="reimbursements.jsp"><strong>Reimbursement Forms</strong></a></li>
  </ul>
  </nav>
<br/>
<br/>
<div>
<content>
	<p id="p1">this page will use special effects</p>
	
 <br/>
 <br/>
 <br/>
 <h3>Submit Reimbursement Requests</h3>
<form action="ReimbursementSerlet" method="post">
<label>Amount</label>
<input type="text" name="amt"/>
<br/>
<br/>
<label>Description</label>
<input type="text" name="desc"/>
<br/>
<br/>
<input type="submit" value="Submit"/>
</form>
</content>
</div>
<br/>
<br/>
<br/>
<br/>
<footer>Copyright &copy; W3Schools.com</footer>
<br/>

</body>
</html>