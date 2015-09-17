package db;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import model.HClassSchedule;
import customTools.DBUtil;

public class DBClassSchedule {
	public static void insert(HClassSchedule schedule) {
		EntityManager em = DBUtil.getEmFactory().createEntityManager();
		EntityTransaction trans = em.getTransaction();
		trans.begin();
		try {
			em.persist(schedule);
			trans.commit();
		} catch (Exception e) {
			System.out.println(e);
			trans.rollback();
		} finally {
			em.close();
		}
	}
}
