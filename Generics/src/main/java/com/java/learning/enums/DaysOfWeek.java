package com.java.learning.enums;

public enum DaysOfWeek  {

	MON(1), TUES(2), WED(3), THURS(4), FRI(5), SAT(6), SUN(7);
	
	private Integer value;

	private DaysOfWeek(int value) {
		this.value = value;
	}
	
	public Integer getValue() {
		return value;
	}
}
