<%@ page contentType="text/html; charset=gb2312" %>
<%@ page import="java.util.*,myshop.*"%>
<html>
<head>
<title>������Ʒ</title>
<meta http-equiv="Content-Type" content="text/html; charset=gb2312">
</head>

<body bgcolor="#FFFFFF" text="#000000">
<p>��ѡ����µ���Ʒ��</p>
<p>
<%
	for(Iterator it=MerchandiseManager.getAllMerchandise();it.hasNext();){
    Merchandise m=(Merchandise) it.next();
    out.println("<a href=\"showUpdateM.jsp?id="+m.getId() +"\">"+m.getName()+"</a><br>");
  }
%>
</p>
<%@include file="include/nav_merchandise.jsp"%> <%--����������--%>
</body>
</html>
