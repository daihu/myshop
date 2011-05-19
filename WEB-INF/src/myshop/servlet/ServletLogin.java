package myshop.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.*;

/**
 * 处理用户登录的认证和根据认证结果重新定向用户
 */
public class ServletLogin extends HttpServlet {

	// 仅处理 HTTP Get 请求
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		process(request, response);
	}

	// 仅处理 HTTP Post 请求
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		process(request, response);
	}

	// 统一处理 Get 和 Post 方式请求
	private void process(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		String username = request.getParameter("username"); //获得提交用户名参数的值
		String password = request.getParameter("password"); //获得提交密码参数的值
		if (username != null && password != null && //用户名密码都不能为空
				"admin".equals(username) && //用户名是“admin”
				"111111".equals(password)) { //密码是“111111”
			response.sendRedirect("/myshop/maintain/main.jsp"); //重订向用户到功能页面
			return; //结束判定流程
		} else {
			response.sendRedirect("/myshop/maintain/index.jsp"); //重订向用户到登陆页面
			return; //结束判定流程
		}
	}
}
