package db;

import java.util.List;

import javax.persistence.EntityManager;
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
	
	
}
