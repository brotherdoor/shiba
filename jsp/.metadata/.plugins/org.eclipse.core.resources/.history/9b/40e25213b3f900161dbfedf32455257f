package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import domain.User;
import service.MusicService;
import service.UserService;
import service.logic.MusicServiceLogic;
import service.logic.UserServiceLogic;

@WebServlet("/login.do")
public class LoginController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		response.sendRedirect("login.jsp");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		String id = request.getParameter("loginId");
		String password = request.getParameter("password");
		UserService service = new UserServiceLogic();
	
		User user = new User();
		user.setLoginId(id);
		user.setPassword(password);
		User loginUser = service.login(user);
		
		HttpSession session = request.getSession();
		session.setAttribute("loginedId", loginUser);
		
		response.sendRedirect("list.do");
	}

}
