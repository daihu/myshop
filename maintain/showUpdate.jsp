<%@ page contentType="text/html; charset=gb2312" %>
<%@ page import="java.util.*,myshop.*"%>
<%
	String id_str=request.getParameter("id"); //����û�ѡ�������ID
	int id=Integer.parseInt(id_str);
  	Category c=CategoryManager.getCategory(id); //���ѡ��ID����Ʒ���
%>
<html>
<head>
<title>��Ʒ������</title>
<meta http-equiv="Content-Type" content="text/html; charset=gb2312">
</head>

<body bgcolor="#FFFFFF" text="#000000">
<p>������ƣ�</p>
<form name="form1" method="post" action="action/do_updateCategory.jsp">
  <input type="text" name="categoryName" value="<%=c.getName()%>">
  <input type="hidden" name="id" value="<%=id%>"> <%--����hidden��Ǵ������ID--%>
  <br/>
  <input type="submit" name="Submit" value="�ύ">
</form>
</body>
</html>
