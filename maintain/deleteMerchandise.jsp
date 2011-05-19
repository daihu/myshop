<%@ page contentType="text/html; charset=gb2312"%>
<%@ page import="java.util.*"%>
<%@ page import="myshop.*"%>
<html>
	<head>
		<title>删除商品</title>
		<meta http-equiv="Content-Type" content="text/html; charset=gb2312">
	</head>

	<body bgcolor="#FFFFFF" text="#000000">
		<p>
			请选择删除商品：
		</p>
		<p>
			<%
				for (Iterator it = MerchandiseManager.getAllMerchandise(); it.hasNext();) {
					Merchandise m = (Merchandise) it.next();
					out.println("<a href=\"action/do_deleteMerchandise.jsp?id="
					+ m.getId() + "\">" + m.getName() + "</a><br>");
				}
			%>
		</p>
		<%@include file="include/nav_merchandise.jsp"%>
		<%--包含导航条--%>
	</body>
</html>
