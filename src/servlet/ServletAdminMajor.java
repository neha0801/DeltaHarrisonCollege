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
import db.DBClassroom;
import db.DBDepartment;
import db.DBMajor;

/**
 * Servlet implementation class ServletAdminMajor
 */
@WebServlet("/AdminMajor")
public class ServletAdminMajor extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletAdminMajor() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<HMajor> majors = DBMajor.getAllMajors();
		List<HDepartment> departments = DBDepartment.getAllDepartments();
		request.setAttribute("departments", departments);
		request.setAttribute("majors", majors);
		getServletContext().getRequestDispatcher("/AdminMajorOptions.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request,response);
	}

}
