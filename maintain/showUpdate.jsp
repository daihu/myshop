<%@ page contentType="text/html; charset=gb2312" %>
<%@ page import="java.util.*,myshop.*"%>
<%
	String id_str=request.getParameter("id"); //获得用户选定的类别ID
	int id=Integer.parseInt(id_str);
  	Category c=CategoryManager.getCategory(id); //获得选定ID的商品类别
%>
<html>
<head>
<title>商品类别更新</title>
<meta http-equiv="Content-Type" content="text/html; charset=gb2312">
</head>

<body bgcolor="#FFFFFF" text="#000000">
<p>类别名称：</p>
<form name="form1" method="post" action="action/do_updateCategory.jsp">
  <input type="text" name="categoryName" value="<%=c.getName()%>">
  <input type="hidden" name="id" value="<%=id%>"> <%--采用hidden标记传递类别ID--%>
  <br/>
  <input type="submit" name="Submit" value="提交">
</form>
</body>
</html>
