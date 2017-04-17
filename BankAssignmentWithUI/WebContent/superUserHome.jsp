<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Welcome Super User</title>
	<link rel="stylesheet" href="Login.css">
</head>
<body>
<!-- Session validation -->
<%
	if(session.getAttribute("superLogIn").equals("false"))
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
<div style="width: 100%; overflow: hidden; margin-top: 50px;">
<!-- Create a User -->
	<div style="width: 300px; float: left;">
	Create a user:
		<form action="superCreate" method="post">
			<ul class = "list">
		
				<li>
					<input type="text" name="c_u_name" placeholder="Username" required="" />*Required*<br/>
				</li>
		
				<li>
					<input type="text" name="c_u_pass" placeholder="Password" required=""/>*Required*<br/>
				</li>
		
				<li>		
					<input type="text" name="c_u_first" placeholder="First Name"/><br />
				</li>
		
				<li>
					<input type="text" name="c_u_last" placeholder="Last Name" /><br />
				</li>
			</ul> 
			<input type="submit" class="btn btn-lg btn-primary btn-block" name="Submit" value="Create User" type="Submit"></button><br>
		</form>
	</div>

<!-- Delete a User -->
	<div style="margin-left: 300px;">
	Delete a user:
			<form action="superDelete" method="post">
			<ul class = "list">
		
				<li>
					<input type="text" name="d_u_name" placeholder="Username" required="" />*Required*<br/>
				</li>

			</ul> 
			<input type="submit" class="btn btn-lg btn-primary btn-block" name="Submit" value="Delete User" type="Submit"></button>
		</form>
	</div>

</div>




<div style="width: 100%; overflow: hidden; margin-top: 50px;">
<!-- Update a User -->
	<div style="width: 300px; float: left;">
	Update a user: <br>
	(leave fields blank if not updating):
		<form action="superUpdate" method="post">
			<ul class = "list">
		
				<li>
					<input type="text" name="u_u_id" placeholder="User ID" required="" />*Required*<br/>
				</li>
		
				<li>
					<input type="text" name="u_u_name" placeholder="Username" required=""/>*Required*<br/>
				</li>
		
				<li>		
					<input type="text" name="u_u_pass" placeholder="Password"/><br />
				</li>
		
				<li>
					<input type="text" name="u_u_first" placeholder="First Name" /><br />
				</li>
						
				<li>
					<input type="text" name="u_u_last" placeholder="Last Name" /><br />
				</li>
			</ul> 
			<input type="submit" class="btn btn-lg btn-primary btn-block" name="Submit" value="Update User" type="Submit"></button><br>
		</form>
	</div>

</div>



<div style="width: 100%; overflow: hidden; margin-top: 50px;">
<!-- View all Users -->	
	<div style="width: 300px; float: left;">
	View all active users: 
		<form action="http://localhost:8081/BankAssignmentWithUI/superUserViewAll.jsp" method="post">
			<input type="submit" class="btn btn-lg btn-primary btn-block" name="Submit" value="View All Users" type="Submit"></button><br>
		</form>
	</div>
	
<!-- View a User -->
	<div style="margin-left: 300px;">
	View a user's details:
		<form action="superView" method="post">
			<ul class = "list">
		
				<li>
					<input type="text" name="v_u_name" placeholder="Username" required="" />*Required*<br/>
				</li>
			</ul>
			<input type="submit" class="btn btn-lg btn-primary btn-block" name="Submit" value="View User" type="Submit"></button><br>
		</form>
	</div>

</div>


<!-- Log out -->
	<div style=" margin-top: 50px">
		<form action="logout" method="post">
			<input type="submit" class="btn btn-lg btn-primary btn-block" name="logout" value="Log Out" type="Submit"></button><br>
		</form>
	</div>
</div>


</body>
</html>