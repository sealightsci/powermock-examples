package com.org.util;

import java.io.File;

public class MockUtility {

	private String name = "MockUtility";

	// no argument constructor
	public MockUtility() {
	}

	// single argument constructor
	public MockUtility(String name) {
		this.name = name;
	}

	public static boolean isSafe(int i) {
		if (i > 0) {
			return true;
		} else {
			return false;
		}
	}

	public static void sleep(long time) throws Exception {
		Thread.sleep(time);
	}

	public static void readFile(String filename) throws Exception {
		File file = new File(filename);
		System.out.println(file.getAbsolutePath());
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}
