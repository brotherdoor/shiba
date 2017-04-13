package hr.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import hr.domain.Employee;
import hr.service.HumanResourceService;
import hr.service.logic.HumanResourceServiceLogic;

@WebServlet("/employee/create.do")
public class EmpCreateController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) 
			throws ServletException, IOException {
		String deptNo = (String)req.getParameter("deptNo");
		req.setAttribute("deptNo", deptNo);
		req.getRequestDispatcher("/views/empCreate.jsp").forward(req, resp);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		HumanResourceService service = new HumanResourceServiceLogic();
		Employee emp = new Employee(request.getParameter("empNo"), request.getParameter("empName"), request.getParameter("deptNo"));
		service.registEmployee(emp);
		response.sendRedirect(request.getContextPath() + "/employee/list.do");
	}

}
