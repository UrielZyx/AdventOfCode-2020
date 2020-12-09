package day06;

import java.util.HashSet;
import java.util.Set;

import common.LineGroupAdventDay;

public class Day6_1 extends LineGroupAdventDay {

	protected Set<Integer> answers = new HashSet<>();
	protected int count = 0;

	@Override
	protected int getDay() {
		return 6;
	}

	public static void main(String[] args) {
		new Day6_1().testAndPrint();
	}

	@Override
	protected void addLine(String line) {
		line.chars().forEach(answers::add);
	}

	@Override
	protected void processGroup() {
		count += answers.size();
		answers = new HashSet<>();
	}

	@Override
	protected String processFinalResults() {
		return String.valueOf(count);
	}
}
