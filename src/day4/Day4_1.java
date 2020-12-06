package day4;

import java.util.HashMap;
import java.util.Map;

import common.LineGroupAdventDay;

public class Day4_1 extends LineGroupAdventDay {

	int count = 0;
	Map<String, String> passport = new HashMap<>();

	@Override
	protected int getDay() {
		return 4;
	}

	public static void main(String[] args) {
		new Day4_1().print();
	}

	@Override
	protected void addLine(String line) {
		for (String pair : line.split(" ")) {
			String[] keyValue = pair.split(":");
			passport.put(keyValue[0], keyValue[1]);
		}
	}

	@Override
	protected void processGroup() {
		validatePassport();
		passport = new HashMap<>();
		return;
	}

	@Override
	protected String processFinalResults() {
		return String.valueOf(count);
	}

	private void validatePassport() {
		if (isValid(passport)) {
			count++;
		}
	}

	protected boolean isValid(Map<String, String> passport) {
		passport.remove("cid");
		return passport.size() == 7;
	}
}
