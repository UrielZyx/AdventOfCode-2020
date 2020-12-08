package day4;

import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Day4_2 extends Day4_1 {

	public static void main(String[] args) {
		new Day4_2().testAndPrint();
	}

	@Override
	protected boolean isValid(Map<String, String> passport) {
		passport.remove("cid");
		if (passport.size() != 7) {
			return false;
		}
		if (!validateByr(passport.get("byr"))) {
			return false;
		}
		if (!validateIyr(passport.get("iyr"))) {
			return false;
		}
		if (!validateEyr(passport.get("eyr"))) {
			return false;
		}
		if (!validateHgt(passport.get("hgt"))) {
			return false;
		}
		if (!validateHcl(passport.get("hcl"))) {
			return false;
		}
		if (!validateEcl(passport.get("ecl"))) {
			return false;
		}
		if (!validatePid(passport.get("pid"))) {
			return false;
		}
		return true;
	}

	private boolean validateByr(String s) {
		int y = parseYear(s);
		return y >= 1920 && y <= 2002;
	}

	private boolean validateIyr(String s) {
		int y = parseYear(s);
		return y >= 2010 && y <= 2020;
	}

	private boolean validateEyr(String s) {
		int y = parseYear(s);
		return y >= 2020 && y <= 2030;
	}

	private int parseYear(String s) {
		if (s.length() == 4) {
			return Integer.parseInt(s);
		}
		return -1;
	}

	private boolean validateHgt(String s) {
		if (s.length() == 4) {
			if (s.substring(2).equals("in")) {
				int h = Integer.parseInt(s.substring(0, 2));
				return h >= 59 && h <= 76;
			}
		}
		if (s.length() == 5) {
			if (s.substring(3).equals("cm")) {
				int h = Integer.parseInt(s.substring(0, 3));
				return h >= 150 && h <= 193;
			}
		}
		return false;
	}

	private boolean validateHcl(String s) {
		if (s.charAt(0) != '#')
			return false;

		if (s.length() != 7)
			return false;

		return s.substring(1)
				.chars()
				.allMatch(c -> c >= '0' && c <= '9' ||
						c >= 'a' && c <= 'f');
	}

	private boolean validateEcl(String s) {
		Set<String> colors = new HashSet<>();
		colors.add("amb");
		colors.add("blu");
		colors.add("brn");
		colors.add("gry");
		colors.add("grn");
		colors.add("hzl");
		colors.add("oth");

		return colors.contains(s);
	}

	private boolean validatePid(String s) {
		if (s.length() != 9)
			return false;

		return s.chars().allMatch(c -> c >= '0' && c <= '9');
	}
}