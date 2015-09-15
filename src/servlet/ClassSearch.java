package servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.HClass;
import model.HDepartment;
import model.HSubject;
import db.DBClass;
import db.DBDepartment;
import db.DBSubject;

/**
 * Servlet implementation class ClassSearch
 */
@WebServlet("/ClassSearch")
public class ClassSearch extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ClassSearch() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		//get active subject list
		List<HSubject> subjects = DBSubject.getAllActiveSubject();
		//get active department list
		List<HDepartment> departments = DBDepartment.getAllActiveDepartment();
		request.setAttribute("subjects", subjects);
		request.setAttribute("departments", departments);
		getServletContext().getRequestDispatcher("/ClassSearchForm.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String subjectId = request.getParameter("subject");
		String instructor = request.getParameter("instructor");
		String time = request.getParameter("time");
		String departmentId = request.getParameter("department");
		
		System.out.println("in post, values = " + subjectId + instructor + time + departmentId);
		List<HClass> classes = DBClass.searchClass(subjectId, instructor, time, departmentId);
		request.setAttribute("classes", classes);
		
		//get active subject list
		List<HSubject> subjects = DBSubject.getAllActiveSubject();
		//get active department list
		List<HDepartment> departments = DBDepartment.getAllActiveDepartment();
		request.setAttribute("subjects", subjects);
		request.setAttribute("departments", departments);
		
		getServletContext().getRequestDispatcher("/ClassSearchForm.jsp").forward(request, response);
		
		//get info from classsearchform.jsp
	}

}
