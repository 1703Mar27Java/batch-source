<%@ page import="java.util.*" %>
<%@ page import="com.revature.domain.UserFrontBean" %>
<%@ page import="com.revature.util.UserDAOUtil" %>
 
 
 
 
 
     <input id="regUsername" type="text" name = "regUsername" placeholder="Username" required="" /><br>
      <input id="regPassword" type="text" name = "regPassword" placeholder="Password" required="" /><br>
      <input id="regFirstname" type="text" name = "regFirstname" placeholder="First Name" required="" /><br>
      <input id="regLastname" type="text" name = "regLastname" placeholder="Last Name" required="" /><br>
      <input id="regEmail" type="text" name = "regEmail" placeholder="Email" /><br>
       		<p>
       	    <input action="regNewUser" type="submit"  name="regEmpSubmit" value="Submit" type="Submit"></button>
       		</p>
 
       		
 
       		