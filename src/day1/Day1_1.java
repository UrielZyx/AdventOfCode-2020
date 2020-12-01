package day1;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

import common.AdventDay;
import common.InputReader;

public class Day1_1 extends AdventDay {

	private static final int TARGET = 2020;

	public static void main(String[] args) {
		new Day1_1().testAndRun("514579");
	}

	@Override
	protected Optional<String> runConcrete(String fileName) {
		Set<Integer> values = new HashSet<>();

		for (String v : InputReader.readLines(1, fileName)) {
			int n = Integer.parseInt(v);
			if (values.contains(TARGET - n)) {
				return Optional.of(Integer.toString(n * (TARGET - n)));
			}
			values.add(n);
		}
		return Optional.empty();
	}
}
