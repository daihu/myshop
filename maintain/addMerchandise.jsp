<%@ page contentType="text/html; charset=gb2312" %>

<%@ page import ="java.util.*"%>
<%@ page import ="myshop.*"%>
<html>
<head>
<title>�����Ʒ</title>
<meta http-equiv="Content-Type" content="text/html; charset=gb2312">
</head>

<body bgcolor="#FFFFFF" text="#000000">
<form name="form1" method="post" action="action/do_addMerchandise.jsp">
  <p> ��Ʒ���ƣ�
<input type="text" name="name">
  </p>
  <p> ��Ʒ�۸�
    <input type="text" name="price">
  </p>
  <p> ��Ʒ���ࣺ
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
    <input type="submit" name="Submit" value="�ύ">
  </p>
</form>
<%@include file="include/nav_merchandise.jsp"%> <%--����������--%>
</body>
</html>
