package db;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import model.HCourse;
import customTools.DBUtil;

public class DBCourse {
	
	public static List<HCourse> getCourses()
	{
		EntityManager em = DBUtil.getEmFactory().createEntityManager();
		String queryStr = "SELECT c FROM HCourse c ORDER BY c.name";
		System.out.println("Query from getCourses :" + queryStr);
		List<HCourse> courses = new ArrayList<HCourse>();
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
