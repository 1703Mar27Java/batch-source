<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ page import="com.revature.BankAssignment.domain.*" %>
    <%@ page import="com.revature.BankAssignment.dao.*" %>
    <%@ page import="com.revature.BankAssignment.exceptions.*" %>
   
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Ben's Bank your account</title>
</head>
<body>

<%


//target.classes.com.revature.BankAssignment.domain.User user;
String username=request.getParameter("username");
String password=request.getParameter("password");
User user=new User(username,password);
UserDAOImpl userDAO=new UserDAOImpl();

try {
	userDAO.Login(user);
	out.println("You have logged in successfully");
	
}catch(IncorrectPassword e){
	out.println("Incorrect username or password");
}
	
	%>


</body>
</html>