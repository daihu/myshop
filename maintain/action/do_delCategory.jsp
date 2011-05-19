<%@ page contentType="text/html; charset=gb2312" %>
<%@ page import ="java.util.*,myshop.*"%>
<%
  //该页面完成删除类别的功能

	request.setCharacterEncoding("gb2312"); //设置请求编码格式
	String id_str=request.getParameter("id"); //获得类别ID
	CategoryManager.deleteCategory(Integer.parseInt(id_str)); //调用JavaBean删除类别
	response.sendRedirect("../result.jsp"); //重订向用户
%>
