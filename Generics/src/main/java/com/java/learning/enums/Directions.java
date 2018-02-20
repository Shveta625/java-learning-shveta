package com.java.learning.enums;

/**
 * Enum for directions.
 * 
 * @author shvetap
 *
 */
public enum Directions {

	NORTH("north"), SOUTH("south"), EAST("east"), WEST("west");
	
	private String value;

	private Directions(String value) {
		this.value = value;
	}
	
	public String getValue() {
		return value;
	}
}
