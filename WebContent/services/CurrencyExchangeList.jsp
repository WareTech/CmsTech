<%@page import="com.google.gson.Gson"%>
<%@page import="com.WareTech.CmsTech.database.Database"%>
<%@page import="com.WareTech.CmsTech.entity.CurrencyExchange"%>
<%@page import="java.util.List"%>
<% 
List<CurrencyExchange> currencyExchangeList = Database.getCurrentSession().createQuery("FROM CurrencyExchange").list();

out.print(new Gson().toJson(currencyExchangeList));
%>