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



String username=request.getParameter("username");
String password=request.getParameter("password");
User user=new User(username,password);
UserDAOImpl userDAO=new UserDAOImpl();

try {
	userDAO.Login(user);
	
	
}catch(IncorrectPassword e){
	out.println("Incorrect username or password");
	response.sendRedirect("incorrectlogininfo.jsp");
	
}
	
	%>
<div align="center">
<% out.println("Welcome Back<br/>"+username);%>
<form action="userloginoption.jsp" target="output" method="get">
<input type="submit" name="option" value="View my accounts" />
<input type="submit" name="option" value="Create an account" />
<input type="submit" name="option" value="Delete an empty account" />
<input type="submit" name="option" value="Make a deposit" />
<input type="submit" name="option" value="Make a withdrawl" />
<a href="BankHomePage.html"><input type="button" name="option" value="Logout" /></a>

<input type="hidden" name="username" value=<%out.print(request.getParameter("username")); %> />
<input type="hidden" name="password" value=<%out.print(request.getParameter("password")); %> />
</form>
</div>

<div align="center">
<iframe align="bottom" height="100%" width="100%" name="output"></iframe>
</div>

</body>
</html>