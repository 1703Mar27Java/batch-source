<table>
	<tr>
		<th>Amount</th>
		<th>Description</th>
		<th>Submitted</th>
		<th>Resolved</th>
		<th>Resolver</th>
		<th>Type</th>
		<th>Status</th>
	</tr>

	<c:forEach var="row" items="${filtered}">
		<tr>
			<td><c:out value="$ ${row.getR_AMOUNT()}" /></td>
			<td><c:out value="${row.getR_DESCRIPTION()}" /></td>
			<td><c:out value="${row.formatSubmitted()}" /></td>
			<td><c:out value="${row.formatResolved()}" /></td>
			<td><c:out value="${row.getU_ID_RESOLVER()}" /></td>
			<td><c:out value="${row.getRT_TYPE()}" /></td>
			<td><c:out value="${row.getRT_TYPE()}" /></td>
		</tr>
	</c:forEach>
</table>