package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.util.*;
import myshop.*;
import java.text.*;

public final class showM_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

//使用JSP声明。定义对时间的格式化类。只显示年月日参数，而忽略时分秒
	SimpleDateFormat df = new SimpleDateFormat("yyyy年MM月dd日");

	//使用JSP声明。定义对货币的格式化类。指定使用中国的货币显示方式
	NumberFormat nf = NumberFormat.getCurrencyInstance(Locale.PRC);
  private static final javax.servlet.jsp.JspFactory _jspxFactory =
          javax.servlet.jsp.JspFactory.getDefaultFactory();

  private static java.util.List<java.lang.String> _jspx_dependants;

  private javax.el.ExpressionFactory _el_expressionfactory;
  private org.apache.tomcat.InstanceManager _jsp_instancemanager;

  public java.util.List<java.lang.String> getDependants() {
    return _jspx_dependants;
  }

  public void _jspInit() {
    _el_expressionfactory = _jspxFactory.getJspApplicationContext(getServletConfig().getServletContext()).getExpressionFactory();
    _jsp_instancemanager = org.apache.jasper.runtime.InstanceManagerFactory.getInstanceManager(getServletConfig());
  }

  public void _jspDestroy() {
  }

  public void _jspService(final javax.servlet.http.HttpServletRequest request, final javax.servlet.http.HttpServletResponse response)
        throws java.io.IOException, javax.servlet.ServletException {

    final javax.servlet.jsp.PageContext pageContext;
    javax.servlet.http.HttpSession session = null;
    final javax.servlet.ServletContext application;
    final javax.servlet.ServletConfig config;
    javax.servlet.jsp.JspWriter out = null;
    final java.lang.Object page = this;
    javax.servlet.jsp.JspWriter _jspx_out = null;
    javax.servlet.jsp.PageContext _jspx_page_context = null;


    try {
      response.setContentType("text/html; charset=gb2312");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;

      out.write("\r\n");
      out.write("\r\n");
      out.write('\r');
      out.write('\n');

	int id = Integer.parseInt(request.getParameter("id")); //获得商品类别ID
	Category c = CategoryManager.getCategory(id); //获得商品类别对象
	String currPage = request.getParameter("currPage"); //当前页号
	if (currPage == null) {
		currPage = "1";
	} // 如果没有设置则默认为第一页
	int cp = Integer.parseInt(currPage); //将当前页号转换成int型

      out.write("\r\n");
      out.write("<html>\r\n");
      out.write("\t<head>\r\n");
      out.write("\t\t<title>商品列表</title>\r\n");
      out.write("\t\t<meta http-equiv=\"Content-Type\" content=\"text/html; charset=gb2312\">\r\n");
      out.write("\t</head>\r\n");
      out.write("\r\n");
      out.write("\t<body bgcolor=\"#FFFFFF\" text=\"#000000\">\r\n");
      out.write("\t\t");

		if (c != null) {
		
      out.write("\r\n");
      out.write("\t\t<p>\r\n");
      out.write("\t\t\t“\r\n");
      out.write("\t\t\t");
      out.print(c.getName());
      out.write("\r\n");
      out.write("\t\t\t”商品类别：\r\n");
      out.write("\t\t</p>\r\n");
      out.write("\t\t<p>\r\n");
      out.write("\t\t<table border=\"1\">\r\n");
      out.write("\t\t\t<tr>\r\n");
      out.write("\t\t\t\t<td>\r\n");
      out.write("\t\t\t\t\t商品名称\r\n");
      out.write("\t\t\t\t</td>\r\n");
      out.write("\t\t\t\t<td>\r\n");
      out.write("\t\t\t\t\t销售价格\r\n");
      out.write("\t\t\t\t</td>\r\n");
      out.write("\t\t\t\t<td>\r\n");
      out.write("\t\t\t\t\t上架时间\r\n");
      out.write("\t\t\t\t</td>\r\n");
      out.write("\t\t\t</tr>\r\n");
      out.write("\t\t\t");

			for (Iterator it = MerchandiseManager.getOnePageMerchandise(c,cp); it.hasNext();) {
					Merchandise m = (Merchandise) it.next();
			
      out.write("\r\n");
      out.write("\t\t\t<tr>\r\n");
      out.write("\t\t\t\t<td>\r\n");
      out.write("\t\t\t\t\t");
      out.print(m.getName());
      out.write("\r\n");
      out.write("\t\t\t\t</td>\r\n");
      out.write("\t\t\t\t<td>\r\n");
      out.write("\t\t\t\t\t");
      out.print(nf.format(m.getPrice() / 100d));
      out.write("\r\n");
      out.write("\t\t\t\t</td>\r\n");
      out.write("\t\t\t\t<td>\r\n");
      out.write("\t\t\t\t\t");
      out.print(df.format(m.getAddTime()));
      out.write("\r\n");
      out.write("\t\t\t\t</td>\r\n");
      out.write("\t\t\t</tr>\r\n");
      out.write("\t\t\t");

			} // End for
			
      out.write("\r\n");
      out.write("\t\t</table>\r\n");
      out.write("\t\t\r\n");
      out.write("\t\t");

		if (cp < MerchandiseManager.getMaxPageNumber(c)) { //当前页号小于最大页号时才显示“下一页”
		
      out.write("\r\n");
      out.write("\t\t<a href=\"?currPage=");
      out.print(cp + 1);
      out.write("&id=");
      out.print(id);
      out.write("\">下一页</a>&nbsp;&nbsp;&nbsp;&nbsp;\r\n");
      out.write("\t\t");

		}
		
      out.write("\r\n");
      out.write("\t\t");

		if (cp > 1) { //当前页号大于第一页时才显示“上一页”
		
      out.write("\r\n");
      out.write("\t\t<a href=\"?currPage=");
      out.print(cp - 1);
      out.write("&id=");
      out.print(id);
      out.write("\">上一页</a>\r\n");
      out.write("\t\t");

		}
		
      out.write("\r\n");
      out.write("\t\t<p>\r\n");
      out.write("\t\t\t");

			} else {
			
      out.write("\r\n");
      out.write("\t\t\t该类别没有任何商品\r\n");
      out.write("\t\t\t<br />\r\n");
      out.write("\t\t\t");

			}
			
      out.write("\r\n");
      out.write("\t\t\t<a href=\"index.jsp\">返回</a>\r\n");
      out.write("\t</body>\r\n");
      out.write("</html>\r\n");
    } catch (java.lang.Throwable t) {
      if (!(t instanceof javax.servlet.jsp.SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          try { out.clearBuffer(); } catch (java.io.IOException e) {}
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
