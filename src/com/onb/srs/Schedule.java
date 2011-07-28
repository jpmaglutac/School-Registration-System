package com.onb.srs;

import java.util.HashSet;
import java.util.Set;

public class Schedule {

	private Days days;
	private Hours hours;
	private static Set<Schedule> listOfSchedules = new HashSet<Schedule>();
	
	private Schedule(Days days, Hours hours) {
		this.days = days;
		this.hours = hours;
	}
	
	public static Schedule createSchedule(Days days, Hours hours) {
		for(Schedule sched: listOfSchedules){
			if(sched.days == days && sched.hours == hours){
				return sched;
			}
		}
		Schedule sched = new Schedule(days, hours);
		listOfSchedules.add(sched);
		return sched;
	}
	
	@Override
	public String toString() {
		return days.toString() + " " + hours.toString();
	}

	

}
