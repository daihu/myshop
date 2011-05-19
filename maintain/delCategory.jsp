<%@ page contentType="text/html; charset=gb2312" %>
<%@ page import="java.util.*"%>
<%@ page import="myshop.*"%>
<html>
<head>
<title>删除类别</title>
<meta http-equiv="Content-Type" content="text/html; charset=gb2312">
</head>

<body bgcolor="#FFFFFF" text="#000000">
<p>请选择要删除的类别：</p>
<p>
<%
	Category c = null;
	Iterator it=CategoryManager.getAllCategory();
  	while(it.hasNext()){
    	c = (Category) it.next();
    	out.println("<a href=\"action/do_delCategory.jsp?id="+c.getId() +"\">"+c.getName()+"</a><br>");
  	}    //          <a href="action/do_delCategory.jsp?id=1">AAAAAAA</a><br>
%>
</p>
<%@include file="include/nav_category.jsp"%> <%--包含导航条--%>
</body>
</html>
