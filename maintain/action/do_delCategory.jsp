<%@ page contentType="text/html; charset=gb2312" %>
<%@ page import ="java.util.*,myshop.*"%>
<%
  //��ҳ�����ɾ�����Ĺ���

	request.setCharacterEncoding("gb2312"); //������������ʽ
	String id_str=request.getParameter("id"); //������ID
	CategoryManager.deleteCategory(Integer.parseInt(id_str)); //����JavaBeanɾ�����
	response.sendRedirect("../result.jsp"); //�ض����û�
%>
