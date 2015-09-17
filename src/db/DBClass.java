package db;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import model.HClass;
import model.HSemester;
import model.HStaffDetail;
import model.HUser;
import customTools.DBUtil;

public class DBClass 
{
	public static List<HClass> searchClass(String subjectId, String instructor, String time, String departmentId)
	{
		String whereClause = "";
		boolean hasSubject = false;
		boolean hasInstructor = false;
		boolean hasTime = false;
		boolean hasDepartment = false;
		if (subjectId.equalsIgnoreCase("all"))
		{
			whereClause += " AND 0=0 ";
		}
		
		else
		{
			whereClause += " AND c.HCourse.HSubject.subjectId = :subjectId ";
			hasSubject = true;
		}
		
		
		if (instructor == null || instructor.isEmpty())
		{
			whereClause += " AND 0=0 ";
		}
		else
		{
			whereClause += " AND (c.HStaffDetail.HUser.firstName LIKE :instructor1 OR  c.HStaffDetail.HUser.lastName LIKE :instructor2) ";
			hasInstructor = true;
		}
		
		
		if (time.equalsIgnoreCase("all"))
		{
			whereClause += " AND 0=0 ";
		}
		else
		{
			whereClause += " AND cs.classTime = :classTime ";
			hasTime = true;
		}
		
		if (departmentId.equalsIgnoreCase("all"))
		{
			whereClause += " AND 0=0 ";
		}
		else
		{
			whereClause += " AND c.HCourse.HMajor.HDepartment.departmentId = :departmentId ";
			hasDepartment = true;
		}
		
		System.out.println("whereClause = " + whereClause);
		String queryStr  = "SELECT c FROM HClass c, HClassSchedule cs WHERE c.classId = cs.HClass.classId " + whereClause;
		System.out.println("queryStr = " + queryStr);
		EntityManager em = DBUtil.getEmFactory().createEntityManager();
		List<HClass> classes = null;
		try
		{
			Query query = em.createQuery(queryStr);
			
			if(hasSubject)
			{
				query.setParameter("subjectId", Long.parseLong(subjectId));
			}
			
			if(hasInstructor)
			{
				query.setParameter("instructor2", "%" + instructor + "%")
				.setParameter("instructor1", "%" + instructor + "%");
			}
			
			if(hasTime)
			{
				
				query.setParameter("classTime", Integer.parseInt(time));
			}
			
			if(hasDepartment)
			{
				query.setParameter("departmentId", Long.parseLong(departmentId));
			}
			

				
			classes =  query.getResultList();
			System.out.println("size = " + classes.size());
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
		finally
		{
			em.close();
		}
		return classes;
	}

	public static List<HClass> getAllClasses(HSemester hSemester)
	{
		EntityManager em = DBUtil.getEmFactory().createEntityManager();
		String queryStr = "SELECT c FROM HClass c where c.status= :status and  c.HSemester = :hSemester";
		List<HClass> classes = null;
		try
		{
			Query query = em.createQuery(queryStr)
					.setParameter("status", "Active")
					.setParameter("hSemester", hSemester);
			classes =  query.getResultList();
			System.out.println("size = " + classes.size());
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
		finally
		{
			em.close();
		}
		return classes;
	}
	
	public static List<HClass> getAdminClasses()
	{
		EntityManager em = DBUtil.getEmFactory().createEntityManager();
		String queryStr = "SELECT c FROM HClass c where c.status= :status ";
		List<HClass> classes = null;
		try
		{
			Query query = em.createQuery(queryStr)
					.setParameter("status", "Active");
			classes =  query.getResultList();
			System.out.println("size = " + classes.size());
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
		finally
		{
			em.close();
		}
		return classes;
	}
	
	public static HClass getClass(long classId)
	{
		EntityManager em = DBUtil.getEmFactory().createEntityManager();
		try
		{
			HClass newClass = em.find(HClass.class, classId);
			return newClass;
		}
		finally
		{
			em.close();
		}
	}
	
	public static List<HClass> getInstructorClasses(HStaffDetail user,HSemester hSemester)
	{
		EntityManager em = DBUtil.getEmFactory().createEntityManager();
		String queryStr = "SELECT c FROM HClass c where c.HStaffDetail = :user and c.status= :status and  c.HSemester = :hSemester";
		System.out.println(queryStr);
		List<HClass> classes = null;
		try
		{
			Query query = em.createQuery(queryStr)
					.setParameter("user", user)
					.setParameter("status", "Active")
					.setParameter("hSemester", hSemester);
			classes =  query.getResultList();
			System.out.println("size = " + classes.size());
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
		finally
		{
			em.close();
		}
		return classes;
	}
	
	public static List<HClass> getInstructorClasses(HStaffDetail user)
	{
		EntityManager em = DBUtil.getEmFactory().createEntityManager();
		String queryStr = "SELECT c FROM HClass c where c.HStaffDetail = :user and c.status= :status";
		System.out.println(queryStr);
		List<HClass> classes = null;
		try
		{
			Query query = em.createQuery(queryStr)
					.setParameter("user", user)
					.setParameter("status", "Active");
			classes =  query.getResultList();
			System.out.println("size = " + classes.size());
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
		finally
		{
			em.close();
		}
		return classes;
	}
	public static void insert(HClass newClass) {
		EntityManager em = DBUtil.getEmFactory().createEntityManager();
		EntityTransaction trans = em.getTransaction();
		trans.begin();
		try {
			em.persist(newClass);
			trans.commit();
			
		} catch (Exception e) {
			System.out.println(e);
			trans.rollback();
		} finally {
			em.close();
		}
		
	}

	
	public static HClass getNewClass(String status)
	{
		EntityManager em = DBUtil.getEmFactory().createEntityManager();
		String queryStr = "SELECT c FROM HClass c where c.status= :status";
		HClass classOBJ = null;
		try
		{
			TypedQuery<HClass> query = em.createQuery(queryStr,HClass.class)
					.setParameter("status", "New");
			classOBJ =  query.getSingleResult();
		} catch (Exception e)
		{
			e.printStackTrace();
		}
		finally
		{
			em.close();
		}
		return classOBJ;
		
	}
	
	public static void update(HClass classObj) {
		EntityManager em = DBUtil.getEmFactory().createEntityManager();
		EntityTransaction trans = em.getTransaction();
		trans.begin();
		try {
			em.merge(classObj);
			trans.commit();
		} catch (Exception e) {
			System.out.println(e);
			trans.rollback();
		} finally {
			em.close();
		}
	}
	
}
