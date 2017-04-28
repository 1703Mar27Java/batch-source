<%@include file="header.jsp"%>

<c:if test="${currentUser != null}">

	<jsp:forward page="/main.jsp" />

</c:if>

<div id="shortform">
<h3>Please Login</h3>
	<form method="post" action="Login">
		<p>
			User Name: <input type="text" name="username" />
		</p>
		<p>
			Password: <input type="password" name="password" />
		</p>
		<input type="submit" value="Login" />
	</form>
</div>
<%@include file="footer.jsp"%>