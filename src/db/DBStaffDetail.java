package db;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import model.HClass;
import model.HStaffDetail;
import customTools.DBUtil;

public class DBStaffDetail {
	public static HStaffDetail getUser(long userId) {
		EntityManager em = DBUtil.getEmFactory().createEntityManager();
		try {
			HStaffDetail user = em.find(HStaffDetail.class, userId);
			return user;
		} finally {
			em.close();
		}
	}
	
	
}
