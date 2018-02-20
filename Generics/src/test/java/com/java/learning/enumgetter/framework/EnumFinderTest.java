package com.java.learning.enumgetter.framework;

import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

import com.java.learning.enums.DaysOfWeek;
import com.java.learning.enums.Directions;

public class EnumFinderTest {

	EnumFinder enumFinder;
	@Before
	public void setup() {
		enumFinder=new EnumFinder();
	}
	
	
	@Test
	public void testEnumFinderWithDirection() {
		Directions direction=enumFinder.findEnum(Directions.class, "north");
		assertTrue("Enum found is incorrect", direction==Directions.NORTH);
	}
	
	@Test
	public void testEnumFinderWithDaysOfWeek() {
		DaysOfWeek day=enumFinder.findEnum(DaysOfWeek.class, 5);
		assertTrue("Enum found is incorrect", day==DaysOfWeek.FRI);
	}
}
