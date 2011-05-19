<%@ page contentType="text/html; charset=gb2312" %>
<%@ page import="java.util.*,myshop.*"%>
<%
	String id_str=request.getParameter("id");
	Merchandise m=new Merchandise();
	int id=Integer.parseInt(id_str);
	m=MerchandiseManager.getMerchandise(id);
	String name=m.getName();
	int price=m.getPrice();
%>
<html>
<head>
<title>更新商品</title>
<meta http-equiv="Content-Type" content="text/html; charset=gb2312">
</head>

<body bgcolor="#FFFFFF" text="#000000">
<form name="form1" method="post" action="action/do_updateMerchandise.jsp">
  <p>产品名称：
    <input type="text" name="name" value="<%=name%>">
    <input type="hidden" name="id" value="<%=id%>">
  </p>
  <p>产品价格：
    <input type="text" name="price" value="<%=price%>">
  </p>
  <p>产品类别：
    <select name="category_id">
	<%
		for(Iterator it=CategoryManager.getAllCategory();it.hasNext();){
      Category c=(Category) it.next();
      out.println("<option value=\""+c.getId()+"\" "+(m.getCategoryId()==c.getId()?" selected":"")+">"+c.getName()+"</option>");
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
