package com.onb.srs;

import java.util.HashSet;
import java.util.Set;

public class Teacher {
	
	private String name;
	private Set<CourseClass> setOfClassesTeaching = new HashSet<CourseClass>();
	
	public Teacher(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return name;
	}
	
	public void addToClasses(CourseClass courseClass) throws CourseClassException{
		for(CourseClass classTeaching: setOfClassesTeaching){
			if(classTeaching.getSchedule() == courseClass.getSchedule()){
				throw new CourseClassException("Teacher is occupied in the specified Class\' Schedule");
			}
		}
		setOfClassesTeaching.add(courseClass);
	}

	
}
