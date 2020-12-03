package day3;

public class Day3_2 extends Day3 {

	public static void main(String[] args) {
		new Day3_2().testAndRun("336");
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