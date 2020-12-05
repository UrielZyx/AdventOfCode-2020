package day3;

import java.util.ArrayList;
import java.util.List;

import common.MapReduceAdventDay;

public class Day3_1 extends MapReduceAdventDay {

	public static final Character TREE = '#';
	public static final Character FREE = '.';
	List<List<Character>> map = new ArrayList<>();

	@Override
	protected int getDay() {
		return 3;
	}

	public static void main(String[] args) {
		new Day3_1().print();
	}

	@Override
	protected void processLine(String line) {
		List<Character> l = new ArrayList<>();
		for (char c : line.toCharArray()) {
			l.add(c);
		}
		map.add(l);
	}

	protected int countTrees(int x, int y) {
		int count = 0, h = map.size(), w = map.get(0).size();
		for (int i = 0; i * y < h; i++) {
			if (map.get(i * y).get((i * x) % w).equals(TREE)) {
				count++;
			}
		}
		return count;
	}

	@Override
	protected String processResults() {
		return String.valueOf(countTrees(3, 1));
	}
}
