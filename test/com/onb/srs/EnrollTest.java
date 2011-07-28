package com.onb.srs;

import static org.junit.Assert.*;

import org.junit.Test;


public class EnrollTest {
	
	Teacher teacher = new Teacher("Calen");
	Subject subject = new Subject("Math", Level.GRADUATE);
	Schedule schedule = Schedule.createSchedule(Days.MTH, Hours.FIRST_MORNING);
	Student student = new Student("2011-12345", "Yhan", FirstYear.getInstance());
	
	@Test
	public void studentShouldSuccessfullyEnroll() throws Exception {
		CourseClass courseClass = new CourseClass(teacher, subject, schedule);
		student.enroll(courseClass);
		assertTrue(student.isEnrolledIn(courseClass));
	}
	
	@Test
	public void enrollmentShouldFailIfDuplicateClass() throws Exception {
		CourseClass courseClass = new CourseClass(teacher, subject, schedule);
		student.enroll(courseClass);
		assertTrue(student.isEnrolledIn(courseClass));
		Teacher newTeacher = new Teacher("Mike");
		CourseClass duplicateClass = new CourseClass(newTeacher, subject, schedule);
		try{
			student.enroll(duplicateClass);
			fail("Expected EnrollmentException to be thrown");
		}catch(EnrollmentException e){
			assertEquals("Conflict in schedule detected", e.getMessage());
		}
	}
	
	@Test
	public void enrollmentShouldFailIfNoPrerequisite() throws Exception {
		Subject prerequisiteSubject = new Subject("Math 2", Level.GRADUATE, subject);
		CourseClass prerequisiteClass = new CourseClass(teacher, prerequisiteSubject, schedule);
		try{
			student.enroll(prerequisiteClass);
			fail("Expected EnrollmentException to be thrown");
		}catch(EnrollmentException e){
			assertEquals("Student has not taken required prerequisite", e.getMessage());
		}
	}
	
	@Test
	public void enrollmentShouldPassIfHasPrerequisite() throws Exception {
		student.addToSubjectsPassed(subject);
		Subject prerequisiteSubject = new Subject("Math 2", Level.GRADUATE, subject);
		CourseClass prerequisiteClass = new CourseClass(teacher, prerequisiteSubject, schedule);
		student.enroll(prerequisiteClass);
		assertTrue(student.isEnrolledIn(prerequisiteClass));
	}
	
	@Test
	public void enrollmentShouldFailIfAboveMaximumUnits() throws Exception {
		for(int x = 0; x != 6; x++){
			Schedule newSched = Schedule.createSchedule(Days.WS, Hours.values()[x]);
			student.enroll(new CourseClass(teacher, subject, newSched));
		}
		try{
			CourseClass newClass = new CourseClass(teacher, subject, Schedule.createSchedule(Days.TF, Hours.FIRST_MORNING));
			student.enroll(newClass);
			fail("Expected EnrollmentException to be thrown");
		}catch(EnrollmentException e){
			assertEquals("Student already has maximum number of units", e.getMessage());
		}
	}
}
