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

@WebServlet("/register.do")
public class registerController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest req, HttpServletResponse resp) 
			throws ServletException, IOException {

	}

	protected void doPost(HttpServletRequest req, HttpServletResponse resp) 
			throws ServletException, IOException {
		String lectureName = req.getParameter("lectureName");
		String instructorName = req.getParameter("instructorName");
		String lectureIntroduce = req.getParameter("lectureIntroduce");
		
		Lecture lecture = new Lecture(lectureName, instructorName, lectureIntroduce);
		
		LectureService service = new LectureServiceLogic();
		
		boolean result = service.register(lecture);
		System.out.println(result);
		resp.sendRedirect("list.do");
	}

}

















