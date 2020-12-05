package day4;

import java.util.Map;

public class Day4_1 extends Day4 {

	public static void main(String[] args) {
		new Day4_1().print();
	}

	@Override
	protected boolean valid(Map<String, String> passport) {
		passport.remove("cid");
		return passport.size() == 7;
	}

}