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
	<%Integer userId = (Integer)session.getAttribute("id"); %>
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
        <li><form action="GetPersonalRequests" method="post" id = "viewMyRequests">
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

	<table class = "outer" id = "empsAndReqs">
		<TR>
			
		</TR>
		<tr>
			<td colspan = "3">Employees</td>
		</tr>
		<tr>
		<td>
  			<input class="form-control" id = "nameInp" type="text" name="un" placeholder="Username" style="float:right;">
		</td>
		<td>
			<input class="form-control" id = "emailInp" type="text" name="email" placeholder="Email address" style="float:right;"> 
		</td>
		<td>
			<input class="form-control" id = "passwordInp" type="text" name="pw" placeholder="Password" style="float:right;">
		</td>
		<td>
			<button class = "createEmp">Create Employee</button>
			<button class = "submit">Submit</button>
		</td>
		<td>
			<button class = "cancel">Cancel</button>
		</td>
		</tr>
		<tr>
			<td colspan = "3">
				<table id = "emps" class = "inner" style="height: 200px; max-height: 200px; overflow-y: scroll;">
				<!-- table elements will be inserted with AJAX -->
				<tr>
					 <th>Name</th>
  					 <th>Email</th>
  					 <th>ID</th>
  				</tr>
  				<tr>
  					<td>
  					<form method="POST" action="profile.jsp" class = "passSelected">
						<input type = "hidden" name = "redirect" value ="profile.jsp">
					</form>
					</td>
				</tr>
  				<tr>
					<td>
					
					</td>
				</tr>
			</table>
				
			</td>
		</tr>
		<tr>
			<td colspan = "3">Reimbursement Requests</td>
		</tr>
		<tr>
			<td colspan="3">
			<table id = "requ" class = "inner" style="height: 100px; overflow-y: scroll;">
				
			</table>
			</td>
		</tr>
	</table>

<div>
<!--  <form class = "getRequests" action="GetRequests" method="get">
	<input class = "lbl" type="submit" value="See Requests" />
</form>-->

</div>

<!-- dropdown menu 
<div class="notification">Notification</div>
<div class="drpdwn"></div>-->

