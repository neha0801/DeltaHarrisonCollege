package servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import db.DBClass;
import db.DBEnrollment;
import model.HClass;
import model.HEnrollment;
import model.HUser;

/**
 * Servlet implementation class Enroll
 */
@WebServlet("/Enroll")
public class Enroll extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Enroll() {
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
		// TODO Auto-generated method stub		
		HttpSession session = request.getSession(true);		
		HUser user=(HUser) session.getAttribute("user");		
		int newClassId=Integer.parseInt(request.getParameter("classId"));
		HEnrollment enrollment=new HEnrollment();
		enrollment.setStatus("Enrolled");
		enrollment.setHStudentDetail(user.getHStudentDetail());
		enrollment.setHClass(DBClass.getClass(newClassId));
		DBEnrollment.insert(enrollment);
		getServletContext().getRequestDispatcher("/CurrentSchedule").forward(request, response);
	}

}
