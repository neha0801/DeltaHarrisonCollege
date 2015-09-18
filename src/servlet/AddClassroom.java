package servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.HClassroom;
import model.HCourse;
import model.HMajor;
import model.HSubject;
import db.DBClassroom;
import db.DBCourse;
import db.DBMajor;
import db.DBSubject;

/**
 * Servlet implementation class AddClassroom
 */
@WebServlet("/AddClassroom")
public class AddClassroom extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddClassroom() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String classroomName = request.getParameter("classroomName");
		String classroomNumber = request.getParameter("classroomNumber");
		String classroomMaxCapacity = request.getParameter("classroomMaxCapacity");
		String classroomStatus = request.getParameter("classroomStatus");
		
	int maxcap =Integer.parseInt(classroomMaxCapacity);
	
		
		model.HClassroom classroom = new HClassroom();
		classroom.setBuildingName(classroomName);
		classroom.setRoomNumber(classroomNumber);
		classroom.setMaxCapacity(maxcap);
		classroom.setStatus(classroomStatus);
		
		DBClassroom.update(classroom);
		String errorMessage = "Classroom Added";
		request.setAttribute("errorMessage", errorMessage);
		getServletContext().getRequestDispatcher("/AdminClassroom")
		.forward(request, response);
	}

}
