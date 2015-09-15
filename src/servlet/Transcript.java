package servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import db.DBEnrollment;
import db.DBStudentDetail;
import model.HEnrollment;
import model.HStudentDetail;
import model.HUser;

/**
 * Servlet implementation class Transcript
 */
@WebServlet("/Transcript")
public class Transcript extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Transcript() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String transcriptType=request.getParameter("type");
		HttpSession session = request.getSession(true);		
		HUser user = (HUser) session.getAttribute("user");
		HStudentDetail student=DBStudentDetail.getStudentDetail(user.getUserId());
		List<HEnrollment>enrollments=student.getHEnrollments();
		String gpa=student.getOverallGPA();
		
		request.setAttribute("currentTranscript", enrollments);	
		request.setAttribute("gpa",gpa );	
		if(transcriptType.equalsIgnoreCase("Unofficial")){
		getServletContext().getRequestDispatcher("/Transcript.jsp").forward(request, response);
		}
		else{
			getServletContext().getRequestDispatcher("/OfficialTranscript.jsp").forward(request, response);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
