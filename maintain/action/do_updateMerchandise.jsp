<%@ page contentType="text/html; charset=gb2312" %>
<%@ page import ="java.util.*, java.sql.Timestamp,myshop.*"%>
<%
  //这个页面完成更新商品信息功能

  request.setCharacterEncoding("gb2312"); //设置请求编码格式
	String id_str=request.getParameter("id"); //获得被更新商品ID
	int id=Integer.parseInt(id_str); //将字符串形式的ID转换成数值类型的ID
	String name=request.getParameter("name"); //获得商品名称
	int price=Integer.parseInt(request.getParameter("price")); //获得商品价格
	int category_id=Integer.parseInt(request.getParameter("category_id")); //获得商品类别ID
	Merchandise m=new Merchandise(); //声明商品对象
	m.setId(id); //设置ID
	m.setName(name); //设置名称
	m.setPrice(price); //设置价格
	m.setAddTime(new Timestamp(System.currentTimeMillis())); //设置上架时间
	m.setCategoryId(category_id); //设置所属类别
	MerchandiseManager.updateMerchandise(m); //调用JavaBean更新商品信息
	response.sendRedirect("../result.jsp"); //重订向用户
%>
