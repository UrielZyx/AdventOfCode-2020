
package day1;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import common.InputReader;
import common.MapReduceAdventDay;

public class Day1_2 extends MapReduceAdventDay {

	private static final int TARGET = 2020;
	Set<Integer> singles = new HashSet<>();
	Map<Integer, Integer> doubles = new HashMap<>();
	String result = null;

	public static void main(String[] args) {
		new Day1_2().testAndRun("241861950");
	}

	@Override
	protected String runConcrete(String fileName) {
		for (String v : InputReader.readLines(1, fileName)) {
			int n = Integer.parseInt(v);
			int m = TARGET - n;
			if (doubles.containsKey(m)) {
				return Integer.toString(n * doubles.get(m) * (m - doubles.get(m)));
			}
			singles.add(n);
			for (int o : singles) {
				doubles.put(o + n, n);
			}
		}

		return null;
	}

	@Override
	protected void clear() {
		singles = new HashSet<>();
		doubles = new HashMap<>();
		result = null;
	}

	@Override
	protected int getDay() {
		return 1;
	}

	@Override
	protected void processLine(String line) {
		int n = Integer.parseInt(line);
		int m = TARGET - n;
		if (doubles.containsKey(m)) {
			result = Integer.toString(n * doubles.get(m) * (m - doubles.get(m)));
		}
		singles.add(n);
		for (int o : singles) {
			doubles.put(o + n, n);
		}
	}

	@Override
	protected String processResults() {
		return result;
	}
}
