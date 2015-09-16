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
import db.DBDepartment;
import model.HCourse;
import model.HDepartment;

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
		List<HDepartment> departments = DBDepartment.getAllDepartments();
		request.setAttribute("departments", departments);
		getServletContext().getRequestDispatcher("/AddCourse.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String courseNumber = request.getParameter("courseNumber");
		String courseName = request.getParameter("courseName");
		String courseDescription = request.getParameter("courseDescription");
		String courseDepartment = request.getParameter("courseDepartment");
		
		int courseCredits = Integer.parseInt(request.getParameter("courseCredits"));
		
		model.HCourse course = new HCourse();
		course.setCourseNumber(courseNumber);
		course.setName(courseName);
		course.setDescription(courseDescription);
		course.setCredits(courseCredits);
		
		DBCourse.insertCourse(course);
		String errorMessage = "Course Added";
		request.setAttribute("errorMessage", errorMessage);
		getServletContext().getRequestDispatcher("/AdminCourse")
		.forward(request, response);
		
	}

}
