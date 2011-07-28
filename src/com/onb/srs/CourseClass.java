package com.onb.srs;

import java.math.BigDecimal;
import java.util.Set;

public class CourseClass {
	
	private Teacher teacher;
	private Subject subject;
	private Schedule schedule;

	public CourseClass(Teacher teacher, Subject subject, Schedule schedule) throws CourseClassException {
		this.teacher = teacher;
		this.subject = subject;
		this.schedule = schedule;
		teacher.addToClasses(this);
	}

	public Teacher getTeacher() {
		return teacher;
	}

	public Subject getSubject() {
		return subject;
	}

	public Schedule getSchedule() {
		return schedule;
	}

	public boolean hasPrerequisites(Set<Subject> subjectsPassed) {
		return subject.hasPrerequisites(subjectsPassed);
	}

	public BigDecimal getFee() {
		return subject.getFee();
	}

}
