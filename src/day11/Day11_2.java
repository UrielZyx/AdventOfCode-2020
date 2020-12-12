package day11;

import java.util.List;

public class Day11_2 extends Day11_1 {
	public static void main(String[] args) {
		new Day11_2().testAndPrint();
	}

	@Override
	protected Seating createSeatings(List<List<Character>> map) {
		return new LineOfSightSeating(map, 5);
	}
}
