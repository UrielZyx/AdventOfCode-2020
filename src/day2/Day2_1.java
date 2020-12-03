package day2;

import org.apache.commons.lang3.StringUtils;

import common.MapReduceAdventDay;

public class Day2_1 extends MapReduceAdventDay {

	private int count = 0;

	@Override
	protected int getDay() {
		return 2;
	}

	public static void main(String[] args) {
		new Day2_1().print();
	}

	@Override
	protected void processLine(String line) {
		String[] parts = line.split("[- :]");
		int min = Integer.parseInt(parts[0]);
		int max = Integer.parseInt(parts[1]);
		char letter = parts[2].charAt(0);
		String password = parts[4];
		int matches = StringUtils.countMatches(password, letter);

		if (matches >= min && matches <= max) {
			count++;
		}
	}

	@Override
	protected String processResults() {
		return Integer.toString(count);
	}
}
