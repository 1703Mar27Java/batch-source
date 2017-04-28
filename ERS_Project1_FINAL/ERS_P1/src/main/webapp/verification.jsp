<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="s" %>    
<%@page contentType="text/html" pageEncoding="UTF-8"%>
  <%@ page import="java.sql.*"%>  
  <%@page import="com.ers.util.*" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Verification Page</title>
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.0/jquery.min.js"></script>
<script src="ers.js"></script>	
</head>
<body>
 
 
 <%  
String s = request.getParameter("name");  
if(s==null || s.trim().equals("")){  
out.print("Please enter username");  
}else{  
String username = s;  
out.print(username);  
try{  
Connection con = ERSUtil.getConnectionFromFile();
PreparedStatement ps=con.prepareStatement("select * from ERS_USERS where U_USERNAME=?");  
ps.setString(2,s);  
ResultSet rs=ps.executeQuery();  
while(rs.next()){  
out.print(rs.getInt(1)+" "+rs.getString(2));  
}  
con.close();  
}catch(Exception e){e.printStackTrace();}  
}  
%>  
 
  <%-- --
   <%  
   String s = request.getParameter("role");  
   if(s == null || s.trim().equals("")){  
   out.print("Please enter username");  
   }else if(s == request.getParameter("manager")){  
	    RequestDispatcher rd = request.getRequestDispatcher("MgrInfo.jsp");
		rd.forward(request, response);
   out.print(s);
   }else {
	   RequestDispatcher rd = request.getRequestDispatcher("Info.jsp");
		rd.forward(request, response);
   } 
   try{  
	Connection con = ERSUtil.getConnectionFromFile();
   PreparedStatement ps = con.prepareStatement("select * from VERIFICATION where U_USER_ROLE=?");  
   ResultSet rs = ps.executeQuery();
	while(rs.next()){
		int id = rs.getInt("CAVE_ID");
		String name = rs.getString("CAVE_NAME");
		int maxBears = rs.getInt("MAX_BEARS");
		Cave c = new Cave(id,name,maxBears);
		caves.add(c);
	}
}catch(SQLException e){
	e.printStackTrace();
}finally{
	if (pstmt!=null){try {
		pstmt.close();
	} catch (SQLException e) {
		e.printStackTrace();
	}}}
   }
   finally
   %>  --%> 
   
  
 
  </body>
</html>