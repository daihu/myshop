package myshop.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.*;

/**
 * �����û���¼����֤�͸�����֤������¶����û�
 */
public class ServletLogin extends HttpServlet {

	// ������ HTTP Get ����
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		process(request, response);
	}

	// ������ HTTP Post ����
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		process(request, response);
	}

	// ͳһ���� Get �� Post ��ʽ����
	private void process(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		String username = request.getParameter("username"); //����ύ�û���������ֵ
		String password = request.getParameter("password"); //����ύ���������ֵ
		if (username != null && password != null && //�û������붼����Ϊ��
				"admin".equals(username) && //�û����ǡ�admin��
				"111111".equals(password)) { //�����ǡ�111111��
			response.sendRedirect("/myshop/maintain/main.jsp"); //�ض����û�������ҳ��
			return; //�����ж�����
		} else {
			response.sendRedirect("/myshop/maintain/index.jsp"); //�ض����û�����½ҳ��
			return; //�����ж�����
		}
	}
}
