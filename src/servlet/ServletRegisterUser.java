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
import db.DBRole;
import db.DBStudentDetail;
import db.DBUserDetail;
import db.DBUserRole;
import model.HRole;
import model.HStudentDetail;
import model.HUser;
import model.HMajor;
import model.HUserRole;

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
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		String action = request.getParameter("action");
		if(action.equalsIgnoreCase("load"))
		{
			List<HMajor> majors = DBMajor.getMajors();
			for (HMajor m : majors) {
				System.out.println("Major: " + m.getName());
			}
			request.setAttribute("majors", majors);
			getServletContext().getRequestDispatcher("/RegisterUser.jsp").forward(
					request, response);
		}
		else
		{
			response.sendError(400,"Invalid Request");
		}

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		System.out.println("dopost");
		String firstName = request.getParameter("firstName");
		String lastName = request.getParameter("lastName");
		String email = request.getParameter("email");
		String userName = request.getParameter("userName");
		String password = request.getParameter("password");
		String majorIdStr = request.getParameter("major");
		System.out.println(majorIdStr);
		long majorId = Long.parseLong(majorIdStr);
		// set default userRole
		// String userRole = "1";

		HUser user = new HUser();
		user.setFirstName(firstName);
		user.setLastName(lastName);
		user.setEmail(email);
		user.setUserName(userName);
		user.setPassword(password);
		

		if (DBUserDetail.isAvailable(user)) {
			DBUserDetail.insert(user);
			request.setAttribute("goodMessage", "Congratz! Account created");
			user = DBUserDetail.getSingleUser(userName);
			System.out.println("user email " + user.getEmail());
			createStudent(user, majorId);
			assignRole(user);
			getServletContext().getRequestDispatcher("/LoginForm.jsp").forward(
					request, response);
		}

		else {
			request.setAttribute("errorMessage",
					"Error! Username and Email have already taken");
			getServletContext().getRequestDispatcher("/RegisterUser.jsp")
					.forward(request, response);
		}

	}

	private void createStudent(HUser user, long majorId) {
		HMajor major = DBMajor.getMajor(majorId);
		HStudentDetail student = new HStudentDetail();
		Random r = new Random();
		String studentNumber = String.valueOf(100000 + r.nextInt(899999));

		while (!DBStudentDetail.isAvailable(studentNumber)) {
			studentNumber = String.valueOf(100000 + r.nextInt(899999));
		}
		System.out.println("user ID " + user.getUserId());
		student.setUserId(user.getUserId());
		
		student.setHMajor(major);
		student.setStudentNumber(studentNumber);
		student.setEntryYear("2015");
		
		DBStudentDetail.insert(student);
	}

	private void assignRole(HUser user) {		
		HUserRole userRole = new HUserRole();
		
		userRole.setHUser(user);
		userRole.setStatus("Active");
		HRole role = DBRole.getRole(2);
		System.out.println("Role " + role.getName());
		userRole.setHRole(role);
		DBUserRole.insert(userRole);
	}
	
}
