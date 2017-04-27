<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
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

	<div class="wwd-bg">


		<ul class="nav nav-pills" role="tablist"
			style="float: right; overflow: auto;">
			<li role="presentation" class="active"><a href="#">Requests</a></li>
			<li role="presentation"><a href="#">Your Info</a></li>
			<li role="presentation"><a href="logout.jsp">Logout</a></li>
		</ul>
		<a href="https://revature.com"> <img src="img/logo.png"
			style="float: left; " alt="Revature">
		</a> <br>
		<br>
		<br>
		<br>
		<h4 style="text-align: left;">Employee Reimbursement System</h4>


	</div>



	<br>
	<br>



	<div class="Testimon-bgcolor">

		<%
			if (request.getAttribute("errorMessage") != null && request.getAttribute("errorMessage") != "") {
		%>
		<div class="container">
			<div class="alert alert-danger">
				<strong>Whoops!</strong>
				<%=request.getAttribute("errorMessage")%>
			</div>
		</div>

		<%
			} else {
		%>
		<br> <br> <br>
		<%
			}
		%>

	</div>

</body>
<script>
	
</script>
</html>