<%@ page contentType="text/html; charset=gb2312" import="java.util.*"%>
<%@ page import="myshop.*"%>
<html>
	<head>
		<title>商品类别列表</title>
		<meta http-equiv="Content-Type" content="text/html; charset=gb2312">
	</head>

	<body bgcolor="#FFFFFF" text="#000000">
		<h2>
			当前商品类别
		</h2>
		<p>
			<%
				for (Iterator it = CategoryManager.getAllCategory(); it.hasNext();) {
					Category c = (Category) it.next(); //获得类别集合中的具体类别对象

					//显示HTML的超连接。指向showM.jsp页面。
					out.println("<a href=\"showM.jsp?id=" + c.getId() + "\">"
					+ c.getName() + "</a><br>");
				}
			%>
		</p>
	</body>
</html>
