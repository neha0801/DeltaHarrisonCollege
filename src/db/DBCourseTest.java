package db;

import static org.junit.Assert.*;

import java.util.List;

import model.HCourse;

import org.junit.Test;

public class DBCourseTest {

	@Test
	public void testGetAllCourses() {
		List<HCourse> courses = DBCourse.getAllCourses();
		
		for(HCourse course : courses)
		{
			System.out.println(course.getCourseNumber() + course.getDescription());
		}
	}

}
