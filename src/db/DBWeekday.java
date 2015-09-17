package db;

import javax.persistence.EntityManager;


import model.HWeekday;
import customTools.DBUtil;

public class DBWeekday {
	public static HWeekday getWeekDay(long id) {
		EntityManager em = DBUtil.getEmFactory().createEntityManager();
		try {
			HWeekday weekday = em.find(HWeekday.class, id);
			return weekday;
		} finally {
			em.close();
		}
	}
}
