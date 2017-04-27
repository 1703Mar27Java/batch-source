<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
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

	<section class="wwd-bg"> <a href="https://revature.com"> <img src="img/logo.png"
			style="float: left; " alt="Revature">
		</a> <br>
		<br>
		<br>
		<br>
		<h4 style="text-align: left;">Employee Reimbursement System</h4>
	</section>

<br><br>



	<div>
		<section class="Testimon-bgcolor">
		<%
			if (request.getAttribute("errorMessage") != null && request.getAttribute("errorMessage") != "") {
		%>
		<div class="container">
			<div class="alert alert-danger">
				<strong>Whoops!</strong> <%=request.getAttribute("errorMessage")%>
			</div>
		</div>

		<%
			} else {%> <br><br><br><%}%>
		<form action="login" method="post">
			<div>
				<h2>Username:</h2>
				<input type="text" name="uName">
			</div>


			<div>
				<h2>Password:</h2>
				<input type="password" name="uPass">
			</div>
			<br>
			<div>
				<div>
					<input id="btn" name="btn" type="submit" value="Log In"
						
						class="btn btn-lg btn-primary" />
				</div>
				<div>
					<a href="reset.html">Forgot your password? </a>
				</div>
			</div>


		</form>
	
		</section>
	</div>
	
</body>
<script>
	
</script>
</html>