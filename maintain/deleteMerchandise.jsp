<%@ page contentType="text/html; charset=gb2312"%>
<%@ page import="java.util.*"%>
<%@ page import="myshop.*"%>
<html>
	<head>
		<title>ɾ����Ʒ</title>
		<meta http-equiv="Content-Type" content="text/html; charset=gb2312">
	</head>

	<body bgcolor="#FFFFFF" text="#000000">
		<p>
			��ѡ��ɾ����Ʒ��
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
		<%--����������--%>
	</body>
</html>
