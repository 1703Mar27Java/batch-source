<%@ page import="java.io.*,java.util.*" %>
<html>
<head>
<title></title>
</head>
<body>
<%
   // Set refresh, autoload time as 1 second
   response.setIntHeader("Refresh", 1);
   // Get current time
   Calendar calendar = new GregorianCalendar();
   String am_pm;
   int hour = calendar.get(Calendar.HOUR);
   int minute = calendar.get(Calendar.MINUTE);
   int second = calendar.get(Calendar.SECOND);
   if(calendar.get(Calendar.AM_PM) == 0)
      am_pm = "AM";
   else
      am_pm = "PM";
   String CurrentTime = hour+":"+ minute +":"+ second +" "+ am_pm;
   out.println("Current Time is: " + CurrentTime + "\n");
%>
</body>
</html>