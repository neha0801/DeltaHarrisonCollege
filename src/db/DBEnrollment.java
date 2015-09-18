package db;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;

import customTools.DBUtil;
import model.HClass;
import model.HEnrollment;
import model.HStudentDetail;
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
		String queryStr = "SELECT e FROM HEnrollment e where (e.status= :EnrolledStatus or e.status= :DropStatus) and e.HStudentDetail= :studentDetail";
		List<HEnrollment> enrollments = null;
		try
		{
			Query query = em.createQuery(queryStr)
					.setParameter("EnrolledStatus", "Enrolled")
					.setParameter("DropStatus","Dropped")
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
	
	public static List<HEnrollment> getEnrollmentByStudent(HStudentDetail student)
	{
		EntityManager em = DBUtil.getEmFactory().createEntityManager();
		String queryStr = "SELECT e FROM HEnrollment e where (e.status= :EnrolledStatus or e.status= :DropStatus) and e.HStudentDetail= :studentDetail";
		List<HEnrollment> enrollments = null;
		try
		{
			Query query = em.createQuery(queryStr)
					.setParameter("EnrolledStatus", "Enrolled")
					.setParameter("DropStatus","Dropped")
					.setParameter("studentDetail", student);
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
	
	
	public static HEnrollment getEnrollment(long enrollmentId)
	{
		EntityManager em = DBUtil.getEmFactory().createEntityManager();
		try
		{
			HEnrollment newEnrollment = em.find(HEnrollment.class, enrollmentId);
			return newEnrollment;
		}
		finally
		{
			em.close();
		}
	}
	public static void update(HEnrollment enrollment) 
	{
		EntityManager em = DBUtil.getEmFactory().createEntityManager();
		EntityTransaction trans = em.getTransaction();
		trans.begin(); 
		try 
		{
			em.merge(enrollment);
			trans.commit();
		} catch (Exception e) 
		{
			System.out.println(e);
			trans.rollback();
		} 
		finally 
		{
			em.close();
		}
	}
	
	
	public static double getGrade(String grade){
		double grd=0.0;
		
		switch (grade) {
		
        case "A": grd=4.0;
        		break;
        case "B": grd=3.0;
				  break;
        case "C": grd=2.0;
					break;
        case "D": grd=1.0;
					break;
        case "F": grd=0.0;
					break;
		}
		return grd;		
	}

	
	public static List<HEnrollment> getEnrollmentByClass(HClass classObj)
	{
		EntityManager em = DBUtil.getEmFactory().createEntityManager();
		String queryStr = "SELECT e FROM HEnrollment e where e.status= :status and e.HClass= :classObj";
		System.out.println("SELECT * FROM H_Enrollment e where e.status= 'Enrolled' and e.class_id= " + classObj.getClassId());
		List<HEnrollment> enrollments = null;
		try
		{
			Query query = em.createQuery(queryStr)
					.setParameter("status", "Enrolled")
					.setParameter("classObj", classObj);
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
	
	public static HEnrollment getEnrollemnt(long enrollmentId) {
		EntityManager em = DBUtil.getEmFactory().createEntityManager();
		try {
			HEnrollment enroll = em.find(HEnrollment.class, enrollmentId);
			return enroll;
		} finally {
			em.close();
		}
	}
}
