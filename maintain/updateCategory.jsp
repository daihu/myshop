<%@ page contentType="text/html; charset=gb2312" %>
<%@ page import="java.util.*"%>
<%@ page import="myshop.*"%>
<html>
<head>
<title>更新类别</title>
<meta http-equiv="Content-Type" content="text/html; charset=gb2312">
</head>

<body bgcolor="#FFFFFF" text="#000000">
<p>请选择更新的类别：</p>
<p>
<%
	Category c = null;
  for(Iterator it=CategoryManager.getAllCategory();it.hasNext();){
   c=(Category) it.next();
   out.println("<a href=\"showUpdate.jsp?id="+c.getId() +"\">"+c.getName()+"</a><br>");
}
%>
</p>
<%@include file="include/nav_category.jsp"%> <%--包含导航条--%>
</body>
</html>
