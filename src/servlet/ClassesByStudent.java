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
import model.HStudentDetail;
import model.HUser;
import db.DBClass;
import db.DBStaffDetail;
import db.DBStudentDetail;
import db.DBUserDetail;

/**
 * Servlet implementation class ClassesByStudent
 */
@WebServlet("/ClassesByStudent")
public class ClassesByStudent extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ClassesByStudent() {
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
			HUser student = DBUserDetail.getSingleUser(name);
			request.setAttribute("student", student);
		}
		else{
			request.setAttribute("errorMessage", "You are not an Admin");
			
		}
		getServletContext().getRequestDispatcher("/ClassesByStudent.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
