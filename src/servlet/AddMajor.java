package servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.HClassroom;
import model.HDepartment;
import model.HMajor;
import model.HDepartment;
import db.DBClassroom;
import db.DBDepartment;
import db.DBMajor;
import db.DBDepartment;

/**
 * Servlet implementation class AddMajor
 */
@WebServlet("/AddMajor")
public class AddMajor extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddMajor() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		List<HDepartment> departments = DBDepartment.getAllDepartments();
		request.setAttribute("departments", departments);
		getServletContext().getRequestDispatcher("/AddMajor.jsp")
		.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String majorName = request.getParameter("majorName");
		String majorDepartment = request.getParameter("majorDepartment");
		String majorStatus = request.getParameter("majorStatus");
		long majorDepartmentLong = Long.parseLong(majorDepartment);
		
		HDepartment department = DBDepartment.getDepartment(majorDepartmentLong);
		
		
		model.HMajor major = new HMajor();
		major.setName(majorName);
		major.setHDepartment(department);
		major.setStatus(majorStatus);
		DBMajor.update(major);
	
		String errorMessage = "Major Added";
		request.setAttribute("errorMessage", errorMessage);
		getServletContext().getRequestDispatcher("/AdminMajor")
		.forward(request, response);
	}

}
