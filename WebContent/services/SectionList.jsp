<%@page import="com.google.gson.Gson"%>
<%@page import="com.WareTech.CmsTech.database.Database"%>
<%@page import="com.WareTech.CmsTech.entity.Section"%>
<%@page import="java.util.List"%>
<% 
List<Section> sectionList = Database.getCurrentSession().createQuery("FROM Section").list();

out.print(new Gson().toJson(sectionList));
%>