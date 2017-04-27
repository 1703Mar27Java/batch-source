<%@ include file="includes/head.html"%>
<%@ page import="com.revature.util.*,
com.revature.domain.*"%>
<body>
	<%@ include file="includes/navbar.html"%>

	<script type="text/javascript" src="scripts/user.js"></script>
<body>

	<div class="container">
		<div class="row">
			<div class="col-xs-12 col-sm-6 col-md-6">
				<div class="well well-sm" id="namebox">

					<h4>
						<%=user.getUsername()%></h4>
					<br/> <i class="glyphicon glyphicon-user"></i><span id="nbfirst"><%=user.getFirstName()%></span> &nbsp;<span
						id="nblast"><%=user.getLastName()%></span> <br /> <i
						class="glyphicon glyphicon-briefcase"></i><span><%=user.getRole()%></span>
					<br /> <i class="glyphicon glyphicon-envelope"></i><span
						id="nbemail"><%=user.getEmail()%></span><br><br>
					<input type="submit" value="Edit Information" style=" margin-top:-15px;"
						class="btn btn-primary" id="edit">
						<input type="submit" value="Change Password" style=" margin-top:-15px;"
						class="btn btn-primary" id="chgpass">
						&nbsp;&nbsp;<p style="display: inline; color: #f73636;" id="err"></p>
						
				</div>
			</div>
		</div>
	</div>

	<div class="container" id="change">
		<div class="row">
			<div class="col-xs-12 col-sm-6 col-md-6">
				<div class="well well-sm" id="formbox">


					<label for="example-text-input" class="col-1 col-form-label">First
						Name</label> <input class="form-control" type="text"
						value="<%=user.getFirstName()%>" id="firstName"><br>


					<label for="example-search-input" class="col-1 col-form-label">Last
						Name</label> <input class="form-control" type="search"
						value="<%=user.getLastName()%>" id="lastName"><br> <label
						for="example-email-input" class="col-1 col-form-label">Email</label>

					<input class="form-control" type="email"
						value="<%=user.getEmail()%>" id="email"><br> <input
						type="submit" value="Submit" style="float: right;" id="done"
						; class="btn btn-primary">

				</div>
			</div>
		</div>
	</div>
	
	<div class="container" id="pass">
		<div class="row">
			<div class="col-xs-12 col-sm-6 col-md-6">
				<div class="well well-sm" style="height: 220px;">


					<label for="example-text-input" class="col-1 col-form-label">New Password</label> <input class="form-control" type="password"
						value="" id="p1"><br>

					<label for="example-search-input" class="col-1 col-form-label">Confirm Password</label> <input class="form-control" type="password"
						value="" id="p2"><br> 
						<p style="display: inline; color: #f73636;" id="errpass"></p>
						<input
						type="submit" value="Submit" style="float: right;" id="donepass"
						; class="btn btn-primary">
						

				</div>
			</div>
		</div>
	</div>



</body>
</html>