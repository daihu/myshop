<%@ page contentType="text/html; charset=gb2312" %>
<%@ page import ="java.util.*, java.sql.Timestamp,myshop.*"%>
<%
  //这个页面完成添加新商品的功能。

	//设置使用gb2312编码获得用户请求，这样可以获得提交的中文
  request.setCharacterEncoding("gb2312");

  //获得用户提交的商品名称
  String name=request.getParameter("name");

  //获得提交的商品价格
	int price=Integer.parseInt(request.getParameter("price"));

  //获得商品所属的类别ID
	int category_id=Integer.parseInt(request.getParameter("category_id"));

 //声明新商品对象
	Merchandise m=new Merchandise();

  //设置商品名称
  m.setName(name);

  //设置商品价格
	m.setPrice(price);

  //设置商品上架时间为当前时间
	m.setAddTime(new Timestamp(System.currentTimeMillis()));

  //设置商品所属类别
  m.setCategoryId(category_id);

  //调用JavaBean添加新商品
	MerchandiseManager.addMerchandise(m);

  //重定向用户
	response.sendRedirect("../result.jsp");
%>
