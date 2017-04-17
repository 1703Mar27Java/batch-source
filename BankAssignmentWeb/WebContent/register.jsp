<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
    <%@ page import="com.revature.BankAssignment.domain.*" %>
    <%@ page import="com.revature.BankAssignment.dao.*" %>
    <%@ page import="com.revature.BankAssignment.exceptions.*" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Register as a new user</title>
</head>
<body>

<%



String username=request.getParameter("username");
String password=request.getParameter("password");

System.out.println("Username: "+username +"Password: "+password+ "attempting to create");


User user=new User(username,password);
UserDAOImpl UserDAO=new UserDAOImpl();

if(UserDAO.CreateUser(user))

out.print(username+" has been registered as a new user<br/>");

else
	out.print(username+" could not be created");




%>
<a href="BankHomePage.html">Go back to the home page</a>

</body>
</html>