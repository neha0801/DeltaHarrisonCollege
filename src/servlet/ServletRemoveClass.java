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
import model.HClassroom;
import model.HCourse;
import model.HMajor;
import model.HSemester;
import model.HStaffDetail;
import model.HUser;
import db.DBClass;
import db.DBClassroom;
import db.DBCourse;
import db.DBMajor;
import db.DBSemester;
import db.DBStaffDetail;
import db.DBUserDetail;

/**
 * Servlet implementation class ServletRemoveClass
 */
@WebServlet("/RemoveClass")
public class ServletRemoveClass extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletRemoveClass() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String action = request.getParameter("action");
		System.out.println("doget of remove class :" + action);
		if(action.equalsIgnoreCase("load")){
			List<HClass> classes= new ArrayList<HClass>();
			classes = DBClass.getAdminClasses();
			request.setAttribute("classes", classes);
			getServletContext().getRequestDispatcher("/RemoveClass.jsp").forward(request, response);
		} 
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("dopost of remove class");
		String classIdStr= request.getParameter("classId");
		if(classIdStr!=null){
			long classId = Long.parseLong(classIdStr);
			HClass classObj = DBClass.getClass(classId);
			classObj.setStatus("INACTIVE");
			DBClass.update(classObj);
			String goodMessage = classObj.getHCourse().getName() + " Deleted!!";
			request.setAttribute("goodMessage", goodMessage);
			doGet(request,response);
		}else{
			String errorMessage = "Error Occured!!";
			request.setAttribute("errorMessage", errorMessage);
			doGet(request,response);
		}
	}

}
