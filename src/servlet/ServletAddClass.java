package servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.HClass;
import model.HClassSchedule;
import model.HClassroom;
import model.HCourse;
import model.HMajor;
import model.HSemester;
import model.HUser;
import db.DBClass;
import db.DBClassSchedule;
import db.DBClassroom;
import db.DBCourse;
import db.DBCreditTuition;
import db.DBMajor;
import db.DBSemester;
import db.DBStaffDetail;
import db.DBUserDetail;
import db.DBWeekday;

/**
 * Servlet implementation class ServletAddClass
 */
@WebServlet("/AddClass")
public class ServletAddClass extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletAddClass() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String action = request.getParameter("action");
		System.out.println("doget of add class :" + action);
		if(action.equalsIgnoreCase("load")){
			List<HMajor> majors= DBMajor.getMajors();
			
			List<HCourse> courses= DBCourse.getCourses();
			
			List<HUser> users = DBUserDetail.getAllUser();
			List<HUser> instructors= new ArrayList<HUser>();
			for(HUser u : users){
				if(u.isInstructor()){
					instructors.add(u);
				}
			}
			
			List<HClassroom> classrooms = DBClassroom.getAllClassroom();
			
			List<HSemester> semesters = DBSemester.getAllSemester();
			request.setAttribute("majors", majors);
			request.setAttribute("courses", courses);
			request.setAttribute("instructors", instructors);
			request.setAttribute("classrooms", classrooms);
			request.setAttribute("semesters", semesters);
			getServletContext().getRequestDispatcher("/AddClass.jsp").forward(request, response);
		} 
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("dopost of add class");
		String majorIdStr = request.getParameter("major");
		System.out.println("major : " + majorIdStr);
		String courseIdStr = request.getParameter("course");
		System.out.println("course : " + courseIdStr);
		String instructorIdStr = request.getParameter("instructor");
		String semesterIdStr = request.getParameter("semester");
		String classroomIdStr = request.getParameter("classroom");
		long majorId, courseId, instructorId, semesterId, classroomId,weekdayId;
		int classTime;
		String classScheduleIdStr;
		if(majorIdStr!=null || courseIdStr!=null || instructorIdStr!=null 
				|| semesterIdStr!=null || classroomIdStr!=null){
			majorId= Long.parseLong(majorIdStr);
			System.out.println(majorIdStr);
			courseId = Long.parseLong(courseIdStr);
			instructorId = Long.parseLong(instructorIdStr);
			semesterId= Long.parseLong(semesterIdStr);
			classroomId = Long.parseLong(classroomIdStr);
			HClass newClass = new HClass();
			newClass.setHCourse(DBCourse.getSelectedCourse(courseId));
			newClass.setHSemester(DBSemester.getSemester(semesterId));
			newClass.setHClassroom(DBClassroom.getSelectedClassroom(classroomId));
			newClass.setHStaffDetail(DBStaffDetail.getUser(instructorId));
			newClass.setStatus("New");
			long maxCreditId = DBCreditTuition.getLatestFeeID();
			newClass.setHCreditTuition(DBCreditTuition.getCreditTuitionFee(maxCreditId));
			int count =0;
			for(int i =1; i<=5;i++){
				classScheduleIdStr = request.getParameter("time"+i);
				if(!classScheduleIdStr.equalsIgnoreCase("-1")){
					count++;
				}				
			}
			if(count<=0){
				String errorMessage = "Class Schedule Missing!! Try Again";
				request.setAttribute("errorMessage", errorMessage);
			}else{
				DBClass.insert(newClass);
				List<HClassSchedule> classSchedules = new ArrayList<HClassSchedule>();
				System.out.println();
				newClass= DBClass.getNewClass("New");
				
				for(int i =1; i<=5;i++){
					classScheduleIdStr = request.getParameter("time"+i);
					System.out.println("schedule id " + classScheduleIdStr);
					if(!classScheduleIdStr.equalsIgnoreCase("-1")){
						HClassSchedule schedule = new HClassSchedule();
						weekdayId = i;
						classTime = Integer.parseInt(classScheduleIdStr);
						schedule.setHWeekday(DBWeekday.getWeekDay(weekdayId));
						schedule.setClassTime(classTime);
						schedule.setHClass(newClass);
						classSchedules.add(schedule);
						
					}
				}
				System.out.println("count = " + count);
			
					newClass.setHClassSchedules(classSchedules);
					newClass.setStatus("Active");
				
					DBClass.update(newClass);
					String goodMessage = "Congratz!! Class Added";
					request.setAttribute("goodMessage", goodMessage);				
			}
			
			doGet(request,response);
		}
		
	}

}
