package common;

import java.util.Optional;

public abstract class AdventDay {

	public static final String INPUT = "input.txt";
	public static final String TEST_INPUT = "test input - ";
	public static final String TXT_SUFFIX = ".txt";

	protected abstract int getDay();

	public void print() {
		System.out.println(run().orElse("No result!"));
	}

	public Optional<String> test() {
		return test(0);
	}

	public Optional<String> test(int i) {
		return test(String.valueOf(i));
	}

	public Optional<String> test(String i) {
		return run(testInputFileName(i));
	}

	private String testInputFileName(String i) {
		return TEST_INPUT + i + TXT_SUFFIX;
	}

	public Optional<String> run() {
		return run(INPUT);
	}

	public Optional<String> run(String fileName) {
		try {
			return Optional.ofNullable(this.getClass().newInstance().runConcrete(fileName));
		} catch (InstantiationException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		}
		return Optional.empty();
	}

	protected abstract String runConcrete(String fileName);
}
