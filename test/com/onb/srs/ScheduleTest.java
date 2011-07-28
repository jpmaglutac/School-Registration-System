package com.onb.srs;

import static org.junit.Assert.*;

import org.junit.Test;


public class ScheduleTest {
	
	@Test
	public void shouldCreateSchedule() throws Exception {
		Schedule schedule = Schedule.createSchedule(Days.MTH, Hours.FIRST_MORNING);
		assertEquals("M/TH 8:30AM-10AM", schedule.toString());
	}
	
	@Test
	public void shouldCreateDifferentSchedule() throws Exception {
		Schedule schedule = Schedule.createSchedule(Days.TF, Hours.LUNCH);
		assertEquals("T/F 11:30AM-1PM", schedule.toString());
	}
	
	@Test
	public void shouldUseSameSchedule(){
		Schedule schedule1 = Schedule.createSchedule(Days.MTH, Hours.FIRST_MORNING);
		Schedule schedule2 = Schedule.createSchedule(Days.MTH, Hours.FIRST_MORNING);
		assertEquals(schedule1, schedule2);
	}
}
