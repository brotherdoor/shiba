package hr.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/login.do")
public class LoginController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		String loginId = request.getParameter("loginId");
		String passwd = request.getParameter("passwd");
		
//		�н����尡 1234�̸� �α��� ����
		if("1234".equals(passwd)){
//			�α��ο� �����ϸ� ���ǿ� �α��� ���̵� ����
			HttpSession session = request.getSession();
			session.setAttribute("loginId", loginId);
			
//			�޴��������̵�
			response.sendRedirect(request.getContextPath() + "/views/menu.jsp");
		}else{
			response.sendRedirect(request.getContextPath() + "/views/login.jsp");
		}
	}

}
