<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>

<head>

	<meta http-equiv="X-UA-Compatible" content="IE=edge">
	<meta name="viewport" content="width=device-width, initial-scale=1">
	<link rel="shortcut icon" href="favicon.ico" type="image/x-icon">
	<title>Big Bank's Big App</title>

	<link href="css/bootstrap.min.css" rel="stylesheet">
	<link href="css/jumbotron-thin.css" rel="stylesheet">


</head>
<body style="background-color: #d1d2d3">
<%//session.invalidate(); %>
	<div class="container">
		<div class="jumbotron">
			<h1>Big Bank's Big Banking App</h1>
			<p class="lead">Here, you can take care of all your banking
				needs!</p>
			</div>

			<div class="page-header" align="center">
				<h1>Please log in here.</h1>

			</div>
			<br>
			<div align="center">
				<%	
				
				if (request.getAttribute("errorMessage") != null) {
				%>
				<div class="alert alert-danger">
					<strong>Oh no!</strong> Your username/password combination was invalid.
				</div>

				<%
			}
			%>

			<!-- forms for reading in username and password-->
			<form action="login" method="post">
				<div class="row">
					<div class="col-md-3"></div>
					<div class="col-md-2">Username:</div>
					<div class="col-md-4">
						<input type="text" name="uName">
					</div>

				</div>
				<div class="row">
					<div class="col-md-3"></div>
					<div class="col-md-2">Password:</div>
					<div class="col-md-4">
						<input type="password" name="uPass">
					</div>
				</div>
				<div class="row">
					<div class="col-md-4"></div>
					<div class="col-md-2">
						<input name="btn" type="submit" value="Log In"
						class="btn btn-lg btn-primary" />
					</div>
					<div class="col-md-2">
						<input name="btn" type="submit" value="Create"
						class="btn btn-lg btn-info" />
					</div>
				</div>


			</form>

			<br> <img src="cash.jpg" width="500" height="200"> <br>
		</div>
	</div>
</body>
</html>