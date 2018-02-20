package com.java.learning.enums;

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
