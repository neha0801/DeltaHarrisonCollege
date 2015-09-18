package db;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;






import model.HDepartment;
import customTools.DBUtil;

public class DBDepartment {
	
	public static List<HDepartment> getAllActiveDepartment()
	{
		EntityManager em = DBUtil.getEmFactory().createEntityManager();
		String queryStr = "SELECT d FROM HDepartment d WHERE d.status = :activeStatus";
		List<HDepartment> departments = null;
		try
		{
			Query query = em.createQuery(queryStr)
					.setParameter("activeStatus", "Active");
					
			departments =  query.getResultList();
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
		return departments;
	}
	
	

	public static List<HDepartment> getAllDepartments() {
		EntityManager em = DBUtil.getEmFactory().createEntityManager();
		String queryStr = "SELECT h FROM HDepartment h";
		List<HDepartment> departments = null;
		try {
			Query query = em.createQuery(queryStr);
			departments = query.getResultList();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			em.close();
		}
		return departments;
	}

	public static HDepartment getDepartment(long departmentId) {
		EntityManager em = DBUtil.getEmFactory().createEntityManager();
		try {
			HDepartment department = em.find(HDepartment.class, departmentId);
			return department;
		} finally {
			em.close();
		}
	}

	public static void update(HDepartment department) {
		EntityManager em = DBUtil.getEmFactory().createEntityManager();
		EntityTransaction trans = em.getTransaction();
		trans.begin();
		try {
			em.merge(department);
			trans.commit();
		} catch (Exception e) {
			System.out.println(e);
			trans.rollback();
		} finally {
			em.close();
		}
	}

}
