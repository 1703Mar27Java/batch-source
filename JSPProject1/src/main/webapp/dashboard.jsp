<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<!-- include some JQuery in this document -->
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.0/jquery.min.js"></script>

<!--<link rel="stylesheet" type="text/css" href="bootstrap-3.3.7-dist/css/bootstrap.css">
<link rel="stylesheet" href="bootstrap-3.3.7-dist/css/bootstrap.min.css">-->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<link rel = "stylesheet" href="TableStyles.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.0/jquery.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>

<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Dashboard</title>
	<!-- user -->
	<%String userId = (String)session.getAttribute("userId");%>
	<%String userName = (String)session.getAttribute("userName"); %>
	<%String userRole = (String)session.getAttribute("userRole"); %>
	<%String emailAddress = (String)session.getAttribute("email"); %>
	
	  <style>
   	 /* Set height of the grid so .sidenav can be 100% (adjust if needed) */
   	 body {
   	 	background-color: lightblue
   	 }
   	 .row.content {
   	 	height: 100px
   	 }
   	 footer {
     	background-color: #555;
      	color: blue;
     	 padding: 15px;
    }
    /* Remove the navbar's default margin-bottom and rounded borders */ 
    .navbar {
      margin-bottom: 0;
      border-radius: 0;
    }
   	 
    </style>
</head>

<body>

<nav class="navbar navbar-inverse">
  <div class="container-fluid">
    <div class="navbar-header">
      <button type="button" class="navbar-toggle" data-toggle="collapse" data-target="#myNavbar">
        <span class="icon-bar"></span>
        <span class="icon-bar"></span>
        <span class="icon-bar"></span>                        
      </button>
      <a class="navbar-brand" href="#">Logo</a>
    </div>
    <div class="collapse navbar-collapse" id="myNavbar">
      <ul class="nav navbar-nav">
        <li><form action="GetRequests" method="get" id = "viewMyRequests">
			<input type="submit" value="View My Requests" /></form></li>
        <li><form action="MakeRequest" method="get" id = "makeRequest">
			<input type="submit" value="Request Reimbursment" /></form></li>
      </ul>
        <form class="navbar-form navbar-right" action="Logout" method="get">
			<input class = "glyphicon glyphicon-log-out" type="submit" value="Logout" />
		</form>
		<ul class="nav navbar-nav navbar-right" id="viewMyInformation">
        <li><a href="UserProfile?param=value"><span class="glyphicon glyphicon-user"></span>My Account</a></li>
      </ul>
    </div>
  </div>
</nav>

	<Table class = "outer">
		<TR>
		
		</TR>
		<TR>
			
		</TR>
		<tr>
			<td>Employees</td>
		</tr>
		<TR>
		<TD>
			<TABLE id = "emps" class = "inner">
				<!-- table elements will be inserted with AJAX -->
			</TABLE>
		</TD>
		</TR>
		<tr>
			<td>Reimbursement Requests</td>
		</tr>
		<TR>
			<TD>
			<TABLE id = "requ" class = "inner">
			<tr>
				<TD>
		 			Inner table
				</TD>
			<tr>
			</TABLE>
		</TR>
	</Table>

<div>
<form class = "getRequests" action="GetRequests" method="get">
	<input class = "lbl" type="submit" value="See Requests" />
</form>

<form class = "createEmp" action="CreateEmp" method="get">
	<input class = "lbl" type="submit" value="Create Employee" />
</form>

</div>

<!-- dropdown menu 
<div class="notification">Notification</div>
<div class="drpdwn"></div>-->

<p>Welcome ${userName}</p>
<p>You are a ${userRole}</p>
</body>
<script>
$(document).ready(
	//handle notifications
	
	function(){
		var userRole = "<%= userRole %>";
		//see if user is an employee to restrict functionality to that of employees
		if (userRole === "Employee"){
			$(".changePassword").hide();
			$(".createEmp").hide();
			$("#emps").hide();
			$(".getRequests").hide();
		}
		//restrict or enable functionality for managers
		else if (userRole === "manager"){
			$("#viewMyInformation").hide();
			$("#viewMyRequests").hide();
			$("#makeRequest").hide();
		}
		
		//call user update ajax
		$.post("ViewEmps", {

		},
		function(data, status){
			alert("Data: "+data+"\nStatus: "+status);
			//parse this
			var parser = "";
			var strArr =[];
			var index = 0;
			
			for (var i = 0; i < data.length; i++){
				if (data[i] == "U" && data[i+1] == "s" && data[i+2] == "e" && data[i+3] == "r"){
					//ignore
					i += 3;
				}
				else if (data[i] == "[" || data[i] == "]"){
					
						strArr[index] = "<tr>"+parser+"</tr>"; 
						parser = "";
						
						//alert(strArr[index]);
						index++;
				
				}
				else{
					parser += "<td>"+data[i]+"</td>";
				}
			}
			$("#emps").html(strArr);
			
		});
	}	
);
</script>

</html>