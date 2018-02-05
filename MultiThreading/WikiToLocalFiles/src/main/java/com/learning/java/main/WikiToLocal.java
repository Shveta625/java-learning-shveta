package com.learning.java.main;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.List;

import com.learning.java.threads.ReaderThread;
import com.learning.java.util.DirectoryReader;


public class WikiToLocal {
	public static void main(String args[]) {

		String dirToRead = "FilesToTraverse";
		createDirectory();
		File[] files = (new DirectoryReader(dirToRead)).readDirectory();
		try {
			List<String> lines = null;
			for (File file : files) {
				lines = Files.readAllLines(file.toPath());
				for (String searchWord : lines) {

					Thread reader = new Thread(new ReaderThread(searchWord));
					reader.start();
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private static void createDirectory() {
		File file = new File("TestDirectory");
		file.mkdir();
	}
}
