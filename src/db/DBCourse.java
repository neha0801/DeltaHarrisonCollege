package db;



import java.util.ArrayList;



import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

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
	
	public static List<HCourse> searchforCourse( String departmentId)
	{
		String whereClause = "";
		
		boolean hasDepartment = false;
		
		if (departmentId.equalsIgnoreCase("all"))
		{
			whereClause += " WHERE 0=0 ";
		}
		else
		{
			whereClause += " WHERE c.HMajor.HDepartment.departmentId = :departmentId ";
			hasDepartment = true;
		}
		System.out.println("whereClause = " + whereClause);
		String queryStr  = "SELECT c FROM HCourse c " + whereClause;
		System.out.println("queryStr = " + queryStr);
		EntityManager em = DBUtil.getEmFactory().createEntityManager();
		List<HCourse> courses = null;
		try
		{
			Query query = em.createQuery(queryStr);
			
			
			
			if(hasDepartment)
			{
				query.setParameter("departmentId", Long.parseLong(departmentId));
			}
				
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
	public static HCourse getSelectedCourse(long id)
	{
		EntityManager em = DBUtil.getEmFactory().createEntityManager();
		String queryStr = "SELECT c FROM HCourse c where c.courseId = :id";
		System.out.println("Query from getCourses :" + queryStr);
		HCourse course = null;
		try
		{
			TypedQuery<HCourse> query = em.createQuery(queryStr,HCourse.class).setParameter("id", id);
			course =  query.getSingleResult();
			
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
		finally
		{
			em.close();
		}
		return course;
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
