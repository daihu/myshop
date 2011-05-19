<%@ page contentType="text/html; charset=gb2312"%>
<%@ page import="java.util.*,myshop.*,java.text.*"%>
<%!//使用JSP声明。定义对时间的格式化类。只显示年月日参数，而忽略时分秒
	SimpleDateFormat df = new SimpleDateFormat("yyyy年MM月dd日");

	//使用JSP声明。定义对货币的格式化类。指定使用中国的货币显示方式
	NumberFormat nf = NumberFormat.getCurrencyInstance(Locale.PRC);%>
<%
	int id = Integer.parseInt(request.getParameter("id")); //获得商品类别ID
	Category c = CategoryManager.getCategory(id); //获得商品类别对象
	String currPage = request.getParameter("currPage"); //当前页号
	if (currPage == null) {
		currPage = "1";
	} // 如果没有设置则默认为第一页
	int cp = Integer.parseInt(currPage); //将当前页号转换成int型
%>
<html>
	<head>
		<title>商品列表</title>
		<meta http-equiv="Content-Type" content="text/html; charset=gb2312">
	</head>

	<body bgcolor="#FFFFFF" text="#000000">
		<%
		if (c != null) {
		%>
		<p>
			“
			<%=c.getName()%>
			”商品类别：
		</p>
		<p>
		<table border="1">
			<tr>
				<td>
					商品名称
				</td>
				<td>
					销售价格
				</td>
				<td>
					上架时间
				</td>
			</tr>
			<%
			for (Iterator it = MerchandiseManager.getOnePageMerchandise(c,cp); it.hasNext();) {
					Merchandise m = (Merchandise) it.next();
			%>
			<tr>
				<td>
					<%=m.getName()%>
				</td>
				<td>
					<%=nf.format(m.getPrice() / 100d)%>
				</td>
				<td>
					<%=df.format(m.getAddTime())%>
				</td>
			</tr>
			<%
			} // End for
			%>
		</table>
		
		<%
		if (cp < MerchandiseManager.getMaxPageNumber(c)) { //当前页号小于最大页号时才显示“下一页”
		%>
		<a href="?currPage=<%=cp + 1%>&id=<%=id%>">下一页</a>&nbsp;&nbsp;&nbsp;&nbsp;
		<%
		}
		%>
		<%
		if (cp > 1) { //当前页号大于第一页时才显示“上一页”
		%>
		<a href="?currPage=<%=cp - 1%>&id=<%=id%>">上一页</a>
		<%
		}
		%>
		<p>
			<%
			} else {
			%>
			该类别没有任何商品
			<br />
			<%
			}
			%>
			<a href="index.jsp">返回</a>
	</body>
</html>
