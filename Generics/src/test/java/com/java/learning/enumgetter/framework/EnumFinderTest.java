package com.java.learning.enumgetter.framework;

import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

import com.java.learning.enums.DaysOfWeek;
import com.java.learning.enums.Directions;

/**
 * Test class to test {@link EnumFinder}
 * 
 * @author shvetap
 *
 */
public class EnumFinderTest {

	EnumFinder enumFinder;
	@Before
	public void setup() {
		enumFinder=new EnumFinder();
	}
	
	/**
	 * Testing if {@link Directions} instance could be found
	 */
	@Test
	public void testEnumFinderWithDirections() {
		Directions direction=enumFinder.findEnum(Directions.class, "north");
		assertTrue("Enum found is incorrect", direction==Directions.NORTH);
	}
	
	/**
	 * Testing if {@link DaysOfWeek} instance could be found
	 */
	@Test
	public void testEnumFinderWithDaysOfWeek() {
		DaysOfWeek day=enumFinder.findEnum(DaysOfWeek.class, 5);
		assertTrue("Enum found is incorrect", day==DaysOfWeek.FRI);
	}
}
