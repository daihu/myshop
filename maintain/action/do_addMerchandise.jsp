<%@ page contentType="text/html; charset=gb2312" %>
<%@ page import ="java.util.*, java.sql.Timestamp,myshop.*"%>
<%
  //���ҳ������������Ʒ�Ĺ��ܡ�

	//����ʹ��gb2312�������û������������Ի���ύ������
  request.setCharacterEncoding("gb2312");

  //����û��ύ����Ʒ����
  String name=request.getParameter("name");

  //����ύ����Ʒ�۸�
	int price=Integer.parseInt(request.getParameter("price"));

  //�����Ʒ���������ID
	int category_id=Integer.parseInt(request.getParameter("category_id"));

 //��������Ʒ����
	Merchandise m=new Merchandise();

  //������Ʒ����
  m.setName(name);

  //������Ʒ�۸�
	m.setPrice(price);

  //������Ʒ�ϼ�ʱ��Ϊ��ǰʱ��
	m.setAddTime(new Timestamp(System.currentTimeMillis()));

  //������Ʒ�������
  m.setCategoryId(category_id);

  //����JavaBean�������Ʒ
	MerchandiseManager.addMerchandise(m);

  //�ض����û�
	response.sendRedirect("../result.jsp");
%>
