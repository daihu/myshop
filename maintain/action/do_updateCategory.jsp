<%@ page contentType="text/html; charset=gb2312" %>
<%@ page import ="java.util.*,myshop.*"%>
<%
  //��ҳ����ɶ���Ʒ���ĸ��¹���

	request.setCharacterEncoding("gb2312"); //������������ʽ
	String categoryName=request.getParameter("categoryName"); //�����Ʒ�������
	String id_str=request.getParameter("id"); //������ID
	int id=Integer.parseInt(id_str); //��������ת��
	Category c=new Category(id,categoryName); //���������
	CategoryManager.updateCategory(c); //����JavaBean�������
	response.sendRedirect("../result.jsp"); //�ض����û�
%>
