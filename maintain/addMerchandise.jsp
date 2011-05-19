<%@ page contentType="text/html; charset=gb2312" %>

<%@ page import ="java.util.*"%>
<%@ page import ="myshop.*"%>
<html>
<head>
<title>添加商品</title>
<meta http-equiv="Content-Type" content="text/html; charset=gb2312">
</head>

<body bgcolor="#FFFFFF" text="#000000">
<form name="form1" method="post" action="action/do_addMerchandise.jsp">
  <p> 产品名称：
<input type="text" name="name">
  </p>
  <p> 产品价格：
    <input type="text" name="price">
  </p>
  <p> 产品种类：
  <select name="category_id">
	<%
		for(Iterator it=CategoryManager.getAllCategory();it.hasNext();) {
      Category c=(Category) it.next();
      out.println("<option value=\""+c.getId()+"\">"+c.getName()+"</option>");
    }
	%>
  </select>
  </p>
  <p>
    <input type="submit" name="Submit" value="提交">
  </p>
</form>
<%@include file="include/nav_merchandise.jsp"%> <%--包含导航条--%>
</body>
</html>
