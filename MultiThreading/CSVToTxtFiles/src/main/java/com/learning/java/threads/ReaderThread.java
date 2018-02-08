package com.learning.java.threads;

import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.concurrent.ForkJoinPool;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Reader Thread
 * 
 * @author shvetap
 *
 */
public class ReaderThread implements Runnable {

	private String fileToRead;
	static final int THRESHOLD = 100;
	Logger logger = Logger.getLogger(WriterForkJoinThread.class.getName());

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
			WriterForkJoinThread writerThread;
			int listSize = lines.size();
			if (listSize > THRESHOLD) {
				for (int i = 0; i < listSize; i = i + THRESHOLD) {
					if (i + THRESHOLD > listSize) {
						writerThread = new WriterForkJoinThread(lines.subList(i, listSize));
					} else {
						writerThread = new WriterForkJoinThread(lines.subList(i, i + THRESHOLD));
					}
					pool.invoke(writerThread);
				}
			}else {
				writerThread = new WriterForkJoinThread(lines.subList(0, listSize));
				pool.invoke(writerThread);
			}
		} catch (IOException | URISyntaxException e) {
			logger.log(Level.INFO, String.valueOf(e.getStackTrace()));
		}
	}
}
