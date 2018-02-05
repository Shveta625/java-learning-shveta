package com.learning.java.threads;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

public class WriterThread implements Runnable {

	String title;
	String data;

	public WriterThread(String title, String data) {
		super();
		this.title = title;
		this.data = data;
	}

	@Override
	public void run() {

		try {
			Files.write(Paths.get("TestDirectory/" + title.replaceAll("/", "|") + ".txt"), data.getBytes(), StandardOpenOption.CREATE,
					StandardOpenOption.APPEND);
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

}
