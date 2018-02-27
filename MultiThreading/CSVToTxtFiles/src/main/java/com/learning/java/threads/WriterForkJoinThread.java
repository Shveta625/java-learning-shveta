package com.learning.java.threads;

import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ForkJoinTask;
import java.util.concurrent.RecursiveAction;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.stream.Collectors;

import com.learning.java.util.PropertiesLoader;
	
/**
 * Writer thread
 * 
 * @author shvetap
 *
 */
public class WriterForkJoinThread extends RecursiveAction {

	private static AtomicInteger atomicInteger = new AtomicInteger();
	private static final long serialVersionUID = -7412617337563360202L;
	static final int THRESHOLD = 10;
	private List<String> lines;
	transient Logger logger = Logger.getLogger(WriterForkJoinThread.class.getName());

	public WriterForkJoinThread(List<String> lines) {
		super();
		this.lines = lines;

	}

	@Override
	protected void compute() {
		if (lines.size() > THRESHOLD) {
			ForkJoinTask.invokeAll(createSubtasks(lines));
		} else {
			writeToFile(lines);
		}

	}

	/**
	 * Creates fork writer threads
	 * 
	 * @param lines
	 *            list of lines to b processed
	 * @return list of writer fork threads created
	 */
	private List<WriterForkJoinThread> createSubtasks(List<String> lines) {
		List<WriterForkJoinThread> subTasks = new ArrayList<>();
		List<String> listOne = lines.stream().limit(THRESHOLD).collect(Collectors.toList());
		List<String> listTwo = lines.stream().skip(THRESHOLD).collect(Collectors.toList());
		subTasks.add(new WriterForkJoinThread(listOne));
		subTasks.add(new WriterForkJoinThread(listTwo));

		return subTasks;
	}

	/**
	 * Writes file on local storage
	 * 
	 * @param lines
	 *            lines to be printed
	 */
	private void writeToFile(List<String> lines) {
		try 	{
			Files.write(Paths.get(PropertiesLoader.getInstance().getProperty("OUTPUT_DIRECTORY")+"/TestingCSV" + atomicInteger.incrementAndGet() + ".txt"), lines,
					Charset.forName("UTF-8"), StandardOpenOption.CREATE, StandardOpenOption.APPEND);
		} catch (IOException e) {
			logger.log(Level.INFO, String.valueOf(e.getStackTrace()));
		}
	}

}
