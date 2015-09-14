package db;

import javax.persistence.EntityManager;

import model.HUser;
import customTools.DBUtil;

public class DBStudentDetail {

	public static boolean isAvailable(String studentNumber)
	{
		EntityManager em = DBUtil.getEmFactory().createEntityManager();
		String query = "SELECT count(d.userId) FROM HStudentDetail d WHERE studentNumber = '" + studentNumber + "'";
		System.out.println("is Available Student Query : " + query);
		try
		{
			long l = (long) em.createQuery(query)
					.getSingleResult();
			if (l>0)
			{
				return false;
			}
			else
			{
				return true;
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
			return false;
		}
		finally
		{
			em.close();
		}
	}
}
