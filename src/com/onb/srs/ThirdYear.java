package com.onb.srs;


public class ThirdYear extends YearLevel {
	private static ThirdYear instance = new ThirdYear();
	
	private static final int MAXIMUM_NUMBER_OF_UNITS = 24;
	private static final int MINIMUM_NUMBER_OF_UNITS = 18;

	private ThirdYear(){
		super(MAXIMUM_NUMBER_OF_UNITS, MINIMUM_NUMBER_OF_UNITS);
	}
	
	public static ThirdYear getInstance() {
		return instance;
	}

}
