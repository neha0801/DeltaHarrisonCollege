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
		String message="";
		String goodMessage="";
		String transcriptType=request.getParameter("type");
		HttpSession session = request.getSession(true);		
		HUser user = (HUser) session.getAttribute("user");
		HStudentDetail student=null;
		if(user.isAdvisor()){
		String studentNumber=request.getParameter("student");
		student=DBStudentDetail.getStudentDetail(studentNumber);
					
		}
		else{
		student=DBStudentDetail.getStudentDetail(user.getUserId());
		}
		message+="<h4>Student Name:"+student.getHUser().getFirstName()+" "+student.getHUser().getLastName()+"</h4>";
		message+="Student Number: "+student.getStudentNumber()+"<br>"+
				"Major: "+student.getHMajor().getName()+"<br>"+
				"Entry Year: "+student.getEntryYear()+"<br>";	
		List<HEnrollment>enrollments=student.getHEnrollments();
		String gpa=student.getOverallGPA();	
		request.setAttribute("message", message);
		request.setAttribute("currentTranscript", enrollments);	
		request.setAttribute("gpa",gpa );	
		if(transcriptType.equalsIgnoreCase("Unofficial")){
		getServletContext().getRequestDispatcher("/Transcript.jsp").forward(request, response);
		}
		else{
			request.setAttribute("message1", "Thank you for the payment.<br>Your Official Transcript as below has been processed.<br>Will be mailed to you shortly. " );
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
