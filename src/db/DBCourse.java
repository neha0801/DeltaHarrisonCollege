package db;

import java.util.List;

import javax.persistence.EntityManager;




import javax.persistence.EntityTransaction;
import javax.persistence.Query;

import model.HClass;
import model.HCourse;
import model.HSemester;

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
	public static void update(HCourse course) 
	{
		EntityManager em = DBUtil.getEmFactory().createEntityManager();
		EntityTransaction trans = em.getTransaction();
		trans.begin(); 
		try 
		{
			em.merge(course);
			trans.commit();
		} catch (Exception e) 
		{
			System.out.println(e);
			trans.rollback();
		} 
		finally 
		{
			em.close();
		}
	}
	
	 public static void insertCourse(HCourse course) 
	    {
	    	EntityManager em = DBUtil.getEmFactory().createEntityManager();
	    	EntityTransaction profile = em.getTransaction();
	    	profile.begin();
	    	try {
	    	em.persist(course);
	    	profile.commit();
	    	} catch (Exception e) {
	    	System.out.println(e);
	    	profile.rollback();
	    	} finally {
	    
	    	}
	    }
}
