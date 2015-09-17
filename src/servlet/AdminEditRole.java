package servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.HRole;
import model.HUser;
import model.HUserRole;
import db.DBRole;
import db.DBUserDetail;
import db.DBUserRole;

/**
 * Servlet implementation class AdminEditRole
 */
@WebServlet("/AdminEditRole")
public class AdminEditRole extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AdminEditRole() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String userIdStr = request.getParameter("tempUserId");
		long userId=Long.parseLong(userIdStr);
		
		HUser tempUser = DBUserDetail.getUser(userId);
		


		request.setAttribute("tempUser", tempUser);
		getServletContext().getRequestDispatcher("/AdminEditRole.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String userIdStr = request.getParameter("tempUserId");
		long userId=Long.parseLong(userIdStr);
		HUser tempUser = DBUserDetail.getUser(userId);
		
		
		String newRole = request.getParameter("newRole");
		
		if (newRole.equals("1") || newRole.equals("2") || newRole.equals("3") || newRole.equals("4"))
		{
			Long newRoleLong = Long.parseLong(newRole);
			HRole newRoleObj = DBRole.getRole(newRoleLong);
			
			HUserRole userRole = new HUserRole();
			userRole.setHRole(newRoleObj);
			userRole.setHUser(tempUser);
			userRole.setStatus("Active");
			DBUserRole.insert(userRole);
			System.out.println("new role inserted");
		}
		
		List<HUserRole> currentRoles = tempUser.getHUserRoles();
		System.out.println("currentRoles size = " + currentRoles.size());
		for(HUserRole currentRole : currentRoles)
		{
			System.out.println("parameter name = " + "currentRole" + currentRole.getUserRoleId());
			String newStatus =  request.getParameter("currentRole" + currentRole.getUserRoleId());
			currentRole.setStatus(newStatus);
			DBUserRole.update(currentRole);
		}
	}

}
