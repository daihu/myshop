<%@ page contentType="text/html; charset=gb2312" import="java.util.*"%>
<%@ page import="myshop.*"%>
<html>
	<head>
		<title>��Ʒ����б�</title>
		<meta http-equiv="Content-Type" content="text/html; charset=gb2312">
	</head>

	<body bgcolor="#FFFFFF" text="#000000">
		<h2>
			��ǰ��Ʒ���
		</h2>
		<p>
			<%
				for (Iterator it = CategoryManager.getAllCategory(); it.hasNext();) {
					Category c = (Category) it.next(); //�����𼯺��еľ���������

					//��ʾHTML�ĳ����ӡ�ָ��showM.jspҳ�档
					out.println("<a href=\"showM.jsp?id=" + c.getId() + "\">"
					+ c.getName() + "</a><br>");
				}
			%>
		</p>
	</body>
</html>
