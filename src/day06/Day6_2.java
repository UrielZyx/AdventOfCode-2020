package day06;

import java.util.Set;
import java.util.stream.Collectors;

public class Day6_2 extends Day6_1 {

	boolean newGroup = true;

	public static void main(String[] args) {
		new Day6_2().testAndPrint();
	}

	@Override
	protected void addLine(String line) {
		Set<Integer> tmp = line.chars()
				.mapToObj(Integer::valueOf)
				.collect(Collectors.toSet());

		if (newGroup) {
			answers = tmp;
			newGroup = false;
		} else {
			answers.retainAll(tmp);
		}
	}

	@Override
	protected void processGroup() {
		newGroup = true;
		super.processGroup();
	}
}
