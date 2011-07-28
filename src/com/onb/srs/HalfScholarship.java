package com.onb.srs;

import java.math.BigDecimal;

public class HalfScholarship implements Scholarship {
	private static HalfScholarship instance = new HalfScholarship();

	private HalfScholarship(){
	}
	
	public static HalfScholarship getInstance() {
		return instance;
	}

	@Override
	public BigDecimal discountTuition(BigDecimal tuition) {
		return tuition.divide(new BigDecimal(2));
	}
}
