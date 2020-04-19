<%@page import="com.google.gson.Gson"%>
<%@page import="com.WareTech.CmsTech.database.Database"%>
<%@page import="com.WareTech.CmsTech.entity.Alert"%>
<%@page import="java.util.List"%>
<% 
List<Alert> alertList = Database.getCurrentSession().createQuery("FROM Alert").list();

out.print(new Gson().toJson(alertList));
%>