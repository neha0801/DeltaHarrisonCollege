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
import model.HUser;
import db.DBClass;
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
		}
	}
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String instructorIdStr = request.getParameter("instructor");
		System.out.println("Do Post of admin report");
		if(instructorIdStr!=null){
			long instructorId = Long.parseLong(instructorIdStr);
			System.out.println(instructorId);
			List<HClass> classList = DBClass.getInstructorClasses(DBStaffDetail.getUser(instructorId));
//			for(HClass c : classList){
//				HUser user = new HUser();
//				user = DBUserDetail.getUserByClass(classObj)
//			}
 		}
	}

}
