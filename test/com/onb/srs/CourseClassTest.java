package com.onb.srs;

import static org.junit.Assert.*;

import org.junit.Test;


public class CourseClassTest {
	@Test
	public void shouldCreateClass() throws Exception {
		Teacher calen = new Teacher("Calen");
		Subject math = new Subject("Math", Level.GRADUATE);
		Schedule firstMorningMTH = Schedule.createSchedule(Days.MTH, Hours.FIRST_MORNING);
		CourseClass courseClass = new CourseClass(calen, math, firstMorningMTH);
		assertEquals("Calen", courseClass.getTeacher().toString());
		assertEquals("Math", courseClass.getSubject().toString());
		assertEquals("M/TH 8:30AM-10AM", courseClass.getSchedule().toString());
	}
	
	@Test(expected=CourseClassException.class)
	public void shouldNotCreateClassIfTeacherIsOccupiedOnSchedule() throws Exception{
		Teacher calen = new Teacher("Calen");
		Subject math = new Subject("Math", Level.GRADUATE);
		Schedule firstMorningMTH = Schedule.createSchedule(Days.MTH, Hours.FIRST_MORNING);
		new CourseClass(calen, math, firstMorningMTH);
		Subject english = new Subject("English", Level.GRADUATE);
		new CourseClass(calen, english, firstMorningMTH);
	}
	
}
