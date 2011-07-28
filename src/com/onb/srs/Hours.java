package com.onb.srs;

public enum Hours {
	FIRST_MORNING("8:30AM-10AM"), 
	SECOND_MORNING("10AM-11:30AM"),
	LUNCH("11:30AM-1PM"),
	FIRST_AFTERNOON("1PM-2:30PM"),
	SECOND_AFTERNOON("2:30PM-4PM"),
	MERYENDA("4PM-5:30PM");

	private String name;
	
	Hours(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return name;
	}
	
	
}
