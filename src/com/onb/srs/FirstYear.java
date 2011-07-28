package com.onb.srs;


public class FirstYear extends YearLevel {

	private static FirstYear instance = new FirstYear();
	
	private static final int MAXIMUM_NUMBER_OF_UNITS = 18;
	private static final int MINIMUM_NUMBER_OF_UNITS = 15;

	private FirstYear(){
		super(MAXIMUM_NUMBER_OF_UNITS, MINIMUM_NUMBER_OF_UNITS);
	}
	
	public static FirstYear getInstance() {
		return instance;
	}

}
