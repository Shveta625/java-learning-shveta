package com.learning.java.observers;

import com.learning.java.util.Observable;
import com.learning.java.util.Observer;

public class Feed implements Observer {

	@Override
	public void update(Observable observable) {
		System.out.println("Feed updated");
	}

}
