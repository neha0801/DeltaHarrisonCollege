package servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.HDepartment;
import model.HMajor;
import db.DBDepartment;
import db.DBMajor;

/**
 * Servlet implementation class MajorSearch
 */
@WebServlet("/MajorSearch")
public class MajorSearch extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MajorSearch() {
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
		getServletContext().getRequestDispatcher("/MajorSearchForm.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		String departmentId = request.getParameter("department");
		List<HMajor> majors =DBMajor.searchforMajor(departmentId);
		request.setAttribute("majors", majors);
		List<HDepartment> departments = DBDepartment.getAllActiveDepartment();		
		request.setAttribute("departments", departments);
		getServletContext().getRequestDispatcher("/MajorSearchForm.jsp").forward(request, response);
	}

}
