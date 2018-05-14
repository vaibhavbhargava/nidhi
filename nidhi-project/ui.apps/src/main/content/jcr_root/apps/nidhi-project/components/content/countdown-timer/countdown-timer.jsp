<%--

  Countdown Timer component.



--%>
    <%@ page import="java.util.GregorianCalendar, java.util.Calendar, com.day.cq.wcm.api.WCMMode" %><%
%><%@include file="/libs/foundation/global.jsp"%><%
%><%@page session="false" %><%
%><%
	Calendar calendar = properties.get("date",null);
long millisecond = calendar.getTimeInMillis();
if (WCMMode.fromRequest(request) == WCMMode.EDIT){
%>
Time Selected Is <% out.print(calendar.get(Calendar.DATE)+"-"+(calendar.get(Calendar.MONTH)+1)+"-"+calendar.get(Calendar.YEAR) + " " +calendar.get(Calendar.HOUR_OF_DAY)+":" +calendar.get(Calendar.MINUTE)+":" +calendar.get(Calendar.SECOND));%>
<%}%>
<p id="demo"data-time="<%= millisecond %>"></p>


