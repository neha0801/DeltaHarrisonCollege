package servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.HClass;
import model.HCourse;
import model.HDepartment;
import db.DBClass;
import db.DBCourse;
import db.DBDepartment;

/**
 * Servlet implementation class CourseSearch
 */
@WebServlet("/CourseSearch")
public class CourseSearch extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CourseSearch() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		List<HDepartment> departments = DBDepartment.getAllActiveDepartment();		
		request.setAttribute("departments", departments);
		getServletContext().getRequestDispatcher("/CourseSearchForm.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		String departmentId = request.getParameter("department");
		List<HCourse> courses =DBCourse.searchforCourse(departmentId);
		request.setAttribute("courses", courses);
		List<HDepartment> departments = DBDepartment.getAllActiveDepartment();		
		request.setAttribute("departments", departments);
		getServletContext().getRequestDispatcher("/CourseSearchForm.jsp").forward(request, response);
	}

}
