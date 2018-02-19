package com.learning.java.util;

import java.io.File;
import java.nio.file.Paths;

/**
 * To read directory
 * 
 * @author shvetap
 *
 */
public class DirectoryReader {

	String dirToRead;

	public DirectoryReader(String dirToRead) {
		super();
		this.dirToRead = dirToRead;
	}

	public File[] readDirectory() {
		File[] files = null;
		File dir = new File(
				Paths.get(Paths.get(System.getProperty("user.dir")).getParent().toString() + "/" + dirToRead).toUri());
		files = dir.listFiles();
		return files;
	}
}
