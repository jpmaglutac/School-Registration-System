package com.onb.srs;

import static org.junit.Assert.*;

import org.junit.Test;


public class TeacherTest {
	@Test
	public void shouldCreateTeacher() throws Exception {
		Teacher teacher = new Teacher("Calen");
		assertEquals("Calen", teacher.toString());
	}
	
	@Test
	public void shouldCreateDifferentTeacher() throws Exception {
		Teacher teacher = new Teacher("Mike");
		assertEquals("Mike", teacher.toString());
	}
	
}
