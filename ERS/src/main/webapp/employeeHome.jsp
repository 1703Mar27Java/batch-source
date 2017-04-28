<%@ include file="/includes/header.jsp"%>

<div class="add">
	<form action="addReimbursement.do" method="post">
		<span>Add a new Reimbursement<span class="point">
				</span></span> Type: <select name="type">
			<option value="0">Select</option>
			<option value="1">Lodging</option>
			<option value="2">Travel</option>
			<option value="3">Food</option>
			<option value="4">Other</option>
		</select> Amount: <input type="text" name="amount" /> Description: <input
			type="text" name="description" /> <input
			class="btn btn-sm btn-default" type="submit" value="Add" />
	</form>
</div>
<table id="keywords" class="table table-hover">
	<thead>
		<tr class="info">
			<th class="center-column"><span class="skull"> </span></th>
			<th class="id-column">Request ID</th>
			<th>Amount</th>
			<th>Type</th>
			<th >Description</th>
			<th>Time Submitted</th>
			<th>Time Resolved</th>
			<!-- <th>Receipt</th> -->
			<th>Resolver</th>
			<th>Status</th>
			<th></th>
		</tr>
	</thead>
	<tbody>
		<c:forEach var="reimb" items="${userReimb}">
			<c:set var="timeSub" value="${reimb.getSubmitted()}" />
			<c:set var="timeRes" value="${reimb.getResolved()}" />
			<c:set var="money" value="${reimb.getrAmount()}" />
			<tr>
				<td class="center-column"><span class="skull"> </span></td>
				<td><c:out value="${reimb.getrId()}" /></td>
				<td><c:out value="${reimb.getrAmount()}" /></td>
				<td><c:out value="${reimb.getrType().getType()}" /></td>
				<td><c:out value="${reimb.getrDescription()}" /></td>
				<td><c:out value="${reimb.getSubmitted()}" /></td>
				<td><c:out value="${reimb.getResolved()}" /></td>
				<!-- <td></td> -->
				<td><c:out value="${reimb.getrResolver().getFullName()}" /></td>
				<td><c:out value="${reimb.getrStatus().getStatus()}" /></td>
			</tr>
		</c:forEach>

	</tbody>
</table>

</body>
</html>