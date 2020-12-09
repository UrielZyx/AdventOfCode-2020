package day9;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Set;

import common.SerialLineAdventDay;

public class Day9_1 extends SerialLineAdventDay {

	LinkedList<Long> q = new LinkedList<>();
	LinkedList<Set<Long>> sums = new LinkedList<>();
	int limit = 25;
	protected Long result = null;

	@Override
	protected int getDay() {
		return 9;
	}

	public static void main(String[] args) {
		new Day9_1().testAndPrint();
	}

	@Override
	protected String runConcrete(String fileName) {
		if (isTest) {
			limit = 5;
		}
		return super.runConcrete(fileName);
	}

	@Override
	protected void processLine(String line) {
		long value = Long.valueOf(line);
		processValue(value);
	}

	protected void processValue(long value) {
		if (q.size() >= limit) {
			if (sums.stream().noneMatch(s -> s.contains(value))) {
				result = value;
			}
			q.poll();
			sums.poll();
		}

		for (int i = 0; i < sums.size(); i++) {
			sums.get(i).add(q.get(i) + value);
		}
		sums.add(new HashSet<>());
		q.add(value);
	}

	@Override
	protected String processResults() {
		return String.valueOf(result);
	}

}
