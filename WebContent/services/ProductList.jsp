<%@page import="com.google.gson.Gson"%>
<%@page import="com.WareTech.CmsTech.database.Database"%>
<%@page import="com.WareTech.CmsTech.entity.Product"%>
<%@page import="java.util.List"%>
<% 
List<Product> productList = Database.getCurrentSession().createQuery("FROM Product").list();

out.print(new Gson().toJson(productList));
%>