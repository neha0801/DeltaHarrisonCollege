package db;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;

import model.HClassroom;
import model.HCourse;
import customTools.DBUtil;

public class DBClassroom {
	
	public static List<HClassroom>  getAllClassrooms() {
		EntityManager em = DBUtil.getEmFactory().createEntityManager();
		String queryStr = "SELECT h FROM HClassroom h";
		List<HClassroom> classroom = null;
		try {
			Query query = em.createQuery(queryStr);
			classroom = query.getResultList();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			em.close();
		}
		return classroom;
	}
	
	public static HClassroom getClassroom(long classroom)
	{
		EntityManager em = DBUtil.getEmFactory().createEntityManager();
		try
		{
			HClassroom classrooms= em.find(HClassroom.class, classroom);
			return classrooms;
		}
		finally
		{
			em.close();
		}
	}
	public static void update(HClassroom classroom) 
	{
		EntityManager em = DBUtil.getEmFactory().createEntityManager();
		EntityTransaction trans = em.getTransaction();
		trans.begin(); 
		try 
		{
			em.merge(classroom);
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
}
