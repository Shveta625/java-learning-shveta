package com.learning.java.threads;

import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.concurrent.ForkJoinPool;

public class ReaderThread implements Runnable {

	private String fileToRead;
	static final int THRESHOLD = 10000;

	public ReaderThread(String fileToRead) {
		super();
		this.fileToRead = fileToRead;
	}

	@Override
	public void run() {
		try {
			List<String> lines = Files.readAllLines(Paths.get(getClass().getResource("/" + fileToRead).toURI()),
					StandardCharsets.UTF_8);
			ForkJoinPool pool = new ForkJoinPool();
			int listSize = lines.size();
			if (listSize > THRESHOLD) {
				for (int i = 0; i < listSize; i = i + THRESHOLD) {
					if (i + THRESHOLD > listSize) {
						WriterForkJoinThread writerThread = new WriterForkJoinThread(lines.subList(i, listSize));
						pool.invoke(writerThread);

					} else {
						WriterForkJoinThread writerThread = new WriterForkJoinThread(lines.subList(i, i + THRESHOLD));
						pool.invoke(writerThread);
					}
				}
			}
		} catch (IOException | URISyntaxException e) {
			e.printStackTrace();
		}
	}

}
