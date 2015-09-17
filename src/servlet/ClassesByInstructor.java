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
import model.HStaffDetail;
import model.HUser;
import db.DBClass;
import db.DBStaffDetail;
import db.DBUserDetail;

/**
 * Servlet implementation class ClassesByInstructor
 */
@WebServlet("/ClassesByInstructor")
public class ClassesByInstructor extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ClassesByInstructor() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession session=request.getSession();
		HUser user=(HUser) session.getAttribute("user");
		if(user.isAdmin()){
			String name=request.getParameter("userName");
			HUser user1=DBUserDetail.getSingleUser(name);
			System.out.println("Instructor ID="+user1.getUserId());
			HStaffDetail instructor=DBStaffDetail.getUser(user1.getUserId());
			List<HClass>classes=DBClass.getInstructorClassesAllSemesters(instructor);
			request.setAttribute("classes", classes);
		}
		else{
			request.setAttribute("errorMessage", "You are not an Admin");
			
		}
		getServletContext().getRequestDispatcher("/ClassesByInstructor.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
