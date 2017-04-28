<%@include file="header.jsp"%>

<c:if test="${currentUser.getUR_ID() == 1}">
	<c:if test="${filtered != null}">
		<%@include file="mrview.jsp"%>
	</c:if>
	<div id="shortform">
		<form method="post" action="MRView">
			<select name="option">
				<option value="1">Pending</option>
				<option value="2">Approved</option>
				<option value="3">Denied</option>
			</select> <input type="submit" value="Display" />
		</form>
	</div>

</c:if>


<c:if test="${currentUser.getUR_ID() == 2}">
	<c:if test="${filtered != null}">
		<%@include file="erview.jsp"%>
	</c:if>
	<div id="shortform">
		<form method="post" action="ERView">
			<select name="option">
				<option value="1">Pending</option>
				<option value="2">Approved</option>
				<option value="3">Denied</option>
			</select> <input type="submit" value="Display" />
		</form>
	</div>

</c:if>

<%@include file="footer.jsp"%>