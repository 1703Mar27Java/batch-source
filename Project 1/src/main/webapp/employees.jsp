<%@include file="header.jsp"%>

<h3>All Employees</h1>

<table>
	<tr>
		<th>User Name</th>
		<th>First Name</th>
		<th>Last Name</th>
		<th>Email</th>
	</tr>

	<c:forEach var="row" items="${allEmployees}">
		<tr>
			<td><c:out value="${row.getU_USERNAME()}"/></td>
			<td><c:out value="${row.getU_FIRSTNAME()}"/></td>
			<td><c:out value="${row.getU_LASTNAME()}"/></td>
			<td><c:out value="${row.getU_EMAIL()}"/></td>
			<form method="post" action="EmployeePending">
				<td><input type="hidden" name="uid" value="${row.getU_ID()}" />
				<input type="submit" value="Pending" /></td>
			</form>
		</tr>
	</c:forEach>
</table>

<%@include file="footer.jsp"%>