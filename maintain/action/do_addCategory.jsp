<%@ page contentType="text/html; charset=gb2312" %>
<%@ page import ="java.util.*,myshop.*"%>
<%
  //���ҳ����ʾ�����ʹ��JSPҳ������洫ͳ��Servlet��ʽ��
  //�Դ����ҵ���߼��������û���������
  //ʹ��JSP�����Щ���ܱ�ʹ�ô�ͳ��Servlet���ӱ����޸ĺ�ά��

	//����ʹ��gb2312�������û������������Ի���ύ������
  request.setCharacterEncoding("gb2312");

  //����ύ���������
	String categoryName=request.getParameter("categoryName");

  //����һ���µ�������
  Category c=new Category();

  //�����������
	c.setName(categoryName);

  //����JavaBean�ύ���������𡱹���
	CategoryManager.addCategory(c);

  //�ض����û�
	response.sendRedirect("../result.jsp");
%>
