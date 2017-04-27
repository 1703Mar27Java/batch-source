<%@include file="header.jsp"%>

<%
	if (currentUser != null) {
%>
<jsp:forward page="/main.jsp" />
<%
	}
%>

<h1>Please Login</h1>

<form method="post" action="Login">
	<p>
		User Name: <input type="text" name="username" />
	</p>
	<p>
		Password: <input type="password" name="password" />
	</p>
	<input type="submit" value="Login" />
</form>

<%@include file="footer.jsp" %>