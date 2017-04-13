package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import domain.BaseballTeam;
import service.BaseballTeamService;
import service.logic.BaseballTeamServiceLogic;

@WebServlet("/teamDetail.do")
public class TeamDetailController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		BaseballTeamService service = new BaseballTeamServiceLogic();
		BaseballTeam team = service.findTeam(request.getParameter("teamId"));
		request.setAttribute("team", team);
		request.setAttribute("teamSize", team.getPlayers().size());
		request.getRequestDispatcher("teamDetail.jsp").forward(request, response);
	}

}
