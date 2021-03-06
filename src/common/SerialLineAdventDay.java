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

	protected abstract void processLine(String line);

	protected abstract String processResults();

}
