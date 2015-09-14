package db;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;

import customTools.DBUtil;
import model.HEnrollment;
import model.HUser;

public class DBEnrollment {
	
	public static void insert(HEnrollment enrollment) 
	{
		EntityManager em = DBUtil.getEmFactory().createEntityManager();
		EntityTransaction trans = em.getTransaction();
		trans.begin(); 
		try 
		{
			em.persist(enrollment);
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
	
	public static List<HEnrollment> getEnrollmentByStudent(HUser user)
	{
		EntityManager em = DBUtil.getEmFactory().createEntityManager();
		String queryStr = "SELECT e FROM HEnrollment e where e.status= :status and e.HStudentDetail= :studentDetail";
		List<HEnrollment> enrollments = null;
		try
		{
			Query query = em.createQuery(queryStr)
					.setParameter("status", "Enrolled")
					.setParameter("studentDetail", user.getHStudentDetail());
			enrollments =  query.getResultList();
			System.out.println("size = " + enrollments.size());
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
		finally
		{
			em.close();
		}
		return enrollments;
	}

}
