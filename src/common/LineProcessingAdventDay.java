package common;

public abstract class LineProcessingAdventDay extends AdventDay {

	@Override
	protected String runConcrete(String fileName) {
		for (String l : InputReader.readLines(getDay(), fileName)) {
			processLine(l);
		}
		return processResults();
	}

	protected abstract int getDay();

	protected abstract void processLine(String line);

	protected abstract String processResults();

}
