package com.onb.srs;

import java.math.BigDecimal;

public class NoScholarship implements Scholarship {
	private static NoScholarship instance = new NoScholarship();

	private NoScholarship(){
	}
	
	public static NoScholarship getInstance() {
		return instance;
	}

	@Override
	public BigDecimal discountTuition(BigDecimal tuition) {
		return tuition;
	}

}
