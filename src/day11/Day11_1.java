package day11;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import common.MapAdventDay;

public class Day11_1 extends MapAdventDay {

	@Override
	protected int getDay() {
		return 11;
	}

	public static void main(String[] args) {
		new Day11_1().testAndPrint();
	}

	@Override
	protected String processMap(List<List<Character>> map) {
		Seating seating = new Seating(map);
		Set<String> visited = new HashSet<>();
		for (int i = 0; !visited.contains(seating.getState()); i++) {
			visited.add(seating.getState());
			seating.iterate();
		}
		return String.valueOf(seating.getState().chars().filter(c -> c == Seating.TAKEN).count());
	}
}