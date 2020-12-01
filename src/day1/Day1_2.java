
package day1;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import common.AdventDay;
import common.InputReader;

public class Day1_2 extends AdventDay {

	private static final int TARGET = 2020;

	public static void main(String[] args) {
		new Day1_2().testAndRun("241861950");
	}

	@Override
	protected String runConcrete(String fileName) {
		Set<Integer> singles = new HashSet<>();
		Map<Integer, Integer> doubles = new HashMap<>();

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
}
