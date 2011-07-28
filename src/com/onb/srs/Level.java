package com.onb.srs;

import java.math.BigDecimal;

public enum Level {
	GRADUATE(new BigDecimal(4000)),
	UNDERGRADUATE(new BigDecimal(2000));
	
	private BigDecimal value;
	
	private Level(BigDecimal value){
		this.value = value;
	}

	public BigDecimal getValue() {
		return value;
	}


}
