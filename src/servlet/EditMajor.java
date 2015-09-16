package servlet;

import java.io.IOException;
import java.util.Objects;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.HDepartment;
import model.HMajor;
import db.DBDepartment;
import db.DBMajor;

/**
 * Servlet implementation class EditMajor
 */
@WebServlet("/EditMajor")
public class EditMajor extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EditMajor() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		long majorId = Long.parseLong(request.getParameter("majorId"));
		HMajor major = DBMajor.getMajor(majorId);
		HttpSession session = request.getSession();
		session.setAttribute("majorIdUpdate", majorId);

		request.setAttribute("major", major);
		getServletContext().getRequestDispatcher("/EditMajor.jsp").forward(
				request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
String majorName = request.getParameter("majorName");
		

		String errorMessage = "";

		HttpSession session = request.getSession();
		String majorId = Objects.toString(session.getAttribute("majorIdUpdate"));
System.out.println(majorId);
		if (majorId != null) {
			long majorIdLong = Long.parseLong(majorId);
			HMajor major = DBMajor.getMajor(majorIdLong);
			if (majorName != null) {
				major.setName(majorName);
				DBMajor.update(major);
				
			} else {
				errorMessage = "No grade is selected!!";
				request.setAttribute("errorMessage", errorMessage);
				getServletContext().getRequestDispatcher("EditDepartment.jsp")
						.forward(request, response);
			}
			errorMessage = "Major Updated";
			request.setAttribute("errorMessage", errorMessage);
			getServletContext().getRequestDispatcher("/AdminMajor")
			.forward(request, response);
	}

	}

}
