package db;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import customTools.DBUtil;
import model.HClass;
import model.HEnrollment;
import model.HStaffDetail;
import model.HSubject;
import model.HUser;

public class DBUserDetail {

	/*
	 * This method accepts an username and a password then return a userId (if
	 * any) If there's no user match the username and password then return 0
	 */
	public static long login(HUser user) {
		// method to return the userId

		EntityManager em = DBUtil.getEmFactory().createEntityManager();
		// query to return the user Id
		String query = "SELECT d.userId FROM HUser d WHERE d.userName = :userName AND d.password = :password";
		System.out.println(query);
		try {
			long l = (long) em.createQuery(query)
					.setParameter("userName", user.getUserName())
					.setParameter("password", user.getPassword())
					.getSingleResult();
			return l;
		} catch (Exception e) {
			return 0;
		} finally {
			em.close();
		}
	}

	public static HUser getUser(long userId) {
		EntityManager em = DBUtil.getEmFactory().createEntityManager();
		try {
			HUser user = em.find(HUser.class, userId);
			return user;
		}
		catch (Exception e)
		{
			e.printStackTrace();
			return null;	
			}
			finally {
		
			em.close();
		}
	}

	public static boolean isAvailable(HUser user) {
		EntityManager em = DBUtil.getEmFactory().createEntityManager();
		String query = "SELECT count(d.userId) FROM HUser d WHERE UPPER(d.userName) = :userName OR UPPER(d.email) = :email";
		System.out.println("is Available Query : " + query);
		try {
			long l = (long) em.createQuery(query)
					.setParameter("userName", user.getUserName().toUpperCase())
					.setParameter("email", user.getEmail().toUpperCase())
					.getSingleResult();
			if (l > 0) {
				return false;
			} else {
				return true;
			}
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		} finally {
			em.close();
		}
	}

	public static void insert(HUser user) {
		EntityManager em = DBUtil.getEmFactory().createEntityManager();
		EntityTransaction trans = em.getTransaction();
		trans.begin();
		try {
			em.persist(user);
			trans.commit();
		} catch (Exception e) {
			System.out.println(e);
			trans.rollback();
		} finally {
			em.close();
		}
	}

	public static HUser getSingleUser(String userName) {
		EntityManager em = DBUtil.getEmFactory().createEntityManager();
		String sql = "SELECT d FROM HUser d WHERE UPPER(d.userName) = :userName";
		System.out.println("Get Single : " + sql);
		TypedQuery<HUser> query = em.createQuery(sql, HUser.class).setParameter("userName", userName.toUpperCase());
		HUser user = null;
		try {
			user = query.getSingleResult();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			em.close();
		}
		return user;
	}

	public static void update(HUser user) {
		EntityManager em = DBUtil.getEmFactory().createEntityManager();
		EntityTransaction trans = em.getTransaction();
		trans.begin();
		try {
			em.merge(user);
			trans.commit();
		} catch (Exception e) {
			System.out.println(e);
			trans.rollback();
		} finally {
			em.close();
		}
	}
	
	
	public static List<HUser> getAllUser()
	{
		EntityManager em = DBUtil.getEmFactory().createEntityManager();
		String queryStr = "SELECT s FROM HUser s";
		List<HUser> users = null;
		try
		{
			Query query = em.createQuery(queryStr);
					
			users =  query.getResultList();
			System.out.println("size = " + users.size());
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
		finally
		{
			em.close();
		}
		return users;
	}
	
	public static List<HUser> getUsersForAdmin(String name){
		List<HUser>users=null;
		EntityManager em = DBUtil.getEmFactory().createEntityManager();
		String queryStr = "SELECT u FROM HUser u WHERE u.firstName LIKE :name1 OR  u.lastName LIKE :name2 OR  u.userName LIKE :name3";
		Query query = em.createQuery(queryStr)
				.setParameter("name2", "%" + name + "%")
				.setParameter("name3", "%" + name + "%")
				.setParameter("name1", "%" + name + "%");
		users =  query.getResultList();
		return users;
	}
	
}
