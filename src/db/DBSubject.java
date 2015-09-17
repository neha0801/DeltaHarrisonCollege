package db;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;

import model.HSubject;
import customTools.DBUtil;

public class DBSubject {
	public static List<HSubject> getAllSubjects() {
		EntityManager em = DBUtil.getEmFactory().createEntityManager();
		String queryStr = "SELECT h FROM HSubject h";
		List<HSubject> subjects = null;
		try {
			Query query = em.createQuery(queryStr);
			subjects = query.getResultList();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			em.close();
		}
		return subjects;
	}

	public static HSubject getSubject(long subjectId) {
		EntityManager em = DBUtil.getEmFactory().createEntityManager();
		try {
			HSubject subject = em.find(HSubject.class, subjectId);
			return subject;
		} finally {
			em.close();
		}
	}

	public static void update(HSubject subject) {
		EntityManager em = DBUtil.getEmFactory().createEntityManager();
		EntityTransaction trans = em.getTransaction();
		trans.begin();
		try {
			em.merge(subject);
			trans.commit();
		} catch (Exception e) {
			System.out.println(e);
			trans.rollback();
		} finally {
			em.close();
		}
	}
}
