package db;

import static org.junit.Assert.*;

import java.util.List;

import model.HClass;
import model.HSemester;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class DBClassTest {



	@Test
	public void testGetAllClasses() {
		HSemester semester = DBSemester.getSemester(21);
		
		System.out.println("semester:" + semester.getSeason() + semester.getYear());
		
		List<HClass> allClasses = DBClass.getAllClasses(semester);
		
		for(HClass currentClass : allClasses)
		{
			System.out.println("class:" + currentClass.getHCourse().getName());
		}

		
	}

}
