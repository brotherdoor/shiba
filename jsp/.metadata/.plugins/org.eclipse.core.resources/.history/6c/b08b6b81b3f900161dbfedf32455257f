package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import domain.User;
import service.UserService;
import service.logic.UserServiceLogic;

@WebServlet("/join.do")
public class JoinController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		response.sendRedirect("join.jsp");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		String id = request.getParameter("loginId");
		String password = request.getParameter("password");
		String name = request.getParameter("name");
		
		User user = new User();
		user.setLoginId(id);
		user.setPassword(password);
		user.setName(name);
		
		UserService service = new UserServiceLogic();
		boolean result = service.register(user);
		if(result){
			response.sendRedirect("login.do");
		}
	}

}
