<%@page import="com.google.gson.Gson"%>
<%@page import="com.WareTech.CmsTech.database.Database"%>
<%@page import="com.WareTech.CmsTech.entity.Configuration"%>
<%@page import="java.util.List"%>
<% 
List<Configuration> configurationList = Database.getCurrentSession().createQuery("FROM Configuration").list();

out.print(new Gson().toJson(configurationList));
%>