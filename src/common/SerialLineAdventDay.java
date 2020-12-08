package common;

import java.util.List;

public abstract class SerialLineAdventDay extends LineAdventDay {

	@Override
	protected String processLines(List<String> lines) {
		for (String l : lines) {
			processLine(l);
		}
		return processResults();
	}

	abstract void processLine(String line);

	abstract String processResults();

}
