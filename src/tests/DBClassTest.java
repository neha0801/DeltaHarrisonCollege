package tests;

import static org.junit.Assert.*;

import java.util.List;

import model.HClass;
import model.HSemester;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import db.DBClass;
import db.DBSemester;

public class DBClassTest {



//	@Test
//	public void testGetAllClasses() {
//		HSemester semester = DBSemester.getSemester(21);
//		
//		
//		
//		List<HClass> allClasses = DBClass.getAllClasses(semester);
//		
//		for(HClass currentClass : allClasses)
//		{
//			System.out.println("class:" + currentClass.getHCourse().getName());
//		}
//
//		
//	}
	
	@Test 
	public void testGetCurrentSemester()
	{
		HSemester currentSem=DBSemester.getCurrentSemester();
		
		System.out.println("current Semester: "+currentSem.getSeason() + currentSem.getYear());
		
	}

}
