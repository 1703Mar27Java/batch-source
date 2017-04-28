<%@include file="header.jsp"%>

<div id="shortform">

<h3>Update Profile</h3>
<form method="post" action="Profile">
	<p>
		User Name<input type="text" name="username" value=<c:out value="${currentUser.getU_USERNAME()}"/>>
	</p>
	<p>
		Password: <input type="text" name="password" value=<c:out value="${currentUser.getU_PASSWORD()}"/>>
	</p>
	<p>
		First Name: <input type="text" name="firstname" value=<c:out value="${currentUser.getU_FIRSTNAME()}"/>>
	</p>
	<p>
		Last Name: <input type="text" name="lastname" value=<c:out value="${currentUser.getU_LASTNAME()}"/>>
	</p>
	<p>
		Email: <input type="text" name="email" value=<c:out value="${currentUser.getU_EMAIL()}"/>>
	</p>
	<input type="submit" value="Update" />
</form>
</div>

<%@include file="footer.jsp" %>