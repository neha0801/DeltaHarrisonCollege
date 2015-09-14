package db;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import customTools.DBUtil;
import model.HUser;

public class DBUserDetail {

	/*
	 * This method accepts an username and a password then return a userId (if any) 
	 * If there's no user match the username and password then return 0
	 */
	public static long login(HUser user)
	{
		//method to return the userId

		EntityManager em = DBUtil.getEmFactory().createEntityManager();
		//query to return the user Id
		String query = "SELECT d.userId FROM HUser d WHERE d.userName = :userName AND d.password = :password";
		System.out.println(query);
		try
		{
			long l = (long) em.createQuery(query)
					.setParameter("userName", user.getUserName())
					.setParameter("password", user.getPassword())
					.getSingleResult();
			return l;
		}
		catch(Exception e)
		{
			return 0;
		}
		finally
		{
			em.close();
		}
	}
	
	
	public static HUser getUser(long userId)
	{
		EntityManager em = DBUtil.getEmFactory().createEntityManager();
		try
		{
			HUser user = em.find(HUser.class, userId);
			return user;
		}
		finally
		{
			em.close();
		}
	}
	
	public static boolean isAvailable(HUser user)
	{
		EntityManager em = DBUtil.getEmFactory().createEntityManager();
		String query = "SELECT count(d.userId) FROM HUser d WHERE UPPER(d.userName) = :userName OR UPPER(d.email) = :email";
		System.out.println("is Available Query : " + query);
		try
		{
			long l = (long) em.createQuery(query)
					.setParameter("userName", user.getUserName().toUpperCase())
					.setParameter("email", user.getEmail().toUpperCase())
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
	
	public static void insert(HUser user) 
	{
		EntityManager em = DBUtil.getEmFactory().createEntityManager();
		EntityTransaction trans = em.getTransaction();
		trans.begin(); 
		try 
		{
			em.persist(user);
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

}
