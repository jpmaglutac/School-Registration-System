package com.onb.srs;


public class SecondYear extends YearLevel {
	private static SecondYear instance = new SecondYear();
	
	private static final int MAXIMUM_NUMBER_OF_UNITS = 24;
	private static final int MINIMUM_NUMBER_OF_UNITS = 18;

	private SecondYear(){
		super(MAXIMUM_NUMBER_OF_UNITS, MINIMUM_NUMBER_OF_UNITS);
	}
	
	public static SecondYear getInstance() {
		return instance;
	}

}
