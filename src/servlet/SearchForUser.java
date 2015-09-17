package servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import db.DBUserDetail;
import model.HUser;

/**
 * Servlet implementation class SearchForUser
 */
@WebServlet("/SearchForUser")
public class SearchForUser extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SearchForUser() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//get user from session
		//check if admin
		HttpSession session=request.getSession();
		HUser user=(HUser) session.getAttribute("user");
		if(user.isAdmin()){
			String name=request.getParameter("userName");
			List<HUser>users=DBUserDetail.getUsersForAdmin(name);
			request.setAttribute("users", users);
		}
		else{
			request.setAttribute("errorMessage", "You are not an Admin");
			
		}
		getServletContext().getRequestDispatcher("/SearchForUser.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
