<%@page import="com.google.gson.Gson"%>
<%@page import="com.WareTech.CmsTech.database.Database"%>
<%@page import="com.WareTech.CmsTech.entity.User"%>
<%@page import="java.util.List"%>
<% 
List<User> userList = Database.getCurrentSession().createQuery("FROM User").list();

out.print(new Gson().toJson(userList));
%>