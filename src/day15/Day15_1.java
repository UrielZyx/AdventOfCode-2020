package day15;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import common.LineAdventDay;

public class Day15_1 extends LineAdventDay {

	Map<Integer, Integer> positions = new HashMap<>();

	@Override
	protected int getDay() {
		return 15;
	}

	public static void main(String[] args) {
		new Day15_1().testAndPrint();
	}

	@Override
	protected String processLines(List<String> lines) {
		List<Integer> nums = Arrays
				.stream(lines.get(0).split(","))
				.map(Integer::valueOf)
				.collect(Collectors.toList());
		int i, current = nums.get(0);
		for (i = 1; i < nums.size(); i++) {
			positions.put(current, i - 1);
			current = nums.get(i);
		}
		for (; i < getLimit(); i++) {
			int tmp = i - 1 - positions.getOrDefault(current, i - 1);
			positions.put(current, i - 1);
			current = tmp;
		}
		return String.valueOf(current);
	}

	protected int getLimit() {
		return 2020;
	}

}
