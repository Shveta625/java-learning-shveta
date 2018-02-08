package com.tbc.playarea.javalearning.tasks.service.impl;

import java.util.List;

import com.tbc.playarea.javalearning.tasks.refactor.Rental;

/**
 * Implementation to generate statement on console
 * @author shvetap
 *
 */
public class RentalConsoleStatementGenerator  extends RentalStatementServiceImpl{

	@Override
	public void generateStatement(List<Rental> rentals, String name) {
		super.generateStatement(rentals, name);
		System.console().writer().println(result.toString());	
	}

}
