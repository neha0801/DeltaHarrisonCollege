package servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.Servlet;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.HClass;
import model.HCourse;
import model.HDepartment;
import model.HSemester;
import model.HStaffDetail;
import model.HUser;
import db.DBClass;
import db.DBCourse;
import db.DBDepartment;
import db.DBSemester;
import db.DBUserDetail;

/**
 * Servlet implementation class ServletRevenue
 */
@WebServlet("/Revenue")
public class ServletRevenue extends HttpServlet implements Servlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletRevenue() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("do get of revenue");
		String action = request.getParameter("action");
		if(action.equalsIgnoreCase("load")){
			List<HSemester> semestersList = DBSemester.getAllSemester();
			request.setAttribute("semestersList", semestersList);
			getServletContext().getRequestDispatcher("/Revenue.jsp").forward(request, response);
		}else if(action.equalsIgnoreCase("ByDepartment")){
			revenueByDepartment(request,response);
		}else if(action.equalsIgnoreCase("ByInstructor")){
			revenueByInstructor(request,response);
		}else if(action.equalsIgnoreCase("ByCourse")){
			revenueByCourse(request,response);
		}else if(action.equalsIgnoreCase("ByClass")){
			revenueByClass(request,response);
		}
	}

	private void revenueByClass(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		List<HClass> classList = DBClass.getAdminClasses();
		request.setAttribute("classList", classList);
		getServletContext().getRequestDispatcher("/ShowRevenueByClasses.jsp").forward(request, response);
		
	}

	private void revenueByDepartment(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		
		String semesterId= request.getParameter("semesters");
		System.out.println(semesterId);
		request.setAttribute("semesterId",semesterId);
		List<HDepartment> deptList = DBDepartment.getAllActiveDepartment();
		request.setAttribute("list", deptList);
		request.setAttribute("criteria", "Departments");
		getServletContext().getRequestDispatcher("/ShowRevenueByDeptOrCourse.jsp").forward(request, response);
		
	}
	
	private void revenueByInstructor(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		
		String semesterId= request.getParameter("semesters");
		System.out.println(semesterId);
		request.setAttribute("semesterId",semesterId);
		
		List<HUser> instructorList = DBUserDetail.getAllInstructors();
		request.setAttribute("instructorList", instructorList);
		getServletContext().getRequestDispatcher("/ShowRevenueByInstructor.jsp").forward(request, response);
		
	}
	
	private void revenueByCourse(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		
		String semesterId= request.getParameter("semesters");
		System.out.println(semesterId);
		request.setAttribute("semesterId",semesterId);
		
		List<HCourse> courses = DBCourse.getAllCourses();
		request.setAttribute("list", courses);
		request.setAttribute("criteria", "Courses");
		getServletContext().getRequestDispatcher("/ShowRevenueByDeptOrCourse.jsp").forward(request, response);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

}
