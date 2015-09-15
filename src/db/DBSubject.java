package db;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import model.HClass;
import model.HEnrollment;
import model.HSemester;
import model.HSubject;
import model.HUser;
import customTools.DBUtil;

public class DBSubject {

	

	
	public static List<HSubject> getAllActiveSubject()
	{
		EntityManager em = DBUtil.getEmFactory().createEntityManager();
		String queryStr = "SELECT s FROM HSubject s";
		List<HSubject> subjects = null;
		try
		{
			Query query = em.createQuery(queryStr);
					
			subjects =  query.getResultList();
//			System.out.println("size = " + subjects.size());
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
		finally
		{
			em.close();
		}
		return subjects;
	}
	

}
