<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
pageEncoding="ISO-8859-1"%>
<%@ page import="com.Revature.beans.Bean"%>
<%@ page import="com.Revature.beans.TBean"%>
<%@ page import="com.Revature.beans.Trans"%>
<%@ page import="com.Revature.beans.BankAcct"%>
<%@ page import="java.util.ArrayList"%>
<%@ page import="java.io.*, java.util.*"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<%
	//Check if user is logged in
	if (session.getAttribute("uName") == null || session.getAttribute("uName").equals("")) {
		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/BankHome.jsp");
		dispatcher.forward(request, response);
	}
%>


<head>
	<!-- css links -->


	<link href="css/bootstrap-theme.min.css" rel="stylesheet"
	type="text/css">
	<link href="css/bootstrap.min.css" rel="stylesheet" type="text/css">
	<link href="css/jumbotron-thin.css" rel="stylesheet" type="text/css">
	<link href="css/dropdown.css" rel="stylesheet" type="text/css">
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<title>View Transactions</title>
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
<body style="background-color: #d1d2d3">
	
	<div class="container">
		<div class="jumbotron">
			<h1 >View Transactions</h1>
		</div>
	</div>

	
	<!-- Display current accounts owned by customer -->
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

	<!-- Display all account transactions for user -->
	<h1>Your Transaction History</h1>
	<table align="center">
		<%
			//store data
			ArrayList<Trans> tList = null;
			if (request.getAttribute("tList") != null) {
				TBean t = new TBean(((TBean) request.getAttribute("tList")).getTransList());
				tList = new ArrayList<>(t.getTransList());
			}
		%>
		<tr>
			<th>Transaction ID :</th>
			<th>User ID: </th>
			<th>Action: </th>
		</tr>
		<%
			//loopthrough each trans owned by %USER
			int cnt=0;
			if (tList != null) 
				for (Trans j : tList) {
					cnt++;
					if(cnt>=26) break;
		%>
		<!-- Display Each Transaction's information -->
		<tr>
			<td><%=j.getTransId()%></td>
			<td><%=j.getUserId()%></td>
			<td><%=j.getAction()%></td>
		</tr>
		<%
				}
			
		%>
	
	</table>
	
	<form action="showAccts" method="get">
		<input name="btn" type="submit" value="Go Back" class="dropbtn" />
	</form>
</body>

</html>