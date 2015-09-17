package servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import db.DBUserDetail;
import model.HUser;

/**
 * Servlet implementation class ServletLogin
 */
@WebServlet("/Login")
public class ServletLogin extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletLogin() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("login post");
		
		String username = request.getParameter("userName");
		String password = request.getParameter("password");
		
		String errorMessage = "";
		System.out.println("username = " + username);
		System.out.println("password = " + password);
		HUser tempUser = new HUser();
		tempUser.setUserName(username);
		tempUser.setPassword(password);
		
		// get back a user id with a user name and password, if fail, return 0
		long userId = DBUserDetail.login(tempUser);
		System.out.println(userId);
		//if login success
		if (userId>0)
		{
			HUser user = DBUserDetail.getUser(userId);
			System.out.println(user.getUserId());
			HttpSession session = request.getSession();
			session.setAttribute("user", user);	
			System.out.println(user.getFirstName());
			if(user.isAdmin())
			{
				getServletContext().getRequestDispatcher("/AdminReportSelection.jsp").forward(request, response);
			}
			else if (user.isStudent())
			{
				getServletContext().getRequestDispatcher("/CurrentSchedule").forward(request, response);
			}
			else if (user.isAdvisor())
			{
				getServletContext().getRequestDispatcher("/CurrentSchedule").forward(request, response);
			}
			else if (user.isInstructor())
			{
				getServletContext().getRequestDispatcher("/InstructorRoster?action=getAll").forward(request, response);
			}
			else
			{
				getServletContext().getRequestDispatcher("/Logout").forward(request, response);
			}
			
		}
		//if login fail
		else
		{
			errorMessage="Login failed. Please try again!";
			request.setAttribute("errorMessage", errorMessage);
			getServletContext().getRequestDispatcher("/LoginForm.jsp").forward(request, response);
		}
	}

}
