<%@ include file="includes/head.html"%>

<body>

	<nav class="navbar navbar-inverse">
		<div class="container-fluid">
			<div class="navbar-header">
				<span class="navbar-brand"><img src="pics/frozenix.png"
					style="width: 40px; height: 40px; margin-left: -10px; margin-top: -10px;"></span>
				<span class="navbar-brand">Frozenix ERS</span>
			</div>
			<div class="collapse navbar-collapse" id="myNavbar">
				<ul class="nav navbar-nav navbar-right">
				</ul>
			</div>
		</div>
	</nav>




	<div class="container">
		<div class="row">
			<div class="login">
				<div class="login-triangle"></div>

				<h2 class="login-header">Login</h2>

				<form class="login-container" action="app" method="post">
					<input name="location" type="hidden" value="/login">
					<p>
						<input name="username" type="text" placeholder="Username">
					</p>
					<p>
						<input name="password" type="password" placeholder="Password">
					</p>
					<p>
						<input type="submit" value="Log in">
					</p>
					
					<c:if test="${not empty error}">			
						<p style="text-align:center;"><span style="color:red;"><c:out value="${error}" /></span></p>
						<%session.setAttribute("error", null); %>										
					</c:if>
					<c:if test="${not empty logout}">			
						<p style="text-align:center;"><c:out value="${logout}" /></p>
						<%session.setAttribute("logout", null); %>										
					</c:if>
					
				</form>
			</div>
		</div>
	</div>

</body>
</html>