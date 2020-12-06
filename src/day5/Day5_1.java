package day5;

import common.LineAdventDay;

public class Day5_1 extends LineAdventDay {

	protected int maxId = 0;

	@Override
	protected int getDay() {
		return 5;
	}

	public static void main(String[] args) {
		new Day5_1().print();
	}

	@Override
	protected void processLine(String line) {
		int id = getSeatId(line);
		if (id > maxId) {
			maxId = id;
		}
	}

	protected int getSeatId(String line) {
		String row = line.substring(0, 7).replace('F', '0').replace('B', '1');
		String seat = line.substring(7).replace('L', '0').replace('R', '1');
		return 8 * Integer.parseInt(row, 2) + Integer.parseInt(seat, 2);
	}

	@Override
	protected String processResults() {
		return String.valueOf(maxId);
	}
}