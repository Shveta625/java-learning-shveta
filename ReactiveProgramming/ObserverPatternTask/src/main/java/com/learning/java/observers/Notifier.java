package com.learning.java.observers;

import com.learning.java.util.Observable;
import com.learning.java.util.Observer;

public class Notifier implements Observer {

	@Override
	public void update(Observable observable) {
		System.out.println("Notifier updated");
	}

}
