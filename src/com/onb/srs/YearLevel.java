package com.onb.srs;

public abstract class YearLevel {
	
	private int maximumNumberOfUnits;
	private int minimumNumberOfUnits;
	
	protected YearLevel(int maximumNumberOfUnits, int minimumNumberOfUnits){
		this.maximumNumberOfUnits = maximumNumberOfUnits;
		this.minimumNumberOfUnits = minimumNumberOfUnits;
	}
	
	public boolean validateUnits(int numberOfUnits){
		return numberOfUnits <= maximumNumberOfUnits;
	}
	
	public boolean hasMinimumUnits(int numberOfUnits){
		return numberOfUnits >= minimumNumberOfUnits;
	}
}
