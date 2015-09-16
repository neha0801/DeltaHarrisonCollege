package tests;

import static org.junit.Assert.*;
import model.HClass;
import model.HUser;

import org.junit.Before;
import org.junit.Test;

import db.DBClass;
import db.DBUserDetail;

public class HStudentDetailTest {
	@Test
	public void testIsTimeOk() {
		HUser user = DBUserDetail.getUser(2);
		HClass newClass = DBClass.getClass(6);
		assertFalse(user.getHStudentDetail().isTimeOk(newClass));
		
		newClass = DBClass.getClass(5);
		assertTrue(user.getHStudentDetail().isTimeOk(newClass));
	}

}
