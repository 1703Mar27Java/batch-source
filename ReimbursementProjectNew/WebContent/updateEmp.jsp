<%@ page import="java.util.*" %>
<%@ page import="com.revature.domain.UserFrontBean" %>
<%@ page import="com.revature.util.UserDAOUtil" %>


<div>
	<table class = "table">
			<tr>
				<th>First Name</th>
				<th>Last Name</th>
				<th>Username</th>
				<th>Email</th>
				<th>Role</th>	
			</tr>
			<%
			HttpSession viewReqReimSesh = request.getSession();
			int userID = (int)viewReqReimSesh.getAttribute("uID");
			
			
			UserFrontBean user = UserDAOUtil.translateBacktoFrontBean(UserDAOUtil.getUserByIDHelper(userID));
	
			%><tr><%
			%><td><%	out.print(user.getFirstName() + " ");%></td><%
			%><td><%	out.print(user.getLastName() + " ");%></td><%
			%><td><%	out.print(user.getUsername() + " ");%></td><%
			%><td><%	out.print(user.getEmail() + " ");%></td><%
			%><td><%	out.print(user.getuRole() + " ");%></td><%
			%></tr>
	</table>	
</div>


<div>
	<form>
	<p>
	Leave fields blank if not updating.
	</p>
	<input id="firstName" type="text" name = "firstName" placeholder="Change First Name"/><br>
	<input id="lastName" type="text" name = "lastName" placeholder="Change Last Name"/><br>
	<input id="userName" type="text" name = "userName" placeholder="Change Username"/><br>
	<input id="email" type="text" name = "email" placeholder="Change Email"/><br>
	<p>Reset password?
	<input id="pwReset" type="checkbox" name = "pwReset">
	</p>
	
	<p>
 	   <input type="submit"  name="updateEmployee" value="Update" type="Submit"/>
    </p>
    <input type="hidden" name="u_id" value=<%viewReqReimSesh.getAttribute("uID"); %> />
    <input type="hidden" name="control" value="updateEmployee" />
	
	
	</form>
</div>


