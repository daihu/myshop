<%@ page contentType="text/html; charset=gb2312" %>
<%@ page import="java.util.*"%>
<%@ page import="myshop.*"%>
<html>
<head>
<title>ɾ�����</title>
<meta http-equiv="Content-Type" content="text/html; charset=gb2312">
</head>

<body bgcolor="#FFFFFF" text="#000000">
<p>��ѡ��Ҫɾ�������</p>
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
<%@include file="include/nav_category.jsp"%> <%--����������--%>
</body>
</html>
