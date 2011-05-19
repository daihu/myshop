<%@ page contentType="text/html; charset=gb2312" %>
<%@ page import ="java.util.*,myshop.*"%>
<%
	//该页面完成删除商品功能

  	request.setCharacterEncoding("gb2312"); //设置请求编码格式
	String id_str=request.getParameter("id"); //获得商品ID
	MerchandiseManager.deleteMerchandise(Integer.parseInt(id_str)); //调用JavaBean新建商品
	response.sendRedirect("../result.jsp"); //重定向用户
%>
