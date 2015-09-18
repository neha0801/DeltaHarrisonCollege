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
import model.HDepartment;
import model.HEnrollment;
import model.HSemester;
import model.HStudentDetail;
import model.HUser;
import db.DBClass;
import db.DBDepartment;
import db.DBEnrollment;
import db.DBSemester;
import db.DBStudentDetail;

/**
 * Servlet implementation class OverrideEnrollment
 */
@WebServlet("/OverrideEnrollment")
public class OverrideEnrollment extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public OverrideEnrollment() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		HSemester currentSemester=DBSemester.getCurrentSemester();
		List<HClass> classes = DBClass.getAllClasses(currentSemester);		
		request.setAttribute("classes", classes);
		getServletContext().getRequestDispatcher("/AdminOverrideEnrollment.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession session=request.getSession();
		HUser user=(HUser) session.getAttribute("user");
		if(user.isAdmin() || user.isAdvisor() ){
			String studentNumber = request.getParameter("student");
			String classId = request.getParameter("class");
			HStudentDetail student=DBStudentDetail.getStudentDetail(studentNumber);
			HClass currentClass=DBClass.getClass(Long.parseLong(classId));
			if(currentClass.hasEnrolled(student.getUserId())){
				request.setAttribute("errorMessage", "Student Already Enrolled in this class!");	
			}
			else{
			HEnrollment enrollment=new HEnrollment();
			enrollment.setHClass(currentClass);
			enrollment.setHStudentDetail(student);
			enrollment.setStatus("Enrolled");
			DBEnrollment.insert(enrollment);
			request.setAttribute("goodMessage", "Student Successfully Enrolled");
			}
			HSemester currentSemester=DBSemester.getCurrentSemester();
			List<HClass> classes = DBClass.getAllClasses(currentSemester);		
			request.setAttribute("classes", classes);
			getServletContext().getRequestDispatcher("/AdminOverrideEnrollment.jsp").forward(request, response);
		}
		else{
			
		}
	}

}
