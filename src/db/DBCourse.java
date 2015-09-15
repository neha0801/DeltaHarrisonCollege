package db;

import java.util.List;

import javax.persistence.EntityManager;




import javax.persistence.Query;

import model.HClass;
import model.HCourse;
import model.HSemester;
import model.HUser;
import customTools.DBUtil;

public class DBCourse {
	public static List<HCourse>  getAllCourses() {
		EntityManager em = DBUtil.getEmFactory().createEntityManager();
		String queryStr = "SELECT h FROM HCourse h";
		List<HCourse> courses = null;
		try {
			Query query = em.createQuery(queryStr);
			courses = query.getResultList();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			em.close();
		}
		return courses;
	}
	
	public static HCourse getCourse(long courseId)
	{
		EntityManager em = DBUtil.getEmFactory().createEntityManager();
		try
		{
			HCourse course = em.find(HCourse.class, courseId);
			return course;
		}
		finally
		{
			em.close();
		}
	}

}
