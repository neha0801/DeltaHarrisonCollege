package servlet;

import java.io.IOException;
import java.util.Objects;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.HCourse;
import model.HUser;
import db.DBCourse;
import db.DBUserDetail;

/**
 * Servlet implementation class EditCourse
 */
@WebServlet("/EditCourse")
public class EditCourse extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public EditCourse() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		long courseId = Long.parseLong(request.getParameter("courseId"));
		HCourse course = DBCourse.getCourse(courseId);
		HttpSession session = request.getSession();
		session.setAttribute("courseIdUpdate", courseId);

		request.setAttribute("course", course);
		getServletContext().getRequestDispatcher("/EditCourse.jsp").forward(
				request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		String courseNumber = request.getParameter("courseNumber");
		String courseName = request.getParameter("courseName");
		String description = request.getParameter("courseDescription");
		String credits = request.getParameter("courseCredits");

		String errorMessage = "";

		HttpSession session = request.getSession();
		String courseId = Objects.toString(session.getAttribute("courseIdUpdate"));

		if (courseId != null) {
			long courseIdLong = Long.parseLong(courseId);
			HCourse course = DBCourse.getCourse(courseIdLong);
			if (courseNumber != null) {
				course.setCourseNumber(courseNumber);
				DBCourse.update(course);
				
			} else {
				errorMessage = "No grade is selected!!";
				request.setAttribute("errorMessage", errorMessage);
				getServletContext().getRequestDispatcher("EditCourse.jsp")
						.forward(request, response);
			}
			if (courseName != null) {
				course.setName(courseName);
				DBCourse.update(course);
				
			
			} else {
				errorMessage = "No grade is selected!!";
				request.setAttribute("errorMessage", errorMessage);
				getServletContext().getRequestDispatcher("EditCourse.jsp")
						.forward(request, response);
			}
			if (description != null) {
				course.setDescription(description);
				DBCourse.update(course);
				
			
			} else {
				errorMessage = "No grade is selected!!";
				request.setAttribute("errorMessage", errorMessage);
				getServletContext().getRequestDispatcher("EditCourse.jsp")
						.forward(request, response);
			}
			if (credits != null) {
				int creditsInt = Integer.parseInt(credits);
				course.setCredits(creditsInt);
				DBCourse.update(course);
				
		
			
			} else {
				errorMessage = "No grade is selected!!";
				request.setAttribute("errorMessage", errorMessage);
				getServletContext().getRequestDispatcher("EditCourse.jsp")
						.forward(request, response);
			}
			errorMessage = "Course Updated";
			request.setAttribute("errorMessage", errorMessage);
			getServletContext().getRequestDispatcher("/AdminCourse")
			.forward(request, response);
		}
	}

}
