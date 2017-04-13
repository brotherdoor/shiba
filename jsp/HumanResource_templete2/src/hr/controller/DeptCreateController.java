package hr.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import hr.domain.Department;
import hr.service.HumanResourceService;
import hr.service.logic.HumanResourceServiceLogic;

@WebServlet("/dept/create.do")
public class DeptCreateController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		HttpSession session = request.getSession();
		String loginId = (String) session.getAttribute("loginId");
		if(!"admin".equals(loginId)){
			throw new RuntimeException("�μ���� ������ �����ϴ�.");
		}
		String deptNo = request.getParameter("deptNo");
		String deptName = request.getParameter("deptName");
		Department dept = new Department(deptNo, deptName);
		HumanResourceService service = new HumanResourceServiceLogic();
		service.registeDepartment(dept);
		response.sendRedirect(request.getContextPath() + "/dept/list.do");
	}

}