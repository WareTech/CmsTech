<%@page import="com.google.gson.Gson"%>
<%@page import="com.WareTech.CmsTech.database.Database"%>
<%@page import="com.WareTech.CmsTech.entity.Category"%>
<%@page import="java.util.List"%>
<% 
List<Category> categoryList = Database.getCurrentSession().createQuery("FROM Category").list();

out.print(new Gson().toJson(categoryList));
%>