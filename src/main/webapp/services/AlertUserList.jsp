<%@page import="java.util.ArrayList"%>
<%@page import="com.WareTech.CmsTech.web.Utils"%>
<%@page import="com.google.gson.Gson"%>
<%@page import="com.WareTech.CmsTech.database.Database"%>
<%@page import="com.WareTech.CmsTech.entity.Alert"%>
<%@page import="com.WareTech.CmsTech.entity.User"%>
<%@page import="java.util.List"%>
<% 
User user = Utils.getUser(request, response);
if (user == null)
{
	out.print(new Gson().toJson(new ArrayList()));
	return;
}

List<Alert> alertList = Database.getCurrentSession()
	.createQuery("SELECT au.alert FROM AlertUser au WHERE au.user = :user")
	.setEntity("user", user)
	.list();

out.print(new Gson().toJson(alertList));
%>