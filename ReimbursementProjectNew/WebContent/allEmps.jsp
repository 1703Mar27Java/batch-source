<%@ page import="java.util.*" %>
<%@ page import="com.revature.domain.UserFrontBean" %>
<%@ page import="com.revature.util.UserDAOUtil" %>


	<%ArrayList<UserFrontBean> userList = new ArrayList<UserFrontBean>();%>
	<%userList = (ArrayList<UserFrontBean>)UserDAOUtil.getAllFrontEmps(); %>
	<div id = "empList" style="display: none">
		<table id = "empListTable">
			<tr>
				<th>First Name</th>
				<th>Last Name</th>
				<th>Username</th>
				<th>Email</th>
			</tr>
			<%

			for(int i = 0; i < userList.size(); i++)
			{

			%><tr><%
			%><td><%	out.print(userList.get(i).getFirstName() + " ");%></td><%
			%><td><%	out.print(userList.get(i).getLastName() + " ");%></td><%
			%><td><%	out.print(userList.get(i).getUsername() + " ");%></td><%
			%><td><%	out.print(userList.get(i).getEmail() + " ");%></td><%
			%><td><button id = "<%out.print(userList.get(i).getId());%>" name="empDetails" style="height: 50px;width:100px">Details</button></td><%

			%></tr><%
			}
			%>
		</table>	
	</div>