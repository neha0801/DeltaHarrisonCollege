package db;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import model.HClass;
import model.HStudentDetail;
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
	
	public static void insert(HStudentDetail student) 
	{
		EntityManager em = DBUtil.getEmFactory().createEntityManager();
		EntityTransaction trans = em.getTransaction();
		trans.begin(); 
		try 
		{
			em.persist(student);
			trans.commit();
		} 
		catch (Exception e) 
		{
			System.out.println(e);
			trans.rollback();
		} 
		finally 
		{
			em.close();
		}
	}
	
	public static HStudentDetail getStudentDetail(long userId)
	{
		EntityManager em = DBUtil.getEmFactory().createEntityManager();
		try
		{
			HStudentDetail student = em.find(HStudentDetail.class, userId);
			return student;
		}
		finally
		{
			em.close();
		}
	}
}
