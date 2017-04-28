<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="f" uri="http://java.sun.com/jstl/fmt"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Home Page</title>


<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css"
	integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u"
	crossorigin="anonymous">

<style>
html, body {
	height: 100%;
}

.point {
	font-size: 20px;
}

.skull {
	font-size: 20px;
	margin-left: auto;
}

.center-column {
	text-align: center;
}

.id-column {
	width: 100px;
}

.company-banner {
	font-size: 70px;
	text-align: center;
	padding: 50px;
	margin-left: auto;
	margin-right: auto;
}

footer {
	position: absolute;
	right: 0;
	bottom: 0;
	left: 0;
	padding: 1rem;
	background-color: #9da6b5;
	text-align: center;
	color: white;
}

.nav {
	background-color: orange;
	padding: 5px;
	font-weight: bold;
	color: black;
	length: 100%;
}

.add {
	padding-left: 5px;
}

.danger {
	width: 157px;
}

.logout {
	display: inline-block;
	float: right;
	padding-right: 5px;
}

select {
	color: lightorange;
}

option {
	color: black;
}

h4 {
	font-weight: bold;
	padding-left: 5px;
	width: 700px;
}

.filter {
	float: left;
}

input {
	color: #9da6b5;
}

span {
	font-size: 15px;
}

.button {
	display: inline-block;
	padding: 15px 25px;
	font-size: 12px;
	cursor: pointer;
	text-align: center;
	text-decoration: none;
	outline: none;
	color: black;
	background-color: orange;
	border: none;
	border-radius: 15px;
	box-shadow: 0 9px #999;
}

.button:hover {
	background-color: silver
}

.button:active {
	background-color:;
	box-shadow: 0 5px #666;
	transform: translateY(4px);
}

tr:nth-child(even) {
	background-color: #fff0b3
}

th, td {
	border-bottom: 1px solid #ddd;
}
</style>

</head>
<body>

	<div class="nav">
		<h4>
			Welcome back
			<c:out value="${firstName}" />
			!
		</h4>

		<div class="logout">
			<form action="logout.do" method="post">
				<input class="button" type="submit" value="Logout" />
			</form>
		</div>
	</div>

	<div class="company-banner">Employee Reimbursement System</div>