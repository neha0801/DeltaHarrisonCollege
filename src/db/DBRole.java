package db;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import model.HRole;
import model.HUser;
import customTools.DBUtil;

public class DBRole {
	public static HRole getRole(long roleId) {
		EntityManager em = DBUtil.getEmFactory().createEntityManager();
		try {
			HRole role = em.find(HRole.class, roleId);
			return role;
		}
		catch (Exception e)
		{
			e.printStackTrace();
			return null;	
			}
			finally {
		
			em.close();
		}
	}
	

}
