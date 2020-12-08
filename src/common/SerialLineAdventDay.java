package common;

public abstract class SerialLineAdventDay extends AdventDay {

	@Override
	protected String runConcrete(String fileName) {
		for (String l : InputReader.readLines(getDay(), fileName)) {
			processLine(l);
		}
		return processResults();
	}

	protected abstract void processLine(String line);

	protected abstract String processResults();

}
