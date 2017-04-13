package lecture.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import lecture.domain.Lecture;
import lecture.service.LectureService;
import lecture.service.LectureServiceLogic;

@WebServlet("/modify.do")
public class ModifyController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private LectureService service;
	
	public ModifyController() {
		service = new LectureServiceLogic();
	}

	protected void doGet(HttpServletRequest req, HttpServletResponse resp) 
			throws ServletException, IOException {
		String id = req.getParameter("id");
		Lecture lec = service.find(id);
		req.setAttribute("lecture", lec);
		req.getRequestDispatcher("modify.jsp").forward(req, resp);
	}

	protected void doPost(HttpServletRequest req, HttpServletResponse resp) 
			throws ServletException, IOException {
		Lecture lec = new Lecture();
		lec.setId(req.getParameter("lectureId"));
		lec.setLectureName(req.getParameter("lectureName"));
		lec.setInstructor(req.getParameter("instructorName"));
		lec.setIntroduce(req.getParameter("lectureIntroduce"));
		
		service.modify(lec);
		resp.sendRedirect("list.do");
		
	}

}





























