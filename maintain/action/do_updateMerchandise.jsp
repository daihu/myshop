<%@ page contentType="text/html; charset=gb2312" %>
<%@ page import ="java.util.*, java.sql.Timestamp,myshop.*"%>
<%
  //���ҳ����ɸ�����Ʒ��Ϣ����

  request.setCharacterEncoding("gb2312"); //������������ʽ
	String id_str=request.getParameter("id"); //��ñ�������ƷID
	int id=Integer.parseInt(id_str); //���ַ�����ʽ��IDת������ֵ���͵�ID
	String name=request.getParameter("name"); //�����Ʒ����
	int price=Integer.parseInt(request.getParameter("price")); //�����Ʒ�۸�
	int category_id=Integer.parseInt(request.getParameter("category_id")); //�����Ʒ���ID
	Merchandise m=new Merchandise(); //������Ʒ����
	m.setId(id); //����ID
	m.setName(name); //��������
	m.setPrice(price); //���ü۸�
	m.setAddTime(new Timestamp(System.currentTimeMillis())); //�����ϼ�ʱ��
	m.setCategoryId(category_id); //�����������
	MerchandiseManager.updateMerchandise(m); //����JavaBean������Ʒ��Ϣ
	response.sendRedirect("../result.jsp"); //�ض����û�
%>
