package com.learning.java.main;

import java.io.File;

import com.learning.java.threads.ReaderThread;

/**
 * Converts CSV to .txt file
 * @author shvetap
 *
 */
public class CSVToText {

	public static void main(String[] args) {

		String csvFile = "Multithreading_Task1_Books.csv";
		createDirectory();
		Thread thread = new Thread(new ReaderThread(csvFile));
		thread.start();
	}

	/**
	 * Creates directory on current path
	 */
	private static void createDirectory() {
		File file = new File("TestDirectory");
		file.mkdir();
	}

}