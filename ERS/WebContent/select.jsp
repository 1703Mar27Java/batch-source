<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Caves</title>

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
	%>

	<!-- This is obviously insecure, should put this in a separate file or something -->
	<sql:setDataSource var="source" driver="oracle.jdbc.OracleDriver"
		url="jdbc:oracle:thin:@testdb.ccr7b4olo7hr.us-west-2.rds.amazonaws.com:1521:ORCL" user="master"
		password="p4ssw0rd" />
	<sql:query dataSource="${source}" var="result">
	SELECT * FROM VW_ERS_REIMBURSEMENTS WHERE USERNAME='<%=session.getAttribute("uName")  %>'<%=q %>
	</sql:query>
	
	
	<table class="table table-inverse">
		<tbody style="font-size: 20px !important;">
		<tr class="bg-primary">
			<th>ID</th>
			<th>Description</th>
			<th>Receipt</th>
			<th>Time Submitted</th>
			<th>Time Resolved</th>
			<th>Amount</th>
			<th>Type</th>
			<th>Status</th>
			<!-- <th>Username</th> -->
			<!-- <th>First Name</th> -->
			<!-- <th>Last Name</th> -->
		</tr>
	
	
	<!-- now we're using jstl core... -->
	<c:forEach var="row" items="${result.rows}">
		<tr class="bg-success" >
			<td align="left"><c:out value="${row.R_ID}"/></td>
			<td align="left"><c:out value="${row.DESCRIPTION}"/></td>
			<td align="left"><img style="height: 200px; width: 200px;" id="getImgSrc" src="<c:out value="${row.RECEIPT}"/>" alt="No Image" /></td>
			<td align="left"><c:out value="${row.TIME_SUBMITTED}"/></td>
			<td align="left"><c:out value="${row.TIME_RESOLVED}"/></td>
			<td align="left"><c:out value="${row.AMOUNT}"/></td>
			<td align="left"><c:out value="${row.R_TYPE}"/></td>
			<td align="left"><c:out value="${row.R_STATUS}"/></td>
			<!-- <td align="left"><c:out value="${row.USERNAME}"/></td> -->
			<!-- <td align="left"><c:out value="${row.FIRST_NAME}"/></td> -->
			<!-- <td align="left"><c:out value="${row.LAST_NAME}"/></td> -->
		</tr>
	</c:forEach>
	
	</table>
	

	
	
	


</body>

</html>