package servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.HClass;
import model.HEnrollment;
import model.HSemester;
import model.HStaffDetail;
import model.HUser;
import db.DBClass;
import db.DBEnrollment;
import db.DBSemester;
import db.DBStaffDetail;

/**
 * Servlet implementation class ServletInstructorRoster
 */
@WebServlet("/InstructorRoster")
public class ServletInstructorRoster extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletInstructorRoster() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		// String action
		String action = request.getParameter("action");
		System.out.println(action);
		if(action==null){
			action="";
		}
		String backAction = String.valueOf(request.getAttribute("action"));
		System.out.println(backAction);
		System.out.println("do get of instructor roster");
		if (action.equalsIgnoreCase("getAll") || backAction.equalsIgnoreCase("getAll"))
		{
			
			HttpSession session = request.getSession(true);		
			HUser user = (HUser) session.getAttribute("user");	
			HStaffDetail instructor = DBStaffDetail.getUser(user.getUserId());
			List<HClass> classes=DBClass.getInstructorClasses(instructor);
			//List<HSemester> semesters=DBSemester.getAllSemester();
			request.setAttribute("classes", classes);
			//request.setAttribute("semesters", semesters);
			getServletContext().getRequestDispatcher("/InstructorRoster.jsp").forward(request, response);
		}
		else if (action.equalsIgnoreCase("getOne"))
		{
			System.out.println("do get of instructor roster, getone");
			String classIdStr = request.getParameter("classId");
			if(classIdStr!=null){
				long classId = Long.parseLong(classIdStr);
				HClass classObj = DBClass.getClass(classId);
				List<HEnrollment> enrolledList = DBEnrollment.getEnrollmentByClass(classObj);
				request.setAttribute("enrolledList", enrolledList);
				getServletContext().getRequestDispatcher("/ViewStudents.jsp").forward(request, response);
			}
		}

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

			System.out.println("do post of instructor roster");
			doGet(request,response);
	}

}
