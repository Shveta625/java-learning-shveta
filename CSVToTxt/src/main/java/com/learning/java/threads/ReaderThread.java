package com.learning.java.threads;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.concurrent.ForkJoinPool;

public class ReaderThread implements Runnable {

	private String fileToRead;

	public ReaderThread(String fileToRead) {
		super();
		this.fileToRead = fileToRead;
	}

	@Override
	public void run() {
		try (BufferedReader br = new BufferedReader(new FileReader(fileToRead))) {
			List<String> lines=Files.readAllLines(Paths.get(getClass().getResource("/Multithreading_Task1_Books.csv").toURI()));
			
			ForkJoinPool pool = new ForkJoinPool();
			WriterForkJoinThread writerThread = new WriterForkJoinThread(lines);
			pool.invoke(writerThread);
		} catch (IOException|URISyntaxException e) {
			e.printStackTrace();
		}
	}

}
