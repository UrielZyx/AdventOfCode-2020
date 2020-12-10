package day10;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import common.LineAdventDay;

public class Day10_1 extends LineAdventDay {

	int last = 0;

	@Override
	protected int getDay() {
		return 10;
	}

	public static void main(String[] args) {
		new Day10_1().testAndPrint();
	}

	@Override
	protected String processLines(List<String> lines) {
		List<Integer> diffs = new ArrayList<Integer>();

		lines.stream()
				.mapToInt(Integer::valueOf)
				.sorted()
				.forEach(i -> {
					diffs.add(i - last);
					last = i;
				});
		diffs.add(3);

		return processDiffs(diffs);
	}

	protected String processDiffs(List<Integer> diffs) {
		Map<Integer, Long> counts = diffs.stream()
				.collect(
						Collectors.groupingBy(
								i -> i,
								Collectors.counting()));
		return String.valueOf(counts.get(1) * counts.get(3));
	}
}
