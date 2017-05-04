<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Enter your information:</title>
</head>
<body>
	<h2>Person</h2>
	<form:form method="POST" action="addInfo" commandName="person">
		<table>
			<tr>
				<td><form:label path="firstName">First Name:</form:label></td>
				<td><form:input path="firstName" /></td>
				<td><form:errors path="firstName"/></td>
			</tr>
			<tr>
				<td><form:label path="lastName">Last Name:</form:label></td>
				<td><form:input path="lastName" /></td>
				<td><form:errors path="lastName"/></td>
			</tr>
			<tr>
				<td><form:label path="dateOfBirth">Date of Birth:</form:label></td>
				<td><form:input path="dateOfBirth" type="date"/></td>
				<td><form:errors path="dateOfBirth"/></td>
			</tr>
			<tr>
				<td colspan="2"><input type="submit" value="Submit" /></td>
			</tr>
		</table>
	</form:form>
	<h4>errors: ${errors}</h4>

</body>
</html>