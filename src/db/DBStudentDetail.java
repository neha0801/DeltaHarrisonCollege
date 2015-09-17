package db;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import model.HClass;
import model.HSemester;
import model.HStudentDetail;
import model.HUser;
import customTools.DBUtil;

public class DBStudentDetail {

	public static boolean isAvailable(String studentNumber)
	{
		EntityManager em = DBUtil.getEmFactory().createEntityManager();
		String query = "SELECT count(d.userId) FROM HStudentDetail d WHERE d.studentNumber = '" + studentNumber + "'";
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

	public static HStudentDetail getStudentDetail(String studentNumber)
	{
		EntityManager em = DBUtil.getEmFactory().createEntityManager();
		String queryStr = "SELECT d FROM HStudentDetail d WHERE d.studentNumber = :studentNumber";
		HStudentDetail student=null;
		try
		{
			Query query = em.createQuery(queryStr)
					
					.setParameter("studentNumber", studentNumber);
			student =  (HStudentDetail) query.getSingleResult();
			
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
		finally
		{
			em.close();
		}
		return student;
	}
//	public static List<HStudentDetail> getStudent(HClass classes) {
//		EntityManager em = DBUtil.getEmFactory().createEntityManager();
//		String sql = "SELECT s FROM HStudentDetail s WHERE c.userName) = :userName";
//		System.out.println("Get Single : " + sql);
//		TypedQuery<HUser> query = em.createQuery(sql, HUser.class).setParameter("userName", userName.toUpperCase());
//		HUser user = null;
//		try {
//			user = query.getSingleResult();
//
//		} catch (Exception e) {
//			e.printStackTrace();
//		} finally {
//			em.close();
//		}
//		return user;
//	}



}
