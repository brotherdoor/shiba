package lecture.servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/login.do")
public class LoginController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		response.sendRedirect("loginForm.jsp");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		String loginId = request.getParameter("loginId");
		HttpSession session = request.getSession();
		session.setAttribute("userId", loginId);
		session.setAttribute("isAdmin", isAdminUser(loginId));
		
		response.sendRedirect("list.do");
	}
	
	private boolean isAdminUser(String loginId){
		List<String> adminUsers = new ArrayList<>();
		adminUsers.add("choi");
		adminUsers.add("kim");
		adminUsers.add("jang");
		return adminUsers.contains(loginId);
	}

}
