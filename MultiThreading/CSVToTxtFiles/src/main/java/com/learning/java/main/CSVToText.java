package com.learning.java.main;

import java.io.File;

import com.learning.java.threads.ReaderThread;

public class CSVToText {

	public static void main(String[] args) {

		String csvFile = "Multithreading_Task1_Books.csv";
		createDirectory();
		Thread thread = new Thread(new ReaderThread(csvFile));
		thread.start();
	}

	private static void createDirectory() {
		File file = new File("TestDirectory");
		file.mkdir();
	}

}