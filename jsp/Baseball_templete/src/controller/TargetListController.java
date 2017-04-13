package controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import domain.BaseballTeam;
import domain.Player;
import service.BaseballTeamService;
import service.logic.BaseballTeamServiceLogic;

@WebServlet("/tradeTargetList.do")
public class TargetListController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		BaseballTeamService service = new BaseballTeamServiceLogic();
		Player player = service.findPlayer((String)request.getParameter("playerId"));
		request.setAttribute("sourcePlayer", player);
		List<BaseballTeam> list = service.findTradeTargetPalyers(player.getTeamId());
		request.setAttribute("teamList", list);
		request.getRequestDispatcher("tradeTargetList.jsp").forward(request, response);
	}

}