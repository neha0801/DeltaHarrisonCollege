package servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.HClassroom;
import model.HDepartment;
import db.DBClassroom;
import db.DBDepartment;

/**
 * Servlet implementation class AddDepartment
 */
@WebServlet("/AddDepartment")
public class AddDepartment extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddDepartment() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String departmentName = request.getParameter("departmentName");
		String departmentStatus = request.getParameter("departmentStatus");
		model.HDepartment department = new HDepartment();
		department.setName(departmentName);
		department.setStatus(departmentStatus);
		DBDepartment.update(department);
		
		
		String errorMessage = "Department Added";
		request.setAttribute("errorMessage", errorMessage);
		getServletContext().getRequestDispatcher("/AdminDepartment")
		.forward(request, response);
	}

}
