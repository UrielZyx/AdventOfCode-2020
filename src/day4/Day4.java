package day4;

import java.util.HashMap;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;

import common.MapReduceAdventDay;

public abstract class Day4 extends MapReduceAdventDay {

	int count = 0;
	Map<String, String> passport = new HashMap<>();

	@Override
	protected int getDay() {
		return 4;
	}

	@Override
	protected void processLine(String line) {
		if (StringUtils.isBlank(line)) {
			validatePassport();
			passport = new HashMap<>();
			return;
		}
		for (String pair : line.split(" ")) {
			String[] keyValue = pair.split(":");
			passport.put(keyValue[0], keyValue[1]);
		}
	}

	protected abstract boolean valid(Map<String, String> passport);

	@Override
	protected String processResults() {
		validatePassport();
		return String.valueOf(count);
	}

	private void validatePassport() {
		if (valid(passport)) {
			count++;
		}
	}
}
