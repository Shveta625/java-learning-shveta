package com.learning.java.main;

import java.io.File;

import com.learning.java.threads.ReaderThread;

public class CSVToText {

	public static void main(String[] args) {

		long startTime = System.nanoTime();
		String csvFile = new File(".").getAbsolutePath() + "/src/main/resources/Multithreading_Task1_Books.csv";
		try {
			Thread thread = new Thread(new ReaderThread(csvFile));
			thread.start();
			thread.join();

		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println("Time taken : " + (System.nanoTime() - startTime) + "ns");

	}

}