<p>Welcome ${userName}</p>
<p id = "whatAreYa"></p>
</body>
<script>
$(document).ready(
	//handle notifications
	
	function(){
		
		var userRole = "<%= userRole %>";
		$("#whatAreYa").html(userRole);
		//see if user is an employee to restrict functionality to that of employees
		if (userRole === "Employee"){
			$("#whatAreYa").html("You are an Employee");
			$(".changePassword").hide();
			$(".createEmp").hide();
			$("#emps").hide();
			$(".getRequests").hide();
			$("#empsAndReqs").hide();
			
		}
		//restrict or enable functionality for managers
		else if (userRole === "manager"){
			$("#whatAreYa").html("You are a Manager");
			$("#viewMyInformation").hide();
			$("#viewMyRequests").hide();
			$("#makeRequest").hide();
			
			$("#nameInp").hide();
			$("#emailInp").hide();
			$("#passwordInp").hide();
			$(".submit").hide();
			$(".cancel").hide();
		
			//call user update ajax
			$.post("ViewEmps", {

			},
			function(data, status){
				//parse this
				var parser = "";
				var parserTD = "";
				var strArr =[];
				var index = 0;
			
				for (var i = 0; i < data.length; i++){
				
					if (data[i] === ","){
						parser = "<td class="+"format"+">"+parser+"</td>";
						parserTD += parser;
						parser = "";
						index++;
					}
				
					else if (data[i] === "[" || data[i] === "]"){
					
						strArr[index] = "<tr id ="+"userRow"+" class="+"format"+">"+parserTD+"</tr>"; 
						parserTD = "";
						//parser = "";
						
						//alert(strArr[index]);
						index++;
					}	
				
					else{
						parser += data[i];
						parserTD += parser;
					}
				}
			
				$("#emps").html($("#emps").html() + strArr + "</table>");
				/*$(".format").click(function(){
					$(location).attr('href',"profile.jsp");
				});*/
			});
		
			//call request update ajax
			$.get("GetRequests", {
		
			},
			function(data, status){
				//parse this
				var parser = "";
				var parserTD = "";
				var strArr =[];
				var index = 0;
				var status = [];
				var id = "";
				var parseNoTable = "";
				var parseNoTableTD = "";
				var numberOfRows = 0;
			
				for (var i = 0; i < data.length; i++){
				
					if (data[i] === ","){
						parser = "<td class="+"format"+">"+parser+"</td>";
						parserTD += parser;
						//parseNoTableTD += parseNoTable;
						parser = "";
						parseNoTable = "";
						//index++;
					}
				
					else if (data[i] === "[" || data[i] === "]"){
						status[numberOfRows] = parseNoTableTD.substring(0, 2);
						id = parseNoTableTD.substring(18,23);
						
						//strArr[index] = "<form method="+"\'post\'" + "action="+"\'GetRequests\'"+">"+"<input type =" + "\'hidden\'" + "name = " + "\'redirect\'" + "value=" + id +">" + "<tr id ="+"reqRow" +index+" class="+"/'format/'"+">"+parserTD+"</tr></input></form>"; 
						//strArr[index] = "<tr id ="+"reqRow" +index+" class="+"/'format/'"+">"+"<form method="+"\'post\'" + "action="+"\'GetRequests\'"+">"+"<input type =" + "\'hidden\'" + "name = " + "\'redirect\'" + "value=" + id +">"+parserTD+"</input></form></tr>"; 
						//strArr[index] = "<tr id ="+"reqRow" +index+" class="+"/'format/'"+">"+"<form method="+"post" + "action="+"GetRequests"+">"+"<input type =" + "hidden" + "name = " + "redirect" + "value=" + id +">"+parserTD+"</input></form></tr>"; 
						//strArr[index] = "<tr id ="+"reqRow" +index+" class="+"format"+">"+"<form method="post" action="GetRequests"><input type = "hidden" name = "redirect" value=id>"+parserTD+"</form></tr>"; 
						strArr[index] = "<tr id ="+"reqRow" +index+" class="+"format"+">"+parserTD+"</tr>"; 
						parserTD = "";
						//parser = "";
						
						parseNoTableTD = "";
						//alert(id[index] + index);
						index++;
						numberOfRows++;
					}
				
					else{
						parser += data[i];
						parserTD += parser;
						parseNoTable += data[i];
						parseNoTableTD += parseNoTable;
					}
				}
			
				$("#requ").html($("#requ").html() + strArr);
				
				for (var i = 0; i < numberOfRows; i++){
					//alert(i);
					if (status[i].includes("1")){
						$("#reqRow" +i).css("background-color", "green");
					}
					else if (status[i].includes("2")){
						$("#reqRow" +i).css("background-color", "red");
					}
					else if (status[i].includes("3")){
						$("#reqRow" +i).css("background-color", "white");
					}
					$("#reqRow" +i).click(function(){
						//alert($(this).html());
						var n = ($(this).html()).indexOf("rID="); 
						var temp = ($(this).html()).charAt(n+4);
						$.post("GetRequests", {
							id: temp,
						},
						function(data, status){
							alert(status + data);
						});
					});
				}
			});
		}
		
		$(".createEmp").click(function(){
			$("#nameInp").show();
			$("#emailInp").show();
			$("#passwordInp").show();
			$(".submit").show();
			$(".cancel").show();
			$(".createEmp").hide();
			$(".cancel").click(function(){
				$("#nameInp").hide();
				$("#emailInp").hide();
				$("#passwordInp").hide();
				$(".submit").hide();
				$(".cancel").hide();
				$(".createEmp").show();
			})
			$(".submit").click(function(){
				//make user AJAX call
				$.post("CreateEmp", {
					empName: $("#nameInp").val(),
					email: $("#emailInp").val(),
					empPW: $("#passwordInp").val()
				},
				function(data, status){
					alert("Data: "+data+"\nStatus: "+status);
				});
				
				$("#nameInp").hide();
				$("#emailInp").hide();
				$("#passwordInp").hide();
				$(".submit").hide();
				$(".cancel").hide();
				$(".createEmp").show();
				
				//finally, refresh page
				location.reload();
			})
		});
});



</script>

</html>