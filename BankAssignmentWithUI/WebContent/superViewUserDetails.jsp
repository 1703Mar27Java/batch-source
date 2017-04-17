<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>View User</title>
	<link rel="stylesheet" href="Login.css">
</head>
<body>
<div>
	<p class = "header1">Welcome to the ADYFB!
	</p>
	<p class = "header2">The Aesthetically Displeasing Yet Functional Bank</p>
</div>


<div class ="main-div">
	<div class="user-view">
	<%
		int userID = (Integer)session.getAttribute("userID");
		String username = (String)session.getAttribute("username");
		String password = (String)session.getAttribute("password");
		String firstName = (String)session.getAttribute("firstName");
		String lastName = (String)session.getAttribute("lastName");
	%>
	
	UserID: <%out.print(userID); %><br>
	First Name: <%out.print(firstName); %><br>
	Last Name: <%out.print(lastName); %><br>
	Username: <%out.print(username); %><br>
	Password:<%out.print(password); %><br>

	</div>

	<div>
		<form action="http://localhost:8081/BankAssignmentWithUI/superUserHome.jsp">
			<input type="submit" value="Go Home">
		</form>
	</div>
</div>


</body>
</html>