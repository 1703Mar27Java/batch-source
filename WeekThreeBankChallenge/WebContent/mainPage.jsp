<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Bank app main page</title>
	<link rel = "stylesheet" href="bankStyles1.css">
	<style>
		th {
    		color: red;
    		border: border: 3px solid red;
		}
		td {
			color: red;
			background-color: firebrick;
		}
		
		tr {
			border: border: 3px solid red;
		}
		
		h4{
			color: red;
			text-align: left;
		}
	</style>
	
	<%@ page import="com.revature.dao.BankAccountDaoImpl" %>
	
	<!-- user -->
	<%String userId = (String)session.getAttribute("userId");%>
	<%String userName = (String)session.getAttribute("userName"); %>
	
	<!-- bank account -->
	<%String acctName = (String)session.getAttribute("accountName"); %>
	<%String balance = (String)session.getAttribute("balance"); %>
	<%String acctId = (String)session.getAttribute("bankId");%>
	
</head>
<body>
	<%
		if (userId == null){
			response.sendRedirect("homePage.html");
		}
	%>
	<%=userId%><br>
	<Table class = "outer">
		<TR>
			<TD>
			<TABLE class = "banner">
   				<TR>
      				<TD>
      					<h4>Welcome ${userName}<h4>
      					<form action="logout" method="post">
							<input class = "lbl" type="submit" value="Logout" />
						</form>
      				</TD>	
   				</TR>
			</TABLE>
			</TD>
		</TR>
		<tr>
			<td>
			<h4>Current Bank Account</h4>
			<table class = "inner">
				<th>Account id</th>
				<th>Account name</th>
				<th>Balance</th>
				<tr>
					<td><%=acctId%></td>
					<td><%=acctName%></td>
					<td><%=balance%><br></td>
				</tr>
			</table>
			</td>
		</tr>
		<tr>
			<td>
				<table class = "inner">
					<tr> 
						<th>Withdraw / deposit</th>
						<td>
							<form action="changeBalance" method="post">
  								<p class = "lbl">Deposit Amt:<input type="text" name="amount"><br></p> 
								<input class = "lbl" type="submit" value="Deposit" />
							</form>
						</td>
						<td>
							<form action="changeBalance" method="post">
  								<p class = "lbl">Withdrawal Amt:<input type="text" name="amount"><br></p> 
								<input class = "lbl" type="submit" value="Withdraw" />
							</form>
							</td>
					</tr>
					<tr>
						<th>Change account</th>
						<td>
							<form action="ChangeAccount" method="get">
  								<p class = "lbl">Acct ID:<input type="text" name="un"><p>
								<input class = "lbl" type="submit" value="Change Acct" />
							</form>
						</td>
					</tr>
					<tr>
						<th>View All Accounts</th>
						<td>
							<form action="myAccounts" method="post">
								<input class = "lbl" type="submit" value="View all accounts" />
							</form>
						</td>
					</tr>
					<tr>
						<th>Create New Account</th>
						<td>
							<form action="createAccount" method="get">
								<input class = "lbl" type="submit" value="Create new account" />
							</form>
						</td>
					</tr>
				</table>	
				
			</td>
		</tr>
	</Table>
	
</body>