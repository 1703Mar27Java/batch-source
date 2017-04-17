<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ page import="com.revature.BankAssignment.domain.*" %>
    <%@ page import="com.revature.BankAssignment.dao.*" %>
    <%@ page import="com.revature.BankAssignment.exceptions.*" %>
   
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Ben's Bank Super User</title>
</head>
<body>

<%



String username=request.getParameter("username");
String password=request.getParameter("password");
User user=new User(username,password);
UserDAOImpl userDAO=new UserDAOImpl();

if(username.equals("SuperUser") && password.equals("SuperUser")){
	
	out.print("Welcome back SuperUser<br/>");
}
	
else{
	response.sendRedirect("incorrectlogininfo.jsp");
}

	%>
<div align="center">
<form action="superuserloginoption.jsp" target="output" method="get">
<input type="submit" name="option" value="View all users" />
<input type="submit" name="option" value="Create a user" />
<input type="submit" name="option" value="Update a user" />
<input type="submit" name="option" value="Delete a user" />
<a href="BankHomePage.html"><input type="button" name="option" value="Logout" /></a>

<input type="hidden" name="username" value=<%out.print(request.getParameter("username")); %> />
<input type="hidden" name="password" value=<%out.print(request.getParameter("password")); %> />
</form>

<iframe name="output"></iframe>
</div>

</body>
</html>