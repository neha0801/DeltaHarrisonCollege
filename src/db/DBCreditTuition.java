package db;

import javax.persistence.EntityManager;




import javax.persistence.EntityTransaction;

import model.HClass;
import model.HCreditTuition;
import customTools.DBUtil;

public class DBCreditTuition {
	
	public static long getLatestFeeID() {
		// method to return the userId

		EntityManager em = DBUtil.getEmFactory().createEntityManager();
		// query to return the user Id
		String query = "SELECT max(d.creditTuitionId )FROM HCreditTuition d ";
		System.out.println(query);
		try {
			long l = (long) em.createQuery(query)
					.getSingleResult();
			return l;
		} catch (Exception e) {
			return 0;
		} finally {
			em.close();
		}
	}
	
	public static HCreditTuition getCreditTuitionFee(long id) {
		EntityManager em = DBUtil.getEmFactory().createEntityManager();
		try {
			HCreditTuition weekday = em.find(HCreditTuition.class, id);
			return weekday;
		} finally {
			em.close();
		}
	}
	
	public static void insert(HCreditTuition newCredit) {
		EntityManager em = DBUtil.getEmFactory().createEntityManager();
		EntityTransaction trans = em.getTransaction();
		trans.begin();
		try {
			em.persist(newCredit);
			trans.commit();
			
		} catch (Exception e) {
			System.out.println(e);
			trans.rollback();
		} finally {
			em.close();
		}
		
	}


}
