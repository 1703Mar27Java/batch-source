<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@ page import="com.revature.dao.*"%>
<%@ page import="com.revature.domain.*"%>

<%@ page import="java.io.*,java.util.*,java.sql.*"%>
<%@ page import="javax.servlet.http.*,javax.servlet.*"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql"%>


<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<link rel="stylesheet" href="Style.css">
<head>
<title>Home Page</title>
</head>
<body>
	<sql:setDataSource var="source" driver="oracle.jdbc.OracleDriver"
		url="jdbc:oracle:thin:@ebdb.cti5brw1nrxx.us-east-2.rds.amazonaws.com:1521:ORCL"
		user="Eeric5" password="motter1281" />
	<table id="reimbursement">
		<tr>
			<th>Reimbursement Id</th>
			<th>Amount</th>
			<th>Description</th>
			<th>Receipt</th>
			<th>Submitted</th>
			<th>Resolved</th>
			<th>Author</th>
			<th>Resolver</th>
			<th>Type</th>
			<th>Status</th>
		</tr>
		<sql:query dataSource="${source}" var="result">
      		SELECT * FROM ERS_REIMBURSEMENTS
			</sql:query>
		<c:forEach var="row" items="${result.rows}">

			<tr>
				<td><c:out value="${row.R_ID}" /></td>
				<td><c:out value="${row.R_AMOUNT}" /></td>
				<td><c:out value="${row.R_DESCRIPTION}" /></td>
				<td><c:out value="${row.R_RECEIPT}" /></td>
				<td><c:out value="${row.R_SUBMITTED}" /></td>
				<td><c:out value="${row.R_RESOLVED}" /></td>
				<td><c:out value="${row.U_ID_AUTHOR}" /></td>
				<td><c:out value="${row.U_ID_RESOLVER}" /></td>
				<c:set var="Type" scope="session" value="${row.RT_TYPE}" />
				<c:if test="${Type ==  1}">
					<td><c:out value="Rent"></c:out></td>
				</c:if>
				<c:if test="${Type ==  2}">
					<td><c:out value="Gas"></c:out></td>
				</c:if>
				<c:if test="${Type ==  3}">
					<td><c:out value="Books"></c:out></td>
				</c:if>
				<c:if test="${Type ==  4}">
					<td><c:out value="Tech"></c:out></td>
				</c:if>
				<c:if test="${Type ==  5}">
					<td><c:out value="Food"></c:out></td>
				</c:if>
				<c:if test="${Type ==  6}">
					<td><c:out value="Travel"></c:out></td>
				</c:if>

				<c:set var="Status" scope="session" value="${row.RS_STATUS}" />
				<c:if test="${Status ==  1}">
					<td><c:out value="Pending"></c:out></td>
				</c:if>
				<c:if test="${Status ==  2}">
					<td><c:out value="Approved"></c:out></td>
				</c:if>
				<c:if test="${Status ==  3}">
					<td><c:out value="Declined"></c:out></td>
				</c:if>
				<c:if test="${Status ==  4}">
					<td><c:out value="New"></c:out></td>
				</c:if>
			</tr>
		</c:forEach>

		<form method="post" action="ApproveServlet">
			<tr>
				<td><input name="RID"></td>
				<td><input id="Approve" class="button" type="submit"
					value="Approve"></input></td>
		
		</form>
		<form method="post" action="DeclineServlet">
		
			<td><input name="RID"></td>
			<td><input id="Decline" class="button" type="submit"
				value="Decline"></input></td>
		</tr>
		</form>
	</table>
</body>
</html>