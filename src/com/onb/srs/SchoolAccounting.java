package com.onb.srs;

import java.math.BigDecimal;

public class SchoolAccounting {
	
	private static final BigDecimal MISCELLANOUS_FEES = new BigDecimal(2000);

	public static BigDecimal calculateTotalFees(Student student) throws TuitionFeeException {
		BigDecimal tuition = student.calculateTuitionFee();
		return tuition.add(MISCELLANOUS_FEES);
	}

}
