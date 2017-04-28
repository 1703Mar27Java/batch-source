<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Create Account</title>
<link rel="stylesheet" href="radar.css">
</head>
<body>
	<img src="images/revradar.png"></img>
	<div class="orange-box">
		<h2 style="text-align:center;">Edit Account</h2>
		<form action="edituser" method="post">
			<input type="text" placeholder="Enter new username" name="uname"><br>
			<input type="password" placeholder="Enter new password" name="password"><br>
			<input type="text" placeholder="Enter new firstname" name="fname"><br>
			<input type="text" placeholder="Enter new lastname" name="lname"><br>
			<input type="email" placeholder="Enter your email" name="email"><br>
			<input type="submit" class="button" value="Update"/>
		</form>
		<form action="viewuser" style="margin-top:115px; margin-left:80px;">
			<input type="submit" class="button" value="nevermind">
		</form> 
	</div>
</body>
</html>