<table>
	<tr>
		<th>Amount</th>
		<th>Description</th>
		<th>Submitted</th>
		<th>Author</th>
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
			<td><c:out value="${row.getU_ID_AUTHOR()}" /></td>
			<td><c:out value="${row.formatResolved()}" /></td>
			<td><c:out value="${row.getU_ID_RESOLVER()}" /></td>
			<td><c:out value="${row.getRT_TYPE()}" /></td>
			<td><c:out value="${row.getRT_TYPE()}" /></td>
			<form method="post" action="Resolve">
				<td><select name="status">
						<option value="2">Approve</option>
						<option value="3">Deny</option>
				</select>
				<input type="hidden" name="crid" value="${row.getR_ID()}" /></td>
				<td><input type="submit" value="Resolve" /></td>
			</form>
		</tr>
	</c:forEach>
</table>