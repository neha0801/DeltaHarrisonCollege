package servlet;

import java.io.IOException;
import java.util.Objects;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.HClassroom;
import model.HDepartment;
import db.DBClassroom;
import db.DBDepartment;

/**
 * Servlet implementation class EditDepartment
 */
@WebServlet("/EditDepartment")
public class EditDepartment extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EditDepartment() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		long departmentId = Long.parseLong(request.getParameter("departmentId"));
		HDepartment department = DBDepartment.getDepartment(departmentId);
		HttpSession session = request.getSession();
		session.setAttribute("departmentIdUpdate", departmentId);

		request.setAttribute("department", department);
		getServletContext().getRequestDispatcher("/EditDepartment.jsp").forward(
				request, response);
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String departmentName = request.getParameter("departmentName");
		

		String errorMessage = "";

		HttpSession session = request.getSession();
		String departmentId = Objects.toString(session.getAttribute("departmentIdUpdate"));
System.out.println(departmentId);
		if (departmentId != null) {
			long departmentIdLong = Long.parseLong(departmentId);
			HDepartment department = DBDepartment.getDepartment(departmentIdLong);
			if (departmentName != null) {
				department.setName(departmentName);
				DBDepartment.update(department);
				
			} else {
				errorMessage = "No grade is selected!!";
				request.setAttribute("errorMessage", errorMessage);
				getServletContext().getRequestDispatcher("EditDepartment.jsp")
						.forward(request, response);
			}
			errorMessage = "Department Updated";
			request.setAttribute("errorMessage", errorMessage);
			getServletContext().getRequestDispatcher("/AdminDepartment")
			.forward(request, response);
	}

	}
}
