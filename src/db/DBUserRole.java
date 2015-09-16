package db;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import model.HUserRole;
import customTools.DBUtil;

public class DBUserRole {
	
	public static void insert(HUserRole userRole) {
		EntityManager em = DBUtil.getEmFactory().createEntityManager();
		EntityTransaction trans = em.getTransaction();
		trans.begin();
		try {
			em.persist(userRole);
			trans.commit();
		} catch (Exception e) {
			System.out.println(e);
			trans.rollback();
		} finally {
			em.close();
		}
	}
}
