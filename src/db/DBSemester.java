package db;

import java.util.List;



import javax.persistence.EntityManager;
import javax.persistence.Query;

import model.HSemester;
import customTools.DBUtil;

public class DBSemester {
	
	public static List<HSemester> getAllSemester()
	{
		EntityManager em = DBUtil.getEmFactory().createEntityManager();
		String queryStr = "SELECT s FROM HSemester s ORDER BY s.year DESC,s.season DESC ";
		List<HSemester> semesters = null;
		try
		{
			Query query = em.createQuery(queryStr);
			semesters =  query.getResultList();
			System.out.println("size = " + semesters.size());
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
		finally
		{
			em.close();
		}
		return semesters;
	}
	
	public static HSemester getSemester(long semesterId)
	{
		EntityManager em = DBUtil.getEmFactory().createEntityManager();
		try
		{
			HSemester semester = em.find(HSemester.class, semesterId);
			return semester;
		}
		finally
		{
			em.close();
		}
	}
}
