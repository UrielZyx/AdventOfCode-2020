package common;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

public abstract class AdventDay {

	public static final String INPUT = "input.txt";
	public static final String TEST_INPUT = "test input.txt";

	public Optional<String> testAndRun(String testOutput) {
		Map<String, String> tests = new HashMap<>();
		tests.put(TEST_INPUT, testOutput);
		return testAndRun(tests, INPUT);
	}

	public Optional<String> testAndRun(Map<String, String> tests, String input) {
		Optional<String> result = Optional.empty();

		if (tests
				.entrySet()
				.stream()
				.allMatch(this::test)) {
			result = run(input);
		}
		System.out.println(result.orElse("No Result!"));
		return result;
	}

	private boolean test(Map.Entry<String, String> t) {
		String k = t.getKey();
		String v = t.getValue();
		String result = run(k).orElse(null);

		if (v.equals(result)) {
			System.out.println("For input " + k + ":\tPassed with output " + v);
			return true;
		}
		System.out.println("For input " + k + ":\tExpected  " + v + ",\tbut got " + result);
		return false;
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
