<%@ page contentType="text/html; charset=gb2312"%>
<%@ page import="java.util.*,myshop.*,java.text.*"%>
<%!//ʹ��JSP�����������ʱ��ĸ�ʽ���ࡣֻ��ʾ�����ղ�����������ʱ����
	SimpleDateFormat df = new SimpleDateFormat("yyyy��MM��dd��");

	//ʹ��JSP����������Ի��ҵĸ�ʽ���ࡣָ��ʹ���й��Ļ�����ʾ��ʽ
	NumberFormat nf = NumberFormat.getCurrencyInstance(Locale.PRC);%>
<%
	int id = Integer.parseInt(request.getParameter("id")); //�����Ʒ���ID
	Category c = CategoryManager.getCategory(id); //�����Ʒ������
	String currPage = request.getParameter("currPage"); //��ǰҳ��
	if (currPage == null) {
		currPage = "1";
	} // ���û��������Ĭ��Ϊ��һҳ
	int cp = Integer.parseInt(currPage); //����ǰҳ��ת����int��
%>
<html>
	<head>
		<title>��Ʒ�б�</title>
		<meta http-equiv="Content-Type" content="text/html; charset=gb2312">
	</head>

	<body bgcolor="#FFFFFF" text="#000000">
		<%
		if (c != null) {
		%>
		<p>
			��
			<%=c.getName()%>
			����Ʒ���
		</p>
		<p>
		<table border="1">
			<tr>
				<td>
					��Ʒ����
				</td>
				<td>
					���ۼ۸�
				</td>
				<td>
					�ϼ�ʱ��
				</td>
			</tr>
			<%
			for (Iterator it = MerchandiseManager.getOnePageMerchandise(c,cp); it.hasNext();) {
					Merchandise m = (Merchandise) it.next();
			%>
			<tr>
				<td>
					<%=m.getName()%>
				</td>
				<td>
					<%=nf.format(m.getPrice() / 100d)%>
				</td>
				<td>
					<%=df.format(m.getAddTime())%>
				</td>
			</tr>
			<%
			} // End for
			%>
		</table>
		
		<%
		if (cp < MerchandiseManager.getMaxPageNumber(c)) { //��ǰҳ��С�����ҳ��ʱ����ʾ����һҳ��
		%>
		<a href="?currPage=<%=cp + 1%>&id=<%=id%>">��һҳ</a>&nbsp;&nbsp;&nbsp;&nbsp;
		<%
		}
		%>
		<%
		if (cp > 1) { //��ǰҳ�Ŵ��ڵ�һҳʱ����ʾ����һҳ��
		%>
		<a href="?currPage=<%=cp - 1%>&id=<%=id%>">��һҳ</a>
		<%
		}
		%>
		<p>
			<%
			} else {
			%>
			�����û���κ���Ʒ
			<br />
			<%
			}
			%>
			<a href="index.jsp">����</a>
	</body>
</html>
