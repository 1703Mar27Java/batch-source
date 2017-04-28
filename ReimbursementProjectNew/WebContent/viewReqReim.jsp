<%@ page import="java.util.*" %>
<%@ page import="com.revature.domain.ReimbursementFrontBean" %>
<%@ page import="com.revature.util.ReimDAOUtil" %>


<form>
	<div>
		<table class = "table">
			<tr>
				<th>Submitted Date</th>
				<th>Amount</th>
				<th>Description</th>
				<th>Type</th>
				<th>Status</th>	
			</tr>
			<%
			HttpSession viewReqReimSesh = request.getSession();
			int userID = (int)viewReqReimSesh.getAttribute("uID");
			
			ArrayList<ReimbursementFrontBean> frontList = (ArrayList<ReimbursementFrontBean>)ReimDAOUtil.getUserReims(userID);
			for(int i = 0; i < frontList.size(); i++)
			{
			%><tr><%
			%><td><%	out.print(frontList.get(i).getSubmitted() + " ");%></td><%
			%><td><%	out.print(frontList.get(i).getAmount() + " ");%></td><%
			%><td><%	out.print(frontList.get(i).getDescription() + " ");%></td><%
			%><td><%	out.print(frontList.get(i).getType() + " ");%></td><%
			%><td><%	out.print(frontList.get(i).getStatus() + " ");%></td><%
			%></tr><%
			}
			%>
		</table>	
	</div>
</form>