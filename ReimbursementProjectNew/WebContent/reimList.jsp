<%@ page import="java.util.*" %>
<%@ page import="com.revature.domain.ReimbursementFrontBean" %>
<%@ page import="com.revature.util.ReimDAOUtil" %>
<%@ page import="com.revature.util.UserDAOUtil" %>
<%@ page import="com.revature.domain.UserFrontBean" %>

<% 			HttpSession viewReqReimSesh = request.getSession();
			
			ArrayList<ReimbursementFrontBean> allList = (ArrayList<ReimbursementFrontBean>)ReimDAOUtil.getReimsHelper();
			ArrayList<ReimbursementFrontBean> pendList = (ArrayList<ReimbursementFrontBean>)ReimDAOUtil.getAllPending(allList);
			ArrayList<ReimbursementFrontBean> resolvList = (ArrayList<ReimbursementFrontBean>)ReimDAOUtil.getAllResolved(allList);

%>


<form>
	<div id = "resolveList" style="display: none">
		<table>
			<tr>
				<th>Employee</th>
				<th>Amount</th>
				<th>Submitted Date</th>
				<th>Resolved Date</th>
				<th>Status</th>
				<th>Resolving Manager</th>	
			</tr>
			<%

			for(int i = 0; i < resolvList.size(); i++)
			{
				UserFrontBean empRes = UserDAOUtil.translateBacktoFrontBean( UserDAOUtil.getUserByIDHelper(resolvList.get(i).getUserAuthorID()));
				UserFrontBean manRes = UserDAOUtil.translateBacktoFrontBean( UserDAOUtil.getUserByIDHelper(resolvList.get(i).getUserResolverID()));

			%><tr><%
			%><td><%	out.print(empRes.getFirstName() + " " + empRes.getLastName() + " ");%></td><%
			%><td><%	out.print(resolvList.get(i).getAmount() + " ");%></td><%
			%><td><%	out.print(resolvList.get(i).getSubmitted() + " ");%></td><%
			%><td><%	out.print(resolvList.get(i).getResolved() + " ");%></td><%
			%><td><%	out.print(resolvList.get(i).getStatus() + " ");%></td><%
			%><td><%	out.print(manRes.getFirstName() + " " + manRes.getLastName() + " ");%></td><%

			%></tr><%
			}
			%>
		</table>	

	</div>
	
		<div id = "pendList" style="display: none">
		<table id = "pendListTable">
			<tr>
				<th>Employee</th>
				<th>Amount</th>
				<th>Submitted Date</th>
				<th>Status</th>
			</tr>
			<%

			for(int i = 0; i < pendList.size(); i++)
			{
				UserFrontBean empPend = UserDAOUtil.translateBacktoFrontBean( UserDAOUtil.getUserByIDHelper(pendList.get(i).getUserAuthorID()));
				UserFrontBean manPend = UserDAOUtil.translateBacktoFrontBean( UserDAOUtil.getUserByIDHelper(pendList.get(i).getUserResolverID()));

			%><tr><%
			%><td><%	out.print(empPend.getFirstName() + " " + empPend.getLastName() + " ");%></td><%
			%><td><%	out.print(pendList.get(i).getAmount() + " ");%></td><%
			%><td><%	out.print(pendList.get(i).getSubmitted() + " ");%></td><%
			%><td><%	out.print(pendList.get(i).getStatus() + " ");%></td><%
			%><td><button id = "<%out.print(pendList.get(i).getId());%>" name="approve" style="height: 50px;width:100px">Approve</button></td><%
			%><td><button id = "<%out.print(pendList.get(i).getId());%>" name="decline" style="height: 50px;width:100px">Decline</button></td><%

			%></tr><%
			}
			%>
		</table>	
	</div>
</form>
