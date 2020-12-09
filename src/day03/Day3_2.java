package day03;

public class Day3_2 extends Day3_1 {

	public static void main(String[] args) {
		new Day3_2().testAndPrint();
	}

	@Override
	protected String processResults() {
		return String.valueOf(
				countTrees(1, 1) *
						countTrees(3, 1) *
						countTrees(5, 1) *
						countTrees(7, 1) *
						countTrees(1, 2));
	}
}
