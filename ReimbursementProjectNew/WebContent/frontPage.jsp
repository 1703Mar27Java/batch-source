<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
	<title>Welcome!</title>
	<script
		src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.0/jquery.min.js">
	</script>
	<link rel="stylesheet" href="Main.css">
	</head>
	
	<body>
	<%String credError = (String)request.getAttribute("foginRailed");%>
	 <input type="hidden" name="credError" value=<%=credError%> />
	 
	<%String roleError = (String)request.getAttribute("userRoleError");%>
	<input type="hidden" name="roleError" value=<%=roleError%> />
	
	 
	
	
	
<div>
	<h1 class = header1>Welcome to the Reimbursvature!	</h1>
</div>

		<div>
    		<div >
     		   <form action="front" method="post" class="form-signin">
	  	          <h3 class = header2>
	  	          Returning Users:
      		      </h3>
				<p id = "loginP">
       		     <input type="text" name="u_name" placeholder="Username" required="" autofocus="" /><br />
       		     <input type="password"  name="u_pass" placeholder="Password" required="" />
       		     <input type="hidden" name="control" value="authenticate" />
       		     
				 <br>
       		     <input type="submit"  name="Submit" value="Login" type="Submit"></button>
       		     </p>
    		    </form>


  			  </div>
		</div>
	</body>

<script type="text/javascript">
$(document).ready(function() {
	var credfail = $('input[name="credError"]').val();
	if(credfail === "true"){
		var text = "Invalid username or password"
		$("#loginP").prepend('<br>').prepend(document.createTextNode(text));
	};
	
	var rolefail = $('input[name="roleError"]').val();
	if(rolefail === "true"){
		var text = "Contact your administrator"
		$("#loginP").prepend('<br>').prepend(document.createTextNode(text));
	};
});

</script>
</html>