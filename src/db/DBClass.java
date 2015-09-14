package db;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import model.HClass;
import model.HSemester;
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

}
