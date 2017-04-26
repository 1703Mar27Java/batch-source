<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.0/jquery.min.js"></script>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.0/jquery.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>

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
    
    .outer{
		border: 3px solid red;
		left: 15%;
		height: 100%;
		width: 70%;
		position: relative;
		text-align:center;
	}	
   	 
    </style>

<title>User Profile</title>
<!-- user -->
	<%String userName = (String)session.getAttribute("userName"); %>
	<%String userRole = (String)session.getAttribute("userRole"); %>
	<%String firstName = (String)session.getAttribute("firstName"); %>
	<%String lastName = (String)session.getAttribute("lastName"); %>
	<%String emailAddress = (String)session.getAttribute("email"); %>
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
       <ul class="nav navbar-nav">
        <li><a href="dashboard.jsp">Back</a></li>
      </ul>
    </div>
    <div class="collapse navbar-collapse" id="myNavbar">
        <form class="navbar-form navbar-right" action="Logout" method="get">
			<input class = "glyphicon glyphicon-log-out" type="submit" value="Logout" />
		</form>
    </div>
  </div>
</nav>
	
	<table class = "outer">
		<tr>
			<td><p>${userRole}</p></td>
		</tr>
		<tr>
			<td><h3>Username</h3></td>
			<td><p class="printed" id = "unP">${userName}</p><input id = "un" class="form-control" type="text" value=${userName}></td>
		</tr>
		<tr>
			<td><h3>First Name</h3></td>
			<td><span><p class="printed" id = "fN">${firstName}</p><input id = "fName" class="form-control" type="text" value=${firstName}></span></td>
		</tr>
		<tr>
			<td><h3>Last Name</h3></td>
			<td><span><p class="printed" id = "lN">${lastName}</p><input id = "lName" class="form-control" type="text"  value=${lastName}></span></td>
		</tr>
		<tr>
			<td><h3>Email Address</h3></td>
			<td><span><p class="printed" id = "em">${emailAddress}</p><input id = "email" class="form-control" type="text"  value=${emailAddress}></span></td>
		</tr>
		<tr>
			<td>
				<button id = "edit">Edit</button>
				<button id = "submit">Submit</button>
			</td>
		<tr>
	</table>
</body>
<script>
	$(document).ready(function(){
		$(".form-control").hide();
		$("#submit").hide();
		$("#edit").click(function(){
			$(".form-control").show();
			$("#submit").show();
			$("#edit").hide();
			$(".printed").hide();
			
			$("#un").val($("#unP").html());
			$("#fName").val($("#fN").html());
			$("#lName").val($("#lN").html());
			$("#email").val($("#em").html());
		});
		
		$("#submit").click(function(){
			//call user update ajax
			$.post("UserProfile", {
				Username: $("#un").val(),
				Fname: $("#fName").val(),
				Lname: $("#lName").val(),
				Email: $("#email").val()
			},
			function(data, status){
				//alert("Data: "+data+"\nStatus: "+status);
				//parse this
				var parser = "";
				var strArr =[];
				var index = 0;
				for (var m = 0; m < data.length; m++){
					if (data[m] == "{" || data[m] == "}" || data[m] == ","){
						strArr[index] = parser; 
						parser = "";
						
						//alert(strArr[index]);
						index++;
					}
					else{
						parser += data[m];
					}
				} 
				
				$("#unP").html(strArr[1]);
				$("#fN").html(strArr[2]);
				$("#lN").html(strArr[3]);
				$("#em").html(strArr[4]);
				alert(strArr[4]);
			});

			$(".form-control").hide();
			$("#submit").hide();
			$("#edit").show();
			$(".printed").show();
		});
	});
</script>
</html>