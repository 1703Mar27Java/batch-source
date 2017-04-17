<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
   <%@ page import="java.util.*" %>
   <%@ page import="com.revature.util.BankUserUtil" %>
   <%@ page import="com.revature.domain.BankUser" %>
   
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" href="Login.css">

<title>View All Users</title>
</head>
<body>
<div>
	<p class = "header1">Welcome to the ADYFB!
	</p>
	<p class = "header2">The Aesthetically Displeasing Yet Functional Bank</p>
</div>

<div class = "main-div">
	<div>
		<table class = "table">
			<tr>
				<th>UserID</th>
				<th>Username</th>
				<th>Password</th>
				<th>First Name</th>
				<th>Last Name</th>	
			</tr>
			<%
			ArrayList<BankUser> users = (ArrayList<BankUser>)BankUserUtil.getAllBankUsersHelper();
			for(int i = 0; i < users.size(); i++)
			{
			%><tr><%
			%><td><%	out.print(users.get(i).getUserID() + " ");%></td><%
			%><td><%	out.print(users.get(i).getFirstName() + " ");%></td><%
			%><td><%	out.print(users.get(i).getLastName() + " ");%></td><%
			%><td><%	out.print(users.get(i).getUserName() + " ");%></td><%
			%><td><%	out.print(users.get(i).getUserPassword() + " ");%></td><%
			%></tr><%
			}
			%>
		</table>	
	</div>

	<div>
		<form action="http://localhost:8081/BankAssignmentWithUI/superUserHome.jsp">
			<input type="submit" value="Go Home">
		</form>
	</div>
</div>

</body>
</html>