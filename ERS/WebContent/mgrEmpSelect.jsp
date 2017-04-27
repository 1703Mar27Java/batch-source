<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Caves</title>
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
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

</head>
<body id="all">
	<%
		String q;
		if(request.getParameter("q")!=null) 
			q=request.getParameter("q");
		else 
			q="";
		int cnt=0;
	%>

	<!-- This is obviously insecure, should put this in a separate file or something -->
	<sql:setDataSource var="source" driver="oracle.jdbc.OracleDriver"
		url="jdbc:oracle:thin:@testdb.ccr7b4olo7hr.us-west-2.rds.amazonaws.com:1521:ORCL" user="master"
		password="p4ssw0rd" />
	<sql:query dataSource="${source}" var="result">
	SELECT * FROM VW_ERS_USERS WHERE <%=q %>
	</sql:query>
	
	
	<div class="Testimon-bgcolor">




		<c:forEach var="row" items="${result.rows}">
		<!-- Section for updating user info -->
		<table class="table table-inverse" style="width: 50%;">
			<tbody style="font-size: 20px !important;">
				<tr class="bg-primary">
					<th>Email</th>
					<th>First Name</th>
					<th>Last Name</th>
				</tr>
				<tr class="bg-success">
					<td id="txtEmailVal" align="left"><c:out value="${row.EMAIL}"/></td>
					<td align="left"><c:out value="${row.FIRST_NAME}"/></td>
					<td align="left"><c:out value="${row.LAST_NAME}"/></td>
				</tr>
				<tr class="bg-success">
					<td align="left"><input type="text" id="txtEmailIn" value=""
						maxlength="30" size="30"></td>

					<td align="left"><input type="text" id="txtFirstIn" value=""
						maxlength="10" size="10"></td>
					<td align="left"><input type="text" id="txtLastIn" value=""
						maxlength="15" size="10"></td>
				</tr>
			</tbody>
		</table>
		<table class="table table-inverse" style="width: 50%;">
			<tbody style="font-size: 20px !important;">
				<tr class="bg-primary">
					<th>Username</th>
					<th>Title</th>
					
					
				</tr>
				<tr class="bg-success">
					<td id="txtUserVal" align="left"><c:out value="${row.USER_NAME}"/></td>
					<td align="left"><c:out value="${row.JOB_TITLE}"/></td>
					
					
				</tr>
				<tr class="bg-success">
					
					<td align="left"><button id="submitPw"  onclick="btnPress(this.innerHTML)">Reset Password</button></td>
					<td align="left"><button id="submitUser" onclick="btnPress(this.innerHTML)" >Update Other Info</button></td>
				</tr>
			</tbody>
		</table>
		</c:forEach>

	</div>
	
</body>
<script>


</script>
</html>