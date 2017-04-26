<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Verification Page</title>
</head>
<body>
<%
	//verifies if a person is a new employee or a current and checks to make sure they are
	//either a manaer or an employee and will be directed to the appropriate page
	
	//if a person is a new worker, they will added to the database.
	//if a person is a current worker, their credentials will be checked
	//against the database to make sure they are in the system and will 
	//be forwarded to the employee information page
	  
	RequestDispatcher rd = request.getRequestDispatcher("EmpInfo.jsp");
	rd.forward(request,response);
  

%>


</body>
</html>