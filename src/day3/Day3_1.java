package day3;

public class Day3_1 extends Day3 {

	public static void main(String[] args) {
		new Day3_1().testAndRun("7");
	}

	@Override
	protected String processResults() {
		return String.valueOf(countTrees(3, 1));
	}
}