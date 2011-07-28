package com.onb.srs;


public class FourthYear extends YearLevel {
	private static FourthYear instance = new FourthYear();
	
	private static final int MAXIMUM_NUMBER_OF_UNITS = 21;
	private static final int MINIMUM_NUMBER_OF_UNITS = 0;

	private FourthYear(){
		super(MAXIMUM_NUMBER_OF_UNITS, MINIMUM_NUMBER_OF_UNITS);
	}
	
	public static FourthYear getInstance() {
		return instance;
	}

}
