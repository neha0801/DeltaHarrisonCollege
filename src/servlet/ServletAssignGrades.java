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
import model.HEnrollment;
import model.HStaffDetail;
import model.HUser;
import db.DBClass;
import db.DBEnrollment;
import db.DBStaffDetail;

/**
 * Servlet implementation class ServletAssignGrades
 */
@WebServlet("/AssignGrades")
public class ServletAssignGrades extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletAssignGrades() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String enrollmentIdStr = request.getParameter("enrollmentId");
		if(enrollmentIdStr!=null){
			request.setAttribute("enrollmentId", enrollmentIdStr);
			getServletContext().getRequestDispatcher("/Grades.jsp").forward(request, response);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("doPost of assign grades");
		String enrollmentIdStr = request.getParameter("enrollmentId");
		String grade = request.getParameter("grade");
		String errorMessage="";
		if(enrollmentIdStr!=null){
		long enrollmentId = Long.parseLong(enrollmentIdStr);
		HEnrollment enroll = DBEnrollment.getEnrollemnt(enrollmentId);
		if(grade!=null){
			enroll.setGrade(grade);
			DBEnrollment.update(enroll);
			errorMessage = "Congratz!! Grade Updated.";
			request.setAttribute("errorMessage", errorMessage);
			request.setAttribute("action", "getAll");
			getServletContext().getRequestDispatcher("/InstructorRoster").forward(request, response);
		}else
		{
			errorMessage="No grade is selected!!";
			request.setAttribute("errorMessage", errorMessage);
			getServletContext().getRequestDispatcher("/Grades.jsp").forward(request, response);
		}
	
		}
	}

}
