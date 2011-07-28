package com.onb.srs;


import java.math.BigDecimal;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Student {

	private String studentNumber;
	private String name;
	private YearLevel yearLevel;
	private Scholarship scholarship = NoScholarship.getInstance();
	private Set<CourseClass> setOfCourseClasses = new HashSet<CourseClass>();
	private Set<Subject> subjectsPassed = new HashSet<Subject>();
	
	public Student(String studentNumber, String name, YearLevel yearLevel) {
		this.studentNumber = studentNumber;
		this.name = name;
		this.yearLevel = yearLevel;
	}

	public Student(String studentNumber, String name, YearLevel yearLevel, Scholarship scholarship) {
		this(studentNumber, name, yearLevel);
		this.scholarship = scholarship;
	}

	public String getName() {
		return name;
	}

	public YearLevel getYearLevel() {
		return yearLevel;
	}

	public Scholarship getScholarship() {
		return scholarship;
	}

	public String getStudentNumber() {
		return studentNumber;
	}

	public void enroll(CourseClass courseClass) throws EnrollmentException {
		validateScheduleConflict(courseClass);
		validatePrerequisites(courseClass);
		validateMaximumUnits();
		setOfCourseClasses.add(courseClass);
	}

	private void validateMaximumUnits() throws EnrollmentException {
		if(!yearLevel.validateUnits(getTotalUnitsEnrolled()+3))
			throw new EnrollmentException("Student already has maximum number of units");
	}

	private void validatePrerequisites(CourseClass courseClass)
			throws EnrollmentException {
		if(!courseClass.hasPrerequisites(subjectsPassed))
			throw new EnrollmentException("Student has not taken required prerequisite");
	}

	private void validateScheduleConflict(CourseClass courseClass)
			throws EnrollmentException {
		if(hasScheduleConflict(courseClass))
			throw new EnrollmentException("Conflict in schedule detected");
	}
	
	private int getTotalUnitsEnrolled(){
		return setOfCourseClasses.size()*3;
	}

	private boolean hasScheduleConflict(CourseClass courseClass){
		for(CourseClass classEnrolled: setOfCourseClasses){
			if(classEnrolled.getSchedule() == courseClass.getSchedule())
				return true;
		}
		return false;
	}

	public boolean isEnrolledIn(CourseClass courseClass) {
		return setOfCourseClasses.contains(courseClass);
	}

	public void addToSubjectsPassed(Subject... subjects) {
		subjectsPassed.addAll(Arrays.asList(subjects));
	}
	
	protected BigDecimal calculateTuitionFee() throws TuitionFeeException{
		validateMinimumUnits();
		BigDecimal tuition = new BigDecimal(0);
		for(CourseClass courseClass : setOfCourseClasses){
			tuition = tuition.add(courseClass.getFee());
		}
		tuition = scholarship.discountTuition(tuition);
		return tuition;
	}

	private void validateMinimumUnits() throws TuitionFeeException  {
		if(!yearLevel.hasMinimumUnits(getTotalUnitsEnrolled()))
			throw new TuitionFeeException("Student has not enrolled the minimum amount of units");
	}

}
