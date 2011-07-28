package com.onb.srs;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Subject {

	private String name;
	private Level level;
	private Set<Subject> prerequisites = new HashSet<Subject>();
	
	public Subject(String name, Level level) {
		this.name = name;
		this.level = level;
	}

	public Subject(String name, Level level, Subject... prerequisites) {
		this(name, level);
		this.prerequisites.addAll(Arrays.asList(prerequisites));
	}
	
	@Override
	public String toString() {
		return name;
	}

	public Set<Subject> getPrerequisites() {
		return prerequisites;
	}

	

	public Level getLevel() {
		return level;
	}

	public boolean hasPrerequisites(Set<Subject> subjectsPassed) {
		prerequisiteLoop:
		for(Subject prerequisite: prerequisites){
			for(Subject passed: subjectsPassed){
				if(passed == prerequisite){
					continue prerequisiteLoop;
				}
			}
			return false;
		}
		return true;
	}

	public BigDecimal getFee() {
		return level.getValue();
	}
	
	

}
