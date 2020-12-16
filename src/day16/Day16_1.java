package day16;

import java.util.Arrays;
import java.util.List;
import java.util.Map.Entry;
import java.util.TreeMap;

import org.apache.commons.lang3.StringUtils;

import common.LineAdventDay;

public class Day16_1 extends LineAdventDay {

	TreeMap<Integer, Integer> ranges = new TreeMap<>();
	int sum = 0;

	@Override
	protected int getDay() {
		return 16;
	}

	public static void main(String[] args) {
		new Day16_1().testAndPrint();
	}

	@Override
	protected String processLines(List<String> lines) {
		int i = 0;
		for (i = 0; StringUtils.isNoneBlank(lines.get(i)); i++) {
			addField(lines.get(i));
		}

		readOwnTicket(lines.get(i + 2));

		for (i += 5; i < lines.size() && StringUtils.isNoneBlank(lines.get(i)); i++) {
			scanTicket(lines.get(i));
		}

		return computeResult();
	}

	protected void addField(String line) {
		String[] field = line.split("[:]");
		String[] parts = field[1].split("[ -]");
		addField(field[0],
				Integer.valueOf(parts[1]),
				Integer.valueOf(parts[2]),
				Integer.valueOf(parts[4]),
				Integer.valueOf(parts[5]));
	}

	protected void addField(String name, Integer min1, Integer max1, Integer min2, Integer max2) {
		addRange(min1, max1);
		addRange(min2, max2);
	}

	private void addRange(Integer min, Integer max) {
		Entry<Integer, Integer> prev = ranges.floorEntry(min);
		Entry<Integer, Integer> next = ranges.higherEntry(min);

		if (prev != null && prev.getValue() >= min) {
			ranges.remove(prev.getKey());
			min = prev.getKey();
			if (prev.getValue() > max) {
				max = prev.getValue();
			}
		}

		if (next != null && next.getKey() <= max) {
			ranges.remove(next.getKey());
			if (next.getValue() > max) {
				max = next.getValue();
			}
		}

		ranges.put(min, max);
	}

	protected void readOwnTicket(String line) {
	}

	protected void scanTicket(String line) {
		sum += Arrays
				.stream(line.split(","))
				.mapToInt(Integer::valueOf)
				.filter(this::isNotValid)
				.sum();
	}

	protected boolean isNotValid(int v) {
		return !isValid(v);
	}

	protected boolean isValid(int v) {
		return isValid(v, ranges);
	}

	protected boolean isValid(int v, TreeMap<Integer, Integer> constraints) {
		Entry<Integer, Integer> range = constraints.floorEntry(v);
		return range != null && range.getValue() >= v;
	}

	protected String computeResult() {
		return String.valueOf(sum);
	}
}
