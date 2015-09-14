package servlet;

import java.io.IOException;
import java.util.List;
import java.util.Random;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import db.DBMajor;
import db.DBUserDetail;
import model.HStudentDetail;
import model.HUser;
import model.HMajor;

/**
 * Servlet implementation class ServletRegisterUser
 */
@WebServlet("/RegisterUser")
public class ServletRegisterUser extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletRegisterUser() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		List<HMajor> majors = DBMajor.getMajors();
		for(HMajor m : majors){
			System.out.println("Major: " +m.getName());
		}
		request.setAttribute("majors", majors);
		getServletContext().getRequestDispatcher("/RegisterUser.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("dopost");
		String firstName = request.getParameter("firstName");
		String lastName = request.getParameter("lastName");
		String email = request.getParameter("email");
		String userName = request.getParameter("userName");
		String password = request.getParameter("password");
		String majorIdStr = request.getParameter("item.majorId");
		long majorId = Long.parseLong(majorIdStr);
		//set default userRole 
		//String userRole = "1";
	
		HUser user = new HUser();
		user.setFirstName(firstName);
		user.setLastName(lastName);
		user.setEmail(email);
		user.setUserName(userName);
		user.setPassword(password);
		
		
		if (DBUserDetail.isAvailable(user))
		{
			DBUserDetail.insert(user);
			request.setAttribute("goodMessage", "Congratz! Account created");
			HMajor major = DBMajor.getMajor(majorId);
			HStudentDetail student = new HStudentDetail();
			Random r = new Random();
			String studentNumber = String.valueOf(100000+r.nextInt(899999));
			getServletContext().getRequestDispatcher("/LoginForm.jsp").forward(request, response);
		}
		
		else
		{
			request.setAttribute("errorMessage", "Error! Username and Email have already taken");
			getServletContext().getRequestDispatcher("/RegisterUser.jsp").forward(request, response);
		}	
		

	}

}
