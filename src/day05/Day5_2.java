package day05;

import java.util.HashSet;
import java.util.Set;

public class Day5_2 extends Day5_1 {
	Set<Integer> seats = new HashSet<>();

	public static void main(String[] args) {
		new Day5_2().testAndPrint();
	}

	@Override
	protected void processLine(String line) {
		super.processLine(line);
		seats.add(getSeatId(line));
	}

	@Override
	protected String processResults() {
		for (int i = 0; i < maxId; i++) {
			if (seats.contains(i) && !seats.contains(i + 1) && seats.contains(i + 2)) {
				return String.valueOf(i + 1);
			}
		}
		return null;
	}
}
