package common;

import java.util.List;

public abstract class LineAdventDay extends AdventDay {

	@Override
	protected String runConcrete(String fileName) {
		List<String> lines = InputReader.readLines(getDay(), fileName);
		return processLines(lines);
	}

	protected abstract String processLines(List<String> lines);
}
