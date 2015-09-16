package servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.HCourse;
import model.HMajor;
import db.DBCourse;
import db.DBMajor;

/**
 * Servlet implementation class ServletAddClass
 */
@WebServlet("/AddClass")
public class ServletAddClass extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletAddClass() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String action = request.getParameter("action");
		if(action.equalsIgnoreCase("add")){
			List<HMajor> majors= DBMajor.getMajors();
			request.setAttribute("majors", majors);
			List<HCourse> courses= DBCourse.getCourses();
			request.setAttribute("courses", courses);
			//List<HStaffDetail> staff 
			getServletContext().getRequestDispatcher("/AddClass.jsp").forward(request, response);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
