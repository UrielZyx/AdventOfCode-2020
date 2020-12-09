package day02;

public class Day2_2 extends Day2_1 {

	public static void main(String[] args) {
		new Day2_2().testAndPrint();
	}

	@Override
	protected void checkPassword(int min, int max, char letter, String password) {
		if (password.charAt(min - 1) == letter ^ password.charAt(max - 1) == letter) {
			count++;
		}
	}
}
