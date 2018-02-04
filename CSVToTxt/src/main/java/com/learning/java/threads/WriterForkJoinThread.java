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
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class WriterForkJoinThread extends RecursiveAction {

	AtomicInteger atomicInteger = new AtomicInteger();
	private static final long serialVersionUID = -7412617337563360202L;
	static final int THRESHOLD = 10;
	private List<String> lines;

	public WriterForkJoinThread(List<String> lines) {
		super();
		this.lines = lines;

	}

	@Override
	protected void compute() {
		if (lines.size() > THRESHOLD) {
			ForkJoinTask.invokeAll(createSubtasks(lines));
		} else {
			processing(lines);
		}

	}

	private List<WriterForkJoinThread> createSubtasks(List<String> lines) {
		List<WriterForkJoinThread> subTasks = new ArrayList<>();
		Stream<String> partOne = lines.stream().limit(THRESHOLD);
		Stream<String> partTwo = lines.stream().skip(THRESHOLD);
		subTasks.add(new WriterForkJoinThread(partOne.collect(Collectors.toList())));
		subTasks.add(new WriterForkJoinThread(partTwo.collect(Collectors.toList())));

		return subTasks;
	}

	private void processing(List<String> lines) {
		try {
			Files.write(Paths.get("TestDirectory/TestingCSV" + atomicInteger.getAndIncrement() + ".txt"), lines,
					Charset.forName("UTF-8"), StandardOpenOption.CREATE, StandardOpenOption.APPEND);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
