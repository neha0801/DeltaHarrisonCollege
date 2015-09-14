package db;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import customTools.DBUtil;
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
}
