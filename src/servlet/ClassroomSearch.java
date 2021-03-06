package servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.HClass;
import model.HClassroom;
import model.HCourse;
import model.HDepartment;
import model.HSubject;
import model.HUser;
import db.DBClass;
import db.DBClassroom;
import db.DBCourse;
import db.DBDepartment;
import db.DBSubject;

/**
 * Servlet implementation class ClassroomSearch
 */
@WebServlet("/ClassroomSearch")
public class ClassroomSearch extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ClassroomSearch() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		List<HCourse> courses = DBCourse.getAllCourses();		
		request.setAttribute("courses", courses);
		getServletContext().getRequestDispatcher("/AdminClassroomSearchForm.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession session=request.getSession();
		HUser user=(HUser) session.getAttribute("user");
		if(user.isAdmin()){
		String courseId = request.getParameter("course");
		String instructor = request.getParameter("instructor");		
		String studentNumber = request.getParameter("student");		
		List<HClassroom> classrooms = DBClassroom.searchClassroom(courseId, instructor, studentNumber);
		request.setAttribute("classrooms", classrooms);
		}
		else{
			request.setAttribute("errorMessage", "You are not an Admin");
		}
		
		List<HCourse> courses = DBCourse.getAllCourses();		
		request.setAttribute("courses", courses);
		getServletContext().getRequestDispatcher("/AdminClassroomSearchForm.jsp").forward(request, response);
	}

}
