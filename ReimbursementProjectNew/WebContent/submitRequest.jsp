   <%@ page import="java.util.*" %>
   <%@ page import="com.revature.util.ReimDAOUtil" %>

		<form method = "post">
			<select id ="subReqType" name = "subReqType">
				<%
				ArrayList<String> types = (ArrayList<String>)ReimDAOUtil.getTypeListHelper();
				for(int i = 0; i < types.size(); i++)
				{
					 %><option value=<%out.print(types.get(i)); %>><%out.print(types.get(i)); %></option><%
				}
				%>
			</select><br>
			
       		<input id="subReqAmt" type="text" name = "subReqAmt" placeholder="Amount" required="" /><br>
       		<textarea id = "subReqDesc" rows ="4" cols="50" name = "subReqDesc" placeholder="Please describe any pertinent details">
       		</textarea><br>
       		<p>
       		Upload receipt<br>
       		<input id = "subReqRec" type="file" name = "subReqRec">
       		</p>
       		
       		<p>
       	    <input action="subReq" type="submit"  name="SubmitReq" value="Submit" type="Submit"></button>
       		</p>
       		<%HttpSession subReqSesh = request.getSession(); %>
       		<input type="hidden" name="u_id" value=<%subReqSesh.getAttribute("uID"); %> />
       		<input type="hidden" name="control" value="subReq" />
       		
		</form>


