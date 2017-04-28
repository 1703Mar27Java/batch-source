<%@ include file="/includes/header.jsp"%>

<style>
body {
	background-color: white;
	-webkit-font-smoothing: antialiased;
	font: normal 14px Roboto, arial, sans-serif;
}
h4 {
	padding-bottom: 30px;
	font-size: 40px;
}
#center-login {
	position: absolute;
	margin: auto;
	top: 0;
	right: 0;
	bottom: 0;
	left: 0;
	width: 400px;
	height: 400px;
}
.login-form {
	width: 400px;
	background-color: #ffffff;
	padding-top: 50px;
	padding-bottom: 80px;
	padding-left: 80px;
	padding-right: 80px;
	border-color: #d2d2d2;
	border-width: 5px;
	box-shadow: 0 2px 0 #cfcfcf;
}
footer {
	position: absolute;
	right: 0;
	bottom: 0;
	left: 0;
	padding: 1rem;
	background-color: #9da6b5;
	text-align: center;
	color: white;
}
}
</style>
</head>
<body>


	<form action="login.do" method="post">
		<div id="center-login">
			<div class="login-form">
				<img src="http://www.speakerboxpr.com/wp-content/uploads/2016/10/Revature_CMYK.jpg" height="128" width ="256" />
				<br></br>
				<input type="text" name="username" id="userName"
					class="input-sm form-control" placeholder="USERNAME" /><br /> <input
					type="password" name="password" id="userPassword"
					class="input-sm form-control" placeholder="PASSWORD" /><br />
				<div>
					<span class="group-btn"> <input class="btn" type="submit"
						value="Login" />

					</span>
				</div>
			</div>
		</div>
	</form>