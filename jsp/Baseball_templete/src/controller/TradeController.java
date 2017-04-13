package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import service.BaseballTeamService;
import service.logic.BaseballTeamServiceLogic;

@WebServlet("/trade.do")
public class TradeController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) 
			throws ServletException, IOException {
		BaseballTeamService service = new BaseballTeamServiceLogic();
		System.out.println(req.getParameter("targetPlayer"));
		System.out.println(req.getParameter("source"));
		service.tradePlayer(req.getParameter("source"), req.getParameter("targetPlayer"));
		resp.sendRedirect("playerList.do");
	}

}
