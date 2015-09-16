package tests;

import static org.junit.Assert.*;

import java.util.List;

import model.HUser;

import org.junit.Before;
import org.junit.Test;

import db.DBUserDetail;

public class HUserTest {
	

	
	@Before
	public void setUp() throws Exception 
	{

		
	}

	@Test
	public void testRole() {
		HUser user = DBUserDetail.getUser(1);
		assertTrue(user.isAdmin());
		assertFalse(user.isStudent());
		assertFalse(user.isAdvisor());
		assertFalse(user.isInstructor());
		
		user = DBUserDetail.getUser(2);
		assertFalse(user.isAdmin());
		assertTrue(user.isStudent());
		assertFalse(user.isAdvisor());
		assertFalse(user.isInstructor());
	}



}
