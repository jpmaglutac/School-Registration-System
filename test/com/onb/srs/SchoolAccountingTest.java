package com.onb.srs;

import static org.junit.Assert.*;

import java.math.BigDecimal;

import org.junit.Test;


public class SchoolAccountingTest {
	
	@Test
	public void calculatesTuitionFee() throws Exception {
		Student student = new Student("2001-12345", "Pepe", FourthYear.getInstance());
		Teacher teacher = new Teacher("Mickey");
		Schedule schedule = Schedule.createSchedule(Days.MTH, Hours.FIRST_AFTERNOON);
		Subject subject = new Subject("Hibernate", Level.UNDERGRADUATE);
		CourseClass courseClass = new CourseClass(teacher, subject, schedule);
		student.enroll(courseClass);
		
		BigDecimal tuitionFee = SchoolAccounting.calculateTotalFees(student);
		assertEquals(new BigDecimal(4000), tuitionFee);
	}
	
	@Test
	public void calculatesGraudateTuitionFee() throws Exception {
		Student student = new Student("2001-12345", "Pepe", FourthYear.getInstance());
		Teacher teacher = new Teacher("Mickey");
		Schedule schedule = Schedule.createSchedule(Days.MTH, Hours.FIRST_AFTERNOON);
		Subject subject = new Subject("Hibernate", Level.GRADUATE);
		CourseClass courseClass = new CourseClass(teacher, subject, schedule);
		student.enroll(courseClass);
		
		BigDecimal tuitionFee = SchoolAccounting.calculateTotalFees(student);
		assertEquals(new BigDecimal(6000), tuitionFee);
	}
	
	@Test
	public void calculatesTuitionFeeForTwoSubjects() throws Exception {
		Student student = new Student("2001-12345", "Pepe", FourthYear.getInstance());
		Teacher teacher = new Teacher("Mickey");
		Schedule schedule = Schedule.createSchedule(Days.MTH, Hours.FIRST_AFTERNOON);
		Subject subject = new Subject("Hibernate", Level.UNDERGRADUATE);
		CourseClass courseClass = new CourseClass(teacher, subject, schedule);
		student.enroll(courseClass);
		
		subject = new Subject("Spring", Level.GRADUATE);
		schedule = Schedule.createSchedule(Days.MTH, Hours.MERYENDA);
		courseClass = new CourseClass(teacher, subject, schedule);
		student.enroll(courseClass);
		
		BigDecimal tuitionFee = SchoolAccounting.calculateTotalFees(student);
		assertEquals(new BigDecimal(8000), tuitionFee);
	}
	
	@Test
	public void calculatesTuitionFeeForHalfScholar() throws Exception {
		Student student = new Student("2001-12345", "Pepe", FourthYear.getInstance(), HalfScholarship.getInstance());
		Teacher teacher = new Teacher("Mickey");
		Schedule schedule = Schedule.createSchedule(Days.MTH, Hours.FIRST_AFTERNOON);
		Subject subject = new Subject("Hibernate", Level.UNDERGRADUATE);
		CourseClass courseClass = new CourseClass(teacher, subject, schedule);
		student.enroll(courseClass);
		
		BigDecimal tuitionFee = SchoolAccounting.calculateTotalFees(student);
		assertEquals(new BigDecimal(3000), tuitionFee);
	}
	
	@Test
	public void calculatesTuitionFeeForFullScholar() throws Exception {
		Student student = new Student("2001-12345", "Pepe", FourthYear.getInstance(), FullScholarship.getInstance());
		Teacher teacher = new Teacher("Mickey");
		Schedule schedule = Schedule.createSchedule(Days.MTH, Hours.FIRST_AFTERNOON);
		Subject subject = new Subject("Hibernate", Level.UNDERGRADUATE);
		CourseClass courseClass = new CourseClass(teacher, subject, schedule);
		student.enroll(courseClass);
		
		subject = new Subject("Spring", Level.GRADUATE);
		schedule = Schedule.createSchedule(Days.MTH, Hours.MERYENDA);
		courseClass = new CourseClass(teacher, subject, schedule);
		student.enroll(courseClass);
		
		BigDecimal tuitionFee = SchoolAccounting.calculateTotalFees(student);
		assertEquals(new BigDecimal(2000), tuitionFee);
	}
	
	@Test(expected=TuitionFeeException.class)
	public void doesNotCalculateTuitionFeeIfBelowMinimumUnits() throws Exception {
		Student student = new Student("2001-12345", "Pepe", FirstYear.getInstance());
		Teacher teacher = new Teacher("Mickey");
		Schedule schedule = Schedule.createSchedule(Days.MTH, Hours.FIRST_AFTERNOON);
		Subject subject = new Subject("Hibernate", Level.UNDERGRADUATE);
		CourseClass courseClass = new CourseClass(teacher, subject, schedule);
		student.enroll(courseClass);
		
		BigDecimal tuitionFee = SchoolAccounting.calculateTotalFees(student);
		assertEquals(new BigDecimal(4000), tuitionFee);
	}

}
