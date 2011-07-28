package com.onb.srs;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;


public class YearLevelTest {
	
	@Test
	public void shouldAllowMaximumUnits() throws Exception {
		YearLevel firstYear = FirstYear.getInstance();
		assertTrue(firstYear.validateUnits(18));
	}
	
	@Test
	public void shouldNotAllowMoreThanMaximumUnits() throws Exception {
		YearLevel firstYear = FirstYear.getInstance();
		assertFalse(firstYear.validateUnits(19));
	}
	
	@Test
	public void secondYearShouldNotAllowMoreThanMaximumUnits() throws Exception {
		YearLevel secondYear = SecondYear.getInstance();
		assertFalse(secondYear.validateUnits(26));
	}
	
	@Test
	public void thirdYearShouldNotAllowMoreThanMaximumUnits() throws Exception {
		YearLevel thirdYear = ThirdYear.getInstance();
		assertFalse(thirdYear.validateUnits(25));
	}
	
	@Test
	public void fourthYearShouldNotAllowMoreThanMaximumUnits() throws Exception {
		YearLevel fourthYear = FourthYear.getInstance();
		assertFalse(fourthYear.validateUnits(22));
	}
	
	@Test
	public void shouldAllowMinimumUnits() throws Exception {
		YearLevel fourthYear = FourthYear.getInstance();
		assertTrue(fourthYear.hasMinimumUnits(0));
	}
	
	@Test
	public void firstYearshouldNotAllowLessThanMinimumUnits() throws Exception {
		YearLevel firstYear = FirstYear.getInstance();
		assertFalse(firstYear.hasMinimumUnits(12));
	}
	
	@Test
	public void secondYearShouldNotAllowLessThanMinimumUnits() throws Exception {
		YearLevel secondYear = SecondYear.getInstance();
		assertFalse(secondYear.hasMinimumUnits(15));
	}
	
	@Test
	public void thirdYearShouldNotAllowLessThanMinimumUnits() throws Exception {
		YearLevel thirdYear = ThirdYear.getInstance();
		assertFalse(thirdYear.hasMinimumUnits(15));
	}
	
}
