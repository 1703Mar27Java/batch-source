<%@include file="header.jsp"%>

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
		</tr>
	</c:forEach>
</table>

<%@include file="footer.jsp"%>