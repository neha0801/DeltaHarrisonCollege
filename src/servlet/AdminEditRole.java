package servlet;

import java.io.IOException;
import java.util.List;
import java.util.Random;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.HRole;
import model.HStaffDetail;
import model.HStudentDetail;
import model.HUser;
import model.HUserRole;
import db.DBRole;
import db.DBStaffDetail;
import db.DBStudentDetail;
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
			if(newRole.equals("2"))
			{
				HStudentDetail student = new HStudentDetail();
				
				Random r = new Random();
				String studentNumber = String.valueOf(100000 + r.nextInt(899999));

				while (!DBStudentDetail.isAvailable(studentNumber)) {
					studentNumber = String.valueOf(100000 + r.nextInt(899999));
				}
				System.out.println("user ID " + tempUser.getUserId());
				student.setUserId(tempUser.getUserId());
				student.setStudentNumber(studentNumber);
				student.setEntryYear("2015");
				
				DBStudentDetail.insert(student);
			}
			else if (tempUser.isAdmin() || tempUser.isAdvisor() || tempUser.isInstructor())
			{
				//do nothing
			}
			else
			{
					HStaffDetail staff = new HStaffDetail();
					
					Random r = new Random();
					String staffNumber = String.valueOf(100000 + r.nextInt(899999));

					
					System.out.println("user ID " + tempUser.getUserId());
					staff.setUserId(tempUser.getUserId());
					staff.setEmployeeNumber(staffNumber);
					DBStaffDetail.insert(staff);
			}
			Long newRoleLong = Long.parseLong(newRole);
			HRole newRoleObj = DBRole.getRole(newRoleLong);
			
			HUserRole userRole = new HUserRole();
			userRole.setHRole(newRoleObj);
			userRole.setHUser(tempUser);
			userRole.setRoleStatus("Active");
			
			DBUserRole.insert(userRole);
			
		}
		
		List<HUserRole> currentRoles = tempUser.getHUserRoles();
		System.out.println("currentRoles size = " + currentRoles.size());
		for(HUserRole currentRole : currentRoles)
		{
			System.out.println("parameter name = " + "currentRole" + currentRole.getUserRoleId());
			String newStatus =  request.getParameter("currentRole" + currentRole.getUserRoleId());
			currentRole.setRoleStatus(newStatus);
			DBUserRole.update(currentRole);
		}
		getServletContext().getRequestDispatcher("/SearchForUser.jsp").forward(request, response);
	}

}
