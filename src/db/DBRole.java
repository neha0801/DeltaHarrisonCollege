package db;

import javax.persistence.EntityManager;
import model.HRole;
import customTools.DBUtil;

public class DBRole {
	public static HRole getRole(long id) {
		EntityManager em = DBUtil.getEmFactory().createEntityManager();
		try {
			HRole user = em.find(HRole.class, id);
			return user;
		} finally {
			em.close();
		}
	}
}
