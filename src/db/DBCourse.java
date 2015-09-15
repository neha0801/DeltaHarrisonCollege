package db;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import model.HCourse;
import customTools.DBUtil;

public class DBCourse {
	
	
	public static List<HCourse> getAllCourses()
	{
		EntityManager em = DBUtil.getEmFactory().createEntityManager();
		String queryStr = "SELECT c FROM HCourse c ";
		List<HCourse> courses = null;
		try
		{
			Query query = em.createQuery(queryStr);					
			courses =  query.getResultList();
			System.out.println("size = " + courses.size());
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
		finally
		{
			em.close();
		}
		return courses;
	}

}
