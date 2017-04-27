<%@include file="header.jsp"%>

<h1>Register New Employee</h1>

<form method="post" action="Register">
	<p>
		User Name: <input type="text" name="username" />
	</p>
	<p>
		Password: <input type="text" name="password" />
	</p>
	<p>
		First Name: <input type="text" name="firstname" />
	</p>
	<p>
		Last Name: <input type="text" name="lastname" />
	</p>
	<p>
		Email: <input type="text" name="email" />
	</p>
	<input type="submit" value="Register" />
</form>

<%@include file="footer.jsp" %>