package com.onb.srs;

public enum Days {
	MTH("M/TH"), 
	TF("T/F"),
	WS("W/S");
	
	private String name;
	Days(String name) {
		this.name = name;
	}
	
	@Override
	public String toString() {
		return name;
	}
	
	
}
