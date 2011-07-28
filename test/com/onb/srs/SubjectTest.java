package com.onb.srs;

import static org.junit.Assert.*;

import java.util.HashSet;
import java.util.Set;

import org.junit.Test;

public class SubjectTest {
	@Test
	public void shouldCreateSubject() throws Exception {
		Subject math = new Subject("Math", Level.GRADUATE);
		assertEquals("Math", math.toString());
	}
	
	@Test
	public void shouldCreateDifferentSubject() throws Exception {
		Subject english = new Subject("English", Level.GRADUATE );
		assertEquals("English", english.toString());
	}
	
	@Test
	public void shouldHavePrerequisite() throws Exception {
		Subject english1 = new Subject("English1", Level.GRADUATE);
		Subject english2 = new Subject("English2", Level.GRADUATE, english1);
		assertTrue(english2.getPrerequisites().contains(english1));
	}
	@Test
	public void shouldHaveGraduateLevel() throws Exception {
		Subject science = new Subject("science", Level.GRADUATE);
		assertEquals(Level.GRADUATE, science.getLevel());
	}
	
	@Test
	public void shouldHaveUnderGraduateLevel() throws Exception {
		Subject science = new Subject("science", Level.UNDERGRADUATE);
		assertEquals(Level.UNDERGRADUATE, science.getLevel());
	}
	
	@Test
	public void checkPrerequisites() throws Exception {
		Subject english1 = new Subject("English1", Level.GRADUATE);
		Subject math = new Subject("Math", Level.UNDERGRADUATE);
		Subject english2 = new Subject("English2", Level.GRADUATE, english1);
		Set<Subject> passed = new HashSet<Subject>();
		passed.add(math);
		assertFalse(english2.hasPrerequisites(passed));
		passed.add(english1);
		assertTrue(english2.hasPrerequisites(passed));
	}
	
	@Test
	public void checkTwoPrerequisites() throws Exception {
		Subject english = new Subject("English", Level.GRADUATE);
		Subject math = new Subject("Math", Level.UNDERGRADUATE);
		Subject mathematicalEnglish = new Subject("English2", Level.GRADUATE, english, math);
		Set<Subject> passed = new HashSet<Subject>();
		passed.add(math);
		assertFalse(mathematicalEnglish.hasPrerequisites(passed));
		passed.add(english);
		assertTrue(mathematicalEnglish.hasPrerequisites(passed));
	}
}
