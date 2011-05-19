<%@ page contentType="text/html; charset=gb2312" %>
<%@ page import ="java.util.*,myshop.*"%>
<%
  //这个页面演示了如何使用JSP页面类代替传统的Servlet方式。
  //以处理简单业务逻辑、控制用户访问流向。
  //使用JSP完成这些功能比使用传统的Servlet更加便于修改和维护

	//设置使用gb2312编码获得用户请求，这样可以获得提交的中文
  request.setCharacterEncoding("gb2312");

  //获得提交的类别名称
	String categoryName=request.getParameter("categoryName");

  //声明一个新的类别对象
  Category c=new Category();

  //设置类别名称
	c.setName(categoryName);

  //调用JavaBean提交“添加新类别”功能
	CategoryManager.addCategory(c);

  //重定向用户
	response.sendRedirect("../result.jsp");
%>
