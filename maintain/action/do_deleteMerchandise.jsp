<%@ page contentType="text/html; charset=gb2312" %>
<%@ page import ="java.util.*,myshop.*"%>
<%
	//��ҳ�����ɾ����Ʒ����

  	request.setCharacterEncoding("gb2312"); //������������ʽ
	String id_str=request.getParameter("id"); //�����ƷID
	MerchandiseManager.deleteMerchandise(Integer.parseInt(id_str)); //����JavaBean�½���Ʒ
	response.sendRedirect("../result.jsp"); //�ض����û�
%>
