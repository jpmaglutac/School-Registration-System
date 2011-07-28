package com.onb.srs;

import java.math.BigDecimal;

public class FullScholarship implements Scholarship {
	private static FullScholarship instance = new FullScholarship();

	private FullScholarship(){
	}
	
	public static FullScholarship getInstance() {
		return instance;
	}

	@Override
	public BigDecimal discountTuition(BigDecimal tuition) {
		return BigDecimal.ZERO;
	}
}
