<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<link rel="import"
	href="url(http://fonts.googleapis.com/css?family=Libre+Baskerville|Roboto:300,100);">

<title>AwesomeBank</title>
</head>
<style>
body {
	background-color: #ccc;
	font-family: 'Roboto';
	font-weight: 100;
	line-height: 1.2em;
	margin: 50px auto;
	color: #ccc;
}
h1 {
	font-size: 90px;
	opacity: .5;
	position: relative;
	left: -20px;
	top: -50px;
	float: top;
}
.container {
	width: 425px;
	height: 350px;
	background-color: #333;
	margin: 30px auto;
	padding: 30px;
	border: 1px solid #999;
	box-shadow: 0 0 10px #333;
}
ul {
	margin: 0;
	padding: 0;
	list-style: none;
	font-size: 24px;
	color: #fff;
	position: relative;
	bottom: 70px;
}
input {
	padding: 4px;
	margin: 8px 0 15px;
	font-family: 'Roboto';
}
input:focus {
	border: none;
	background-color: #666;
	outline: none;
	padding: 6px;
	color: #fff;
	font-family: 'Roboto';
}
button {
	border-radius: 7px;
	background-color: #999;
	border: none;
	padding: 6px 15px;
	color: #fff;
	margin: 0;
	font-family: 'Roboto';
}
button:hover {
	background-color: #666;
	border: none;
	padding: 6px 15px;
	color: #fff;
	margin: 0;
	font-family: 'Roboto';
}
</style>

<body>
	<form action="login" method="post">
		<div class="container">
			<h1>AWESOME</h1>
			<h1>BANK</h1>
			<ul>
				<li><c:if test="${not empty authFailed}">
						<font color="red"> <c:out value="${authFailed}" />
						</font>
					</c:if></li>
				<li><label>Username</label></li>
				<li><input type="text" name="userid"></li>
				<li><label>Password</label></li>
				<li><input type="password" name="pass">
					<button type="submit">Sign In</button></li>
			</ul>
		</div>
	</form>

</body>
</html>