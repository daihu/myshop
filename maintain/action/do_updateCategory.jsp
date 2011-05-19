<%@ page contentType="text/html; charset=gb2312" %>
<%@ page import ="java.util.*,myshop.*"%>
<%
  //该页面完成对商品类别的更新功能

	request.setCharacterEncoding("gb2312"); //设置请求编码格式
	String categoryName=request.getParameter("categoryName"); //获得商品类别名称
	String id_str=request.getParameter("id"); //获得类别ID
	int id=Integer.parseInt(id_str); //进行类型转化
	Category c=new Category(id,categoryName); //获得类别对象
	CategoryManager.updateCategory(c); //调用JavaBean更新类别
	response.sendRedirect("../result.jsp"); //重订向用户
%>
