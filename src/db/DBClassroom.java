package db;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import model.HClassroom;
import customTools.DBUtil;

public class DBClassroom {

	public static List<HClassroom> searchClassroom(String courseId, String instructor, String studentNumber)
	{
		String whereClause = "";
		boolean hasCourse = false;
		boolean hasInstructor = false;
		boolean hasStudent = false;
		
		if (courseId.equalsIgnoreCase("all"))
		{
			whereClause += " AND 0=0 ";
		}
		else
		{
			whereClause += " AND c.HCourse.courseId = :courseId ";
			hasCourse = true;
		}
		if (instructor == null || instructor.isEmpty())
		{
			whereClause += " AND 0=0 ";
		}
		else
		{
			whereClause += " AND (c.HStaffDetail.HUser.firstName LIKE :instructor1 OR  c.HStaffDetail.HUser.lastName LIKE :instructor2) ";
			hasInstructor = true;
		}
		
		
		
		if (studentNumber.equalsIgnoreCase("all"))
		{
			whereClause += " AND 0=0 ";
		}
		else
		{
			whereClause += " AND sd.studentNumber= :studentNumber ";
			hasStudent = true;
		}
		System.out.println("whereClause = " + whereClause);
		String queryStr  = "SELECT cr FROM HClass c, HClassroom cr,HEnrollment e,HStudentDetail sd WHERE c.HClassroom.classroomId = cr.classroomId AND e.HClass.classId=c.classId AND e.HStudentDetail.userId=sd.userId" + whereClause;
		System.out.println("queryStr = " + queryStr);
		EntityManager em = DBUtil.getEmFactory().createEntityManager();
		List<HClassroom> classrooms = null;
		try
		{
			Query query = em.createQuery(queryStr);
			
			if(hasCourse)
			{
				query.setParameter("courseId", Long.parseLong(courseId));
			}
			
			if(hasInstructor)
			{
				query.setParameter("instructor2", "%" + instructor + "%")
				.setParameter("instructor1", "%" + instructor + "%");
			}
			
			
			
			if(hasStudent)
			{
				query.setParameter("studentNumber",studentNumber);
			}
			

				
			classrooms =  query.getResultList();
			System.out.println("size = " + classrooms.size());
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
		finally
		{
			em.close();
		}
		return classrooms;
	}
	
	
}
