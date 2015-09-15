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
 * Servlet implementation class ServletEditUser
 */
@WebServlet("/EditUser")
public class ServletEditUser extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletEditUser() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("doget of EditUser");
		HttpSession session = request.getSession();
		HUser user = (HUser) session.getAttribute("user");
		request.setAttribute("firstName", user.getFirstName());
		request.setAttribute("lastName", user.getLastName());
		request.setAttribute("email", user.getEmail());
		request.setAttribute("userName", user.getUserName());
		request.setAttribute("password", user.getPassword());
		getServletContext().getRequestDispatcher("/EditUser.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("do post of EditUser");
		HttpSession session = request.getSession();
		HUser user = (HUser) session.getAttribute("user");
		
		
		String firstName = request.getParameter("firstName");
		String lastName = request.getParameter("lastName");
		String email = request.getParameter("email");
		String userName = request.getParameter("userName");
		String password = request.getParameter("password");

		user.setEmail(email);
		user.setFirstName(firstName);
		user.setLastName(lastName);
		user.setUserName(userName);
		user.setPassword(password);
		
		DBUserDetail.update(user);
		session.setAttribute("user", user);
		request.setAttribute("goodMessage", "Congratz! Account updated");
		doGet(request,response);
	}

}
