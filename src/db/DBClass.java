package db;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import model.HClass;
import model.HSemester;
import model.HStaffDetail;
import model.HUser;
import customTools.DBUtil;

public class DBClass 
{
	
	public static List<HClass> getAllClasses(HSemester hSemester)
	{
		EntityManager em = DBUtil.getEmFactory().createEntityManager();
		String queryStr = "SELECT c FROM HClass c where c.status= :status and  c.HSemester = :hSemester";
		List<HClass> classes = null;
		try
		{
			Query query = em.createQuery(queryStr)
					.setParameter("status", "Active")
					.setParameter("hSemester", hSemester);
			classes =  query.getResultList();
			System.out.println("size = " + classes.size());
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
		finally
		{
			em.close();
		}
		return classes;
	}
	
	public static HClass getClass(long classId)
	{
		EntityManager em = DBUtil.getEmFactory().createEntityManager();
		try
		{
			HClass newClass = em.find(HClass.class, classId);
			return newClass;
		}
		finally
		{
			em.close();
		}
	}
	
	public static List<HClass> getInstructorClasses(HStaffDetail user,HSemester hSemester)
	{
		EntityManager em = DBUtil.getEmFactory().createEntityManager();
		String queryStr = "SELECT c FROM HClass c where c.HStaffDetail = :user and c.status= :status and  c.HSemester = :hSemester";
		System.out.println(queryStr);
		List<HClass> classes = null;
		try
		{
			Query query = em.createQuery(queryStr)
					.setParameter("user", user)
					.setParameter("status", "Active")
					.setParameter("hSemester", hSemester);
			classes =  query.getResultList();
			System.out.println("size = " + classes.size());
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
		finally
		{
			em.close();
		}
		return classes;
	}
	
	public static List<HClass> getInstructorClasses(HStaffDetail user)
	{
		EntityManager em = DBUtil.getEmFactory().createEntityManager();
		String queryStr = "SELECT c FROM HClass c where c.HStaffDetail = :user and c.status= :status";
		System.out.println(queryStr);
		List<HClass> classes = null;
		try
		{
			Query query = em.createQuery(queryStr)
					.setParameter("user", user)
					.setParameter("status", "Active");
			classes =  query.getResultList();
			System.out.println("size = " + classes.size());
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
		finally
		{
			em.close();
		}
		return classes;
	}
}
