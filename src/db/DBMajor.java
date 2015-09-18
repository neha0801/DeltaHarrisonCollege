package db;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;

import customTools.DBUtil;
import model.HCourse;
import model.HMajor;
import model.HUser;

public class DBMajor {
	
	
	public static List<HMajor> getMajors()
	{
		EntityManager em = DBUtil.getEmFactory().createEntityManager();
		String queryStr = "SELECT m FROM HMajor m ORDER BY m.name";
		System.out.println("Query from getMajors :" + queryStr);
		List<HMajor> majors = new ArrayList<HMajor>();
		try
		{
			Query query = em.createQuery(queryStr);
			majors =  query.getResultList();
			System.out.println("size = " + majors.size());
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
		finally
		{
			em.close();
		}
		return majors;
	}
	
	public static HMajor getMajor(long majorId)
	{
		EntityManager em = DBUtil.getEmFactory().createEntityManager();
		try
		{
			HMajor major = em.find(HMajor.class, majorId);
			return major;
		}
		finally
		{
			em.close();
		}
	}
	
	public static List<HMajor> searchforMajor( String departmentId)
	{
		String whereClause = "";
		
		boolean hasDepartment = false;
		
		if (departmentId.equalsIgnoreCase("all"))
		{
			whereClause += " WHERE 0=0 ";
		}
		else
		{
			whereClause += " WHERE m.HDepartment.departmentId = :departmentId ";
			hasDepartment = true;
		}
		System.out.println("whereClause = " + whereClause);
		String queryStr  = "SELECT m FROM HMajor m " + whereClause;
		System.out.println("queryStr = " + queryStr);
		EntityManager em = DBUtil.getEmFactory().createEntityManager();
		List<HMajor> majors = null;
		try
		{
			Query query = em.createQuery(queryStr);
			
			
			
			if(hasDepartment)
			{
				query.setParameter("departmentId", Long.parseLong(departmentId));
			}
				
			majors =  query.getResultList();
			System.out.println("size = " + majors.size());
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
		finally
		{
			em.close();
		}
		return majors;
	}

	public static List<HMajor> getAllMajors() {
		EntityManager em = DBUtil.getEmFactory().createEntityManager();
		String queryStr = "SELECT h FROM HMajor h";
		List<HMajor> major = null;
		try {
			Query query = em.createQuery(queryStr);
			major = query.getResultList();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			em.close();
		}
		return major;
	}
	

	public static void update(HMajor major) 
	{
		EntityManager em = DBUtil.getEmFactory().createEntityManager();
		EntityTransaction trans = em.getTransaction();
		trans.begin(); 
		try 
		{
			em.merge(major);
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
}
