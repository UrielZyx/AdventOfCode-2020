package day1;

import java.util.HashSet;
import java.util.Set;

import common.MapReduceAdventDay;

public class Day1_1 extends MapReduceAdventDay {

	private static final int TARGET = 2020;
	Set<Integer> values = new HashSet<>();
	String result = null;

	public static void main(String[] args) {
		new Day1_1().testAndRun("514579");
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
