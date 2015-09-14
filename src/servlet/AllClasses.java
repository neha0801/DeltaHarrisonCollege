package servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.HClass;
import model.HSemester;
import db.DBClass;
import db.DBSemester;

/**
 * Servlet implementation class Enroll
 */
@WebServlet("/AllClasses")
public class AllClasses extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AllClasses() {
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
				HSemester currentSemester=DBSemester.getCurrentSemester();
				List<HClass> currentClasses = DBClass.getAllClasses(currentSemester);
	
				request.setAttribute("currentClasses", currentClasses);		
				getServletContext().getRequestDispatcher("/AllClasses.jsp").forward(request, response);
			}
			
			catch(Exception e)
			{				
				e.printStackTrace();
			}
		
		//get all classes for particular semester and pass it to jsp
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		//get data
		
		//insert enrollment
	}

}
