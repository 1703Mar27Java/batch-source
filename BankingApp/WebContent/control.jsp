<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
pageEncoding="ISO-8859-1"%>
<%@ page import="com.Revature.beans.Bean"%>
<%@ page import="com.Revature.beans.BankAcct"%>
<%@ page import="java.util.ArrayList"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<%
	//Check if user is logged in
	if (session.getAttribute("uName") == null || session.getAttribute("uName").equals("")) {
		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/BankHome.jsp");
		dispatcher.forward(request, response);
	}
	//this fixes a wierd bug where our session attribute for admin doesn't properly get set
	//so I set an override that reads from the request attribute instead.
	if (session.getAttribute("isAdmin") == null || session.getAttribute("isAdmin").equals("")) {
		session.setAttribute("isAdmin", request.getParameter("isAdmin"));
	}
%>

<head>

	<meta http-equiv="X-UA-Compatible" content="IE=edge">
	<meta name="viewport" content="width=device-width, initial-scale=1">
	<link rel="shortcut icon" href="favicon.ico" type="image/x-icon">
	<title>Control Page</title>
	
	<!-- css links -->
	<link href="css/bootstrap-theme.min.css" rel="stylesheet" type="text/css">
	<link href="css/bootstrap.min.css" rel="stylesheet" type="text/css">
	<link href="css/jumbotron-thin.css" rel="stylesheet" type="text/css">
	<link href="css/dropdown.css" rel="stylesheet" type="text/css">
<style>
		form {
			text-align: center;
		}
		table {
		    font-family: arial, sans-serif;
		    border-collapse: collapse;
		    width: 100%;
		    width: 75%;
		}
		td, th {
		    border: 1px solid #dddddd;
		    text-align: left;
		    padding: 8px; 
		}
		th{
			background-color: #4CAF50;
		  		color: white;
		  		font-size: 225%;
		}
		td{
			font-size:200%
		}
		tr:nth-child(even) {
		    background-color: #dddddd;
		}
	
	</style>	
	
</head>

<!-- BODY -->
<body style="background-color: #d1d2d3">

	<%
		//set session Attributes retrieved during logon
		session.setAttribute("bean", request.getAttribute("bean"));
		session.setAttribute("isAdmin", request.getAttribute("isAdmin"));
	%>
	<div class="container">
		<div class="jumbotron">
			<h1>Control Page</h1>
			<%
				if(session.getAttribute("isAdmin")!=null && session.getAttribute("isAdmin").equals("true")){
			%>
				<h5>(ADMIN MODE ENABLED)</h5><%
			} 
			else 
			{ %>
				<h3>Hello, <%=(String) session.getAttribute("uName")%></h3> 
			<%} %>
			
			
		</div>
	</div>

	
	
	
	<div class="dropdown">
		<button class="dropbtn">Menu</button>
		<div class="dropdown-content">
			<a href="CreateAcct.jsp">Create Account</a> 
			<a href="DeleteAcct.jsp">Delete Account</a> 
			<a href="AddFunds.jsp">Add Funds</a> 
			<a href="SubFunds.jsp">Remove Funds</a> 
			<a href="showTrans">View Transactions</a> 
			<a href="logout.jsp">Logout</a>
		</div>
	</div>

	<h1>Your Bank Accounts</h1>
	
	<table align="center">
		<%
			//store data
			ArrayList<BankAcct> bList = null;
			if (session.getAttribute("bean") != null) {
			Bean b = new Bean(((Bean) session.getAttribute("bean")).getBankList());
			bList = new ArrayList<>(b.getBankList());
			
		}
		%>

		<tr>
			<% if(session.getAttribute("isAdmin")!=null && session.getAttribute("isAdmin").equals("true")){%>
			<th>User ID:</th>
			<th>Username:</th><%} %>
			<th>Account ID:</th>
			<th>Account Name:</th>
			<th>Balance:</th>
		</tr>
		<%
			//loopthrough each account owned by %USER
			if (bList != null) 
				for (BankAcct i : bList) {
		%>
		<tr>
			<% if(session.getAttribute("isAdmin")!=null && session.getAttribute("isAdmin").equals("true")){%>
			<td><%=i.getUid() %></td>
			<td><%=i.getuName() %></td><%} %>
			<td><%=i.getBid()%></td>
			<td><%=i.getaName()%></td>
			<td><%=i.getBal()%></td>
		</tr>
		<%
				}
		%>
	</table>




</body>
</html>