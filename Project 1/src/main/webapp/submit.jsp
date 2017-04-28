<%@include file="header.jsp"%>


<div id="shortform">
	<h3>Submit Reimbursement Request</h3>
	<form method="post" action="Submit">
		<p>
			Amount<input type="text" name="amount" />
		</p>
		<p>
			Description<input type="text" name="description" />
		</p>
		Type<br/><select name="type">
			<option value="1">Tools</option>
			<option value="2">Training</option>
			<option value="3">Travel</option>
		</select> <input type="submit" value="Submit" />
	</form>
</div>

<%@include file="footer.jsp"%>