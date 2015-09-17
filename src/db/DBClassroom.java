package db;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;



import javax.persistence.TypedQuery;

import model.HClassroom;
import model.HCourse;
import customTools.DBUtil;

public class DBClassroom {
	
	public static List<HClassroom> getAllClassroom()
	{
		EntityManager em = DBUtil.getEmFactory().createEntityManager();
		String queryStr = "SELECT s FROM HClassroom s where s.status= :status";
		List<HClassroom> classrooms = null;
		try
		{
			Query query = em.createQuery(queryStr).setParameter("status", "Active");
					
			classrooms =  query.getResultList();
			System.out.println("size = " + classrooms.size());
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
		finally
		{
			em.close();
		}
		return classrooms;
	}
	public static HClassroom getSelectedClassroom(long id)
	{
		EntityManager em = DBUtil.getEmFactory().createEntityManager();
		String queryStr = "SELECT c FROM HClassroom c where c.classroomId = :id";
		System.out.println("Query from getCourses :" + queryStr);
		HClassroom classroom = null;
		try
		{
			TypedQuery<HClassroom> query = em.createQuery(queryStr,HClassroom.class).setParameter("id", id);
			classroom =  query.getSingleResult();
			
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
		finally
		{
			em.close();
		}
		return classroom;
	}
}
