package common;

import java.util.Optional;

public abstract class AdventDay {

	public static final String INPUT = "input.txt";
	public static final String TEST_INPUT = "test input.txt";

	public void print() {
		System.out.println(run().orElse("No result!"));
	}

	public Optional<String> test() {
		return run(TEST_INPUT);
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
