package com.org.service;

import com.org.util.MockUtility;

public class MockService {

	private static int threshold = 1000000;

	public void foreach(int count) {
		for (int i = 0; i < count; i++) {
			isPositiveNumber(i);
		}
	}

	public boolean isAllowBuy(int i) {
		if (MockUtility.isSafe(i)) {
		}
		return false;
	}

	public boolean handle(int i) {
		if (isNeedHandle(i)) {
			return true;
		}
		return false;
	}

	private boolean isNeedHandle(int i) {
		return true;
	}

	public MockUtility getUtil() {
		System.out.println("in getUtil!");
		MockUtility util = new MockUtility();
		return util;
	}

	public int sumOfN() {
		int n = 0;
		while (n < threshold) {
			n += 1;
		}
		return n;
	}

	private boolean isPositiveNumber(int i) {
		if (i > 0) {
			return true;
		} else {
			return false;
		}
	}

}
