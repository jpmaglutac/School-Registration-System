package com.onb.srs;

import static org.junit.Assert.*;

import org.junit.Test;


public class StudentTest {
	
	@Test
	public void shouldHaveStudentNumber() throws Exception {
		YearLevel firstYear = FirstYear.getInstance();
		Student student = new Student("2011-12345","Pepe", firstYear);
		assertEquals("2011-12345", student.getStudentNumber());		

	}
	
	@Test
	public void shouldHaveCorrectName() throws Exception {
		YearLevel firstYear = FirstYear.getInstance();
		Student student = new Student("2011-12345", "Yhan", firstYear);
		assertEquals("Yhan",student.getName());
	}
	
	@Test
	public void shouldHaveCorrectYearLevel() throws Exception {
		YearLevel secondYear = SecondYear.getInstance();
		Student student = new Student("2011-12345", "Mickey", secondYear);
		assertTrue(student.getYearLevel() instanceof SecondYear);
	}
	
	@Test
	public void shouldHaveFullScholarShip() throws Exception {
		YearLevel firstYear = FirstYear.getInstance();
		Scholarship fullScholarship = FullScholarship.getInstance();
		Student student = new Student("2011-12345", "Pepe", firstYear, fullScholarship);
		assertTrue(student.getScholarship() instanceof FullScholarship);
	}
	
	@Test
	public void shouldHaveHalfScholarship() throws Exception {
		YearLevel firstYear = FirstYear.getInstance();
		Scholarship halfScholarship = HalfScholarship.getInstance();
		Student student = new Student("2011-12345", "Pepe", firstYear, halfScholarship);
		assertTrue(student.getScholarship() instanceof HalfScholarship);
	}
	
}
