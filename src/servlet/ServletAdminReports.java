package servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.HClass;
import model.HCourse;
import model.HEnrollment;
import model.HStaffDetail;
import model.HUser;
import db.DBClass;
import db.DBCourse;
import db.DBEnrollment;
import db.DBStaffDetail;
import db.DBUserDetail;

/**
 * Servlet implementation class ServletAdminReports
 */
@WebServlet("/AdminReports")
public class ServletAdminReports extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletAdminReports() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String reportType = request.getParameter("ReportType");
		System.out.println(reportType);
		if(reportType.equalsIgnoreCase("ByInstructor")){
			request.setAttribute("reportType", "ByInstructor");
			List<HUser> users = DBUserDetail.getAllUser();
			List<HUser> instructors= new ArrayList<HUser>();
			for(HUser u : users){
				if(u.isInstructor()){
					instructors.add(u);
				}
			}

			request.setAttribute("instructors", instructors);
			
			getServletContext().getRequestDispatcher("/AdminReportSelection.jsp").forward(request, response);
		} else if (reportType.equalsIgnoreCase("ByClass")){
			request.setAttribute("reportType", "ByClass");
			List<HCourse> courseList = DBCourse.getAllCourses();
			
			request.setAttribute("courseList", courseList);
			
			getServletContext().getRequestDispatcher("/AdminReportSelection.jsp").forward(request, response);
		}
	}
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String instructorIdStr = request.getParameter("instructor");
		String courseIdStr = request.getParameter("courseList");
		System.out.println("Do Post of admin report");
		if(instructorIdStr!=null){
			long instructorId = Long.parseLong(instructorIdStr);
			System.out.println(instructorId);
			List<HClass> classList = DBClass.getInstructorClasses(DBStaffDetail.getUser(instructorId));
			List<HUser> userList = new ArrayList<HUser>();
			for(HClass c : classList){
				//list of enrollment
				List<HEnrollment> enrollList = new ArrayList<HEnrollment>();
				enrollList = DBEnrollment.getEnrollmentByClass(c);
				// for each to get each student
				for(HEnrollment e : enrollList){
					HUser user = new HUser();
					user = DBUserDetail.getUser(e.getHStudentDetail().getUserId());
					userList.add(user);
				}
				
			}
			request.setAttribute("reportType", "ByInstructor");
			request.setAttribute("userList", userList);
			getServletContext().getRequestDispatcher("/AdminReport.jsp").forward(request, response);		
 		} else if(courseIdStr!=null){
 			System.out.println("report by class");
 			long courseId = Long.parseLong(courseIdStr);
 			System.out.println("selected class " + courseId);
 			HCourse course = DBCourse.getSelectedCourse(courseId);
 			System.out.println("course object " + course);
 			List<HStaffDetail> instructorList = DBStaffDetail.getInstructorByCourse(course); 	
 			request.setAttribute("reportType", "ByClass");
			request.setAttribute("instructorList", instructorList);
			getServletContext().getRequestDispatcher("/AdminReport.jsp").forward(request, response);
 		}
	}

}
