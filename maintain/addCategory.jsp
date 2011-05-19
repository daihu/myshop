<%@ page contentType="text/html; charset=gb2312" %>
<html>
<head>
<title>添加类别</title>
<meta http-equiv="Content-Type" content="text/html; charset=gb2312">
</head>

<body bgcolor="#FFFFFF" text="#000000">
<p> 请输入类别名称：</p>
<form name="form1" method="post" action="action/do_addCategory.jsp">
  <input type="text" name="categoryName"> <br/>
  <input type="submit" name="Submit" value="提交">
</form>
<%@include file="include/nav_category.jsp"%> <%--包含导航条--%>
</body>
</html>
