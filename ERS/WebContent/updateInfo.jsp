<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page import="com.revature.bean.User"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<%
	//Check if user is logged in
	if (session.getAttribute("uName") == null || session.getAttribute("uName").equals("")) {
		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/index.jsp");
		dispatcher.forward(request, response);
	}
%>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Revature ERS</title>

<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<!-- Revature favicon -->
<link href="img/favicon.ico" rel="icon" type="image/x-icon">
<link type="text/css" media="all" href="css/rev.css" rel="stylesheet">


<style>
body {
	background-image: url('img/black-bg.png');
	position: relative;
	height: 150%;
	width: 100%;
	background-repeat: no-repeat;
	background-attachment: fixed;
	background-size: 100% 100%;
	height: 150%;
}

.btn {
	float: right;
}
</style>
</head>
<!-- bootstrap cdn's -->
<link
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u"
	crossorigin="anonymous">
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"
	integrity="sha384-Tc5IQib027qvyjSMfHjOMaLkfuWVxZxUPnCJA7l2mCWNIpG9mGCD8wGNIcPD7Txa"
	crossorigin="anonymous">
	
</script>


<body>

	<!-- Revature logo at top of page-->
	<!-- Menu section -->
	<div class="wwd-bg">


		<ul class="nav nav-pills" role="tablist"
			style="float: right; overflow: auto;">
			<li role="presentation"><a href="employee.jsp">Requests</a></li>
			<li role="presentation" class="active"><a href="#">Your Info</a></li>
			<li role="presentation"><a href="logout.jsp">Logout</a></li>
		</ul>
		<a href="https://revature.com"> <img src="img/logo.png"
			style="float: left;" alt="Revature">
		</a> <br> <br> <br> <br>
		<h4 style="text-align: left;">
			Employee Reimbursement System. Welcome
			<%=session.getAttribute("uName")%>.
		</h4>


	</div>

	<br>
	<br>

	<!-- Content section -->
	<div class="Testimon-bgcolor">

		<div class="container" style="visibility:hidden;">
			<div class="alert alert-danger">
				<strong id="error">Whoops!</strong>
		
			</div>
		</div>

		<%
			User u = (User) session.getAttribute("uBean");
		%>
		
		<!-- Section for updating user info -->
		<table class="table table-inverse" style="width: 50%;">
			<tbody style="font-size: 20px !important;">
				<tr class="bg-primary">
					<th>Email</th>
					<th>First Name</th>
					<th>Last Name</th>
				</tr>
				<tr class="bg-success">
					<td align="left"><%=u.getEmail()%></td>
					<td align="left"><%=u.getFirstName()%></td>
					<td align="left"><%=u.getLastName()%></td>
				</tr>
				<tr class="bg-success">
					<td align="left"><input type="text" id="txtEmail" value=""
						maxlength="30" size="30"></td>

					<td align="left"><input type="text" id="txtFirst" value=""
						maxlength="10" size="10"></td>
					<td align="left"><input type="text" id="txtLast" value=""
						maxlength="15" size="10"></td>
				</tr>
			</tbody>
		</table>
		<table class="table table-inverse" style="width: 50%;">
			<tbody style="font-size: 20px !important;">
				<tr class="bg-primary">
					<th>Username</th>
					<th>Title</th>
					<th></th>
				</tr>
				<tr class="bg-success">
					<td id="txtUser" align="left"><%=u.getUserName()%></td>
					<td align="left"><%=u.getTitle()%></td>
					<td><button id="submitUser">Update Info</button></td>
				</tr>
			</tbody>
		</table>

		<table class="table table-inverse" style="width: 50%;">
			<tbody style="font-size: 20px !important;">
				<tr class="bg-primary">
					<th>New Password</th>
					<th>Confirm Password</th>
					<th><br></th>
				</tr>
				<tr class="bg-success">
					<td align="left"><input type="password" id="pw1" value=""
						maxlength="10" size="10"></td>
					<td align="left"><input type="password" id="pw2" value=""
						maxlength="15" size="10"></td>
					<td><button id="submitPw">Update Password</button></td>
				</tr>
			</tbody>
		</table>
	</div>



</body>
<script>
	$("#submitUser").click(function() {
		updateInfo();
	});
	function updateInfo() {
		$.post("updateInfo", {
			"user" :  $('#txtUser').text(),
			"email" : $('#txtEmail').val(),
			"fName" : $('#txtFirst').val(),
			"lName" : $('#txtLast').val()
		}, function(result) {
			console.log(result);
			if (result=="true") {
				console.log("success");
				location.reload();
			}
			else{
				console.log("failure");
				$(".container").css("visibility","visible");
				$('#error').text("Error with the update");
			}
		});
	};
	$("#submitPw").click(function() {
		updatePw();
	});
	function updatePw() {
		$.post("updatePw", {
			"user" : $('#txtUser').text(),
			"pw1" :  $('#pw1').val(),
			"pw2" :  $('#pw2').val()
		}, function(result) {
			console.log(result);
			if (result=="true") {
				console.log("success");
				location.reload();
			}
			else{
				console.log("failure");
				$(".container").css("visibility","visible");
				$('#error').text("Error with the update");
			}
		});
	};
</script>
</html>