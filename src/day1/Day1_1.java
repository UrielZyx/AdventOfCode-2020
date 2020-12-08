package day1;

import java.util.HashSet;
import java.util.Set;

import common.SerialLineAdventDay;

public class Day1_1 extends SerialLineAdventDay {

	protected static final int TARGET = 2020;
	protected Set<Integer> values = new HashSet<>();
	protected String result = null;

	public static void main(String[] args) {
		new Day1_1().print();
	}

	@Override
	protected int getDay() {
		return 1;
	}

	@Override
	protected void processLine(String line) {
		int n = Integer.parseInt(line);
		if (values.contains(TARGET - n)) {
			result = Integer.toString(n * (TARGET - n));
		}
		values.add(n);
	}

	@Override
	protected String processResults() {
		return result;
	}
}
