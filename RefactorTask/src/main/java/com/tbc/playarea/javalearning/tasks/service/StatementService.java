package com.tbc.playarea.javalearning.tasks.service;

import java.util.List;

/**
 * Service class to generate statement for rentals
 * 
 * @author shvetap
 *
 */
public interface StatementService<T> {

	/**
	 * To generate statement
	 * 
	 * @param rentals
	 *            List of rentals
	 * @param name
	 *            Name of customer for whom the statement has to be generated
	 */
	public void generateStatement(List<T> rentals, String name);

}