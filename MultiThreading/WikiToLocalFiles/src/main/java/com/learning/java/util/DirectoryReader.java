package com.learning.java.util;

import java.io.File;
import java.net.URISyntaxException;

public class DirectoryReader {
	
	String dirToRead;
	
	public DirectoryReader(String dirToRead) {
		super();
		this.dirToRead = dirToRead;
	}
	
	public File[] readDirectory() {
		File[] files = null;
		try {
			File dir = new File(getClass().getResource("/" + dirToRead).toURI());
			files= dir.listFiles();
		} catch (URISyntaxException e) {
			e.printStackTrace();
		}
		return files;			
	}
}
