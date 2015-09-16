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
import model.HCourse;
import db.DBClassroom;
import db.DBCourse;

/**
 * Servlet implementation class EditClassroom
 */
@WebServlet("/EditClassroom")
public class EditClassroom extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EditClassroom() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		long classroomId = Long.parseLong(request.getParameter("classroomId"));
		HClassroom classroom = DBClassroom.getClassroom(classroomId);
		HttpSession session = request.getSession();
		session.setAttribute("classroomIdUpdate", classroomId);

		request.setAttribute("classroom", classroom);
		getServletContext().getRequestDispatcher("/EditClassroom.jsp").forward(
				request, response);
		
		
		
		
	
		}
	
	

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String classroomName = request.getParameter("classroomName");
		String classroomNumber = request.getParameter("classroomNumber");
		String classroomMaxCapacity = request.getParameter("classroomMaxCapacity");
		

		String errorMessage = "";

		HttpSession session = request.getSession();
		String classroomId = Objects.toString(session.getAttribute("classroomIdUpdate"));

		if (classroomId != null) {
			long classroomIdLong = Long.parseLong(classroomId);
			HClassroom classroom = DBClassroom.getClassroom(classroomIdLong);
			if (classroomNumber != null) {
				classroom.setRoomNumber(classroomNumber);
				DBClassroom.update(classroom);
				
			} else {
				errorMessage = "No grade is selected!!";
				request.setAttribute("errorMessage", errorMessage);
				getServletContext().getRequestDispatcher("EditClassroom.jsp")
						.forward(request, response);
			}
			if (classroomName != null) {
				classroom.setBuildingName(classroomName);
				DBClassroom.update(classroom);
				
			} else {
				errorMessage = "No grade is selected!!";
				request.setAttribute("errorMessage", errorMessage);
				getServletContext().getRequestDispatcher("EditClassroom.jsp")
						.forward(request, response);
			}
			if (classroomMaxCapacity != null) {
				int classroomMaxCapacityInt = Integer.parseInt(classroomMaxCapacity);
				classroom.setMaxCapacity(classroomMaxCapacityInt);
				DBClassroom.update(classroom);
				
			} else {
				errorMessage = "No grade is selected!!";
				request.setAttribute("errorMessage", errorMessage);
				getServletContext().getRequestDispatcher("EditClassroom.jsp")
						.forward(request, response);
			}
			errorMessage = "Classroom Updated";
			request.setAttribute("errorMessage", errorMessage);
			getServletContext().getRequestDispatcher("/AdminClassroom")
			.forward(request, response);
	}
		}
	}

