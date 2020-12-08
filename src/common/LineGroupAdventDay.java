package common;

import org.apache.commons.lang3.StringUtils;

public abstract class LineGroupAdventDay extends SerialLineAdventDay {

	@Override
	protected void processLine(String line) {
		if (StringUtils.isBlank(line)) {
			processGroup();
		} else {
			addLine(line);
		}
	}

	@Override
	protected String processResults() {
		processGroup();
		return processFinalResults();
	}

	abstract void addLine(String line);

	abstract void processGroup();

	abstract String processFinalResults();
}
