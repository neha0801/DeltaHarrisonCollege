package servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.HClass;
import model.HCourse;
import model.HSemester;
import db.DBClass;
import db.DBCourse;
import db.DBSemester;

/**
 * Servlet implementation class AllCourses
 */
@WebServlet("/AllCourses")
public class AllCourses extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AllCourses() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		try
		{
		
			List<HCourse>allCourses =DBCourse.getAllCourses();

			request.setAttribute("allCourses", allCourses);		
			getServletContext().getRequestDispatcher("/AllCourses.jsp").forward(request, response);
		}
		
		catch(Exception e)
		{				
			e.printStackTrace();
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
