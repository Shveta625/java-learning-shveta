package com.java.learning.enums;

/**
 * Enum for days of week.
 * 
 * @author shvetap
 *
 */
public enum DaysOfWeek  {

	MON(1), TUES(2), WED(3), THURS(4), FRI(5), SAT(6), SUN(7);
	
	private Integer dayNumber;

	private DaysOfWeek(int dayNumber) {
		this.dayNumber = dayNumber;
	}
	
	public Integer getValue() {
		return dayNumber;
	}
}
