<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
   <%@ page import="java.util.*" %>
   <%@ page import="com.revature.util.BankAccountUtil" %>
   <%@ page import="com.revature.domain.BankAccount" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<title>Welcome!</title>
	<link rel="stylesheet" href="Login.css">
</head>
<body>
<%
	if(session.getAttribute("loggedIn").equals("false"))
	{
		response.sendRedirect("login.html");
	}

%>

<div>
	<p class = "header1">Welcome to the ADYFB!
	</p>
	<p class = "header2">The Aesthetically Displeasing Yet Functional Bank</p>
</div>


<div class = "main-div">
	<div class="table">
		<%ArrayList<BankAccount> users = (ArrayList<BankAccount>)BankAccountUtil.getAccounts((Integer)session.getAttribute("uID")); %>
		<%if(users.size() != 0)
		{%>
		
		<table>
			<tr>
				<th>Account ID</th>
				<th>Account Name</th>
				<th>Balance</th>
			</tr>
			<%
		
			for(int i = 0; i < users.size(); i++)
			{
			%><tr><%
			%><td><%	out.print(users.get(i).getAccountID() + " ");%></td><%
			%><td><%	out.print(users.get(i).getAccountName() + " ");%></td><%
			%><td><%	out.print(users.get(i).getBalance() + " ");%></td><%
			%></tr><%
			}
			%>
		</table>
		<%}%>	
	</div>

<!-- Deposit into an account -->
<div style="width: 100%; overflow: hidden; margin-top: 50px;"> 
	<div style="width: 300px; float: left;">
		Deposit
		<form action="userDeposit" method="post">
			<ul class="list">
				<li>
					<input type="text" name="d_a_id" placeholder="Account ID" required="" />*Required*<br/>
				</li>
				<li>
					<input type="text" name="d_a_amt" placeholder="Amount" required="" />*Required*<br/>
				</li>
			</ul>
			<input type="submit" class="btn btn-lg btn-primary btn-block" name="Submit" value="Deposit" type="Submit"></button><br>
		</form>
	</div>
	
<!-- Withdrawal from an account -->
	<div style="margin-left: 300px;">
		Withdrawal
		<form action="userWithdrawal" method="post">
			<ul class="list">
				<li>
					<input type="text" name="w_a_id" placeholder="Account ID" required="" />*Required*<br/>
				</li>
				<li>
					<input type="text" name="w_a_amt" placeholder="Amount" required="" />*Required*<br/>
				</li>
			</ul>
			<input type="submit" class="btn btn-lg btn-primary btn-block" name="Submit" value="Withdrawal" type="Submit"></button><br>
		</form>
	</div>
	
</div>



<div style="width: 100%; overflow: hidden; margin-top: 50px;">

<!-- Create an account -->
	<div style="width: 300px; float: left;">
	Create and account:
		<form action="userCreate" method="post">
			<ul class="list">
				<li>
					<input type="text" name="c_a_acctName" placeholder="Account Name" required="" />*Required*<br/>
				</li>
				<li>
					<input type="text" name="c_a_amt" placeholder="Amount" required="" />*Required*<br/>
				</li>
			</ul>
			<input type="submit" class="btn btn-lg btn-primary btn-block" name="Submit" value="Create Account" type="Submit"></button><br>
		</form>
	</div>
	
<!-- Delete an account -->
	<div style="margin-left: 300px;">
	Delete an Account:
			<form action="userDelete" method="post">
			<ul class="list">
				<li>
					<input type="text" name="d_a_acctID" placeholder="Account ID" required="" />*Required*<br/>
				</li>
			</ul>
			<input type="submit" class="btn btn-lg btn-primary btn-block" name="Submit" value="Delete Account" type="Submit"></button><br>
		</form>
	</div>
	
</div>


<!-- Logout -->
	<div>
		Log out
		<form action="logout" method="post">
			<input type="submit" class="btn btn-lg btn-primary btn-block" name="logout" value="Log Out" type="Submit"></button><br>
		</form>
	
	</div>
</div>




</body>
</html>