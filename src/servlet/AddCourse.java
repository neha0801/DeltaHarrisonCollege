package servlet;


import java.io.IOException;
import java.util.List;
import java.util.Objects;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.sun.org.apache.bcel.internal.classfile.Code;

import db.DBCourse;
import db.DBMajor;
import db.DBSubject;
import model.HCourse;
import model.HMajor;
import model.HSubject;


/**
 * Servlet implementation class AddCourse
 */
@WebServlet("/AddCourse")
public class AddCourse extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddCourse() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<HMajor> majors = DBMajor.getAllMajors();
		request.setAttribute("majors", majors);
		List<HSubject> subjects = DBSubject.getAllSubjects();
		request.setAttribute("subjects", subjects);
		getServletContext().getRequestDispatcher("/AddCourse.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String courseNumber = request.getParameter("courseNumber");
		String courseName = request.getParameter("courseName");
		String courseDescription = request.getParameter("courseDescription");
		String courseMajorId = request.getParameter("courseMajor");
		String courseSubjectId = request.getParameter("courseSubject");
		String courseStatus = request.getParameter("courseStatus");
		 
		int courseCredits = Integer.parseInt(request.getParameter("courseCredits"));
	
		long courseMajorLong =  Long.parseLong(courseMajorId);
		long courseSubjectLong =  Long.parseLong(courseSubjectId);
		HMajor major = DBMajor.getMajor(courseMajorLong);
		HSubject subject = DBSubject.getSubject(courseSubjectLong);
		
		model.HCourse course = new HCourse();
		course.setCourseNumber(courseNumber);
		course.setName(courseName);
		course.setDescription(courseDescription);
		course.setCredits(courseCredits);
		course.setHMajor(major);
		course.setHSubject(subject);
		course.setStatus(courseStatus);
		DBCourse.insertCourse(course);
		String errorMessage = "Course Added";
		request.setAttribute("errorMessage", errorMessage);
		getServletContext().getRequestDispatcher("/AdminCourse")
		.forward(request, response);
		
	}

}
