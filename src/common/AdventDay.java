package common;

import java.util.Optional;

import tests.MyTest;
import tests.Outputs;

public abstract class AdventDay {

	public static final String INPUT = "input.txt";
	public static final String TEST_INPUT = "test input - ";
	public static final String TXT_SUFFIX = ".txt";

	protected boolean isTest = false;

	public AdventDay setTest(boolean isTest) {
		this.isTest = isTest;
		return this;
	}

	protected abstract int getDay();

	public void testAndPrint() {
		long t;
		try {
			t = System.nanoTime();
			new MyTest().runTests(this.getClass(), Outputs.getInstance().getTestOutputs().get(this.getClass()));
			System.out.println("Test took " + ((System.nanoTime() - t) / 1000000) + " ms");
		} catch (InstantiationException | IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		t = System.nanoTime();
		System.out.println(run().orElse("No result!"));
		System.out.println("Run took " + ((System.nanoTime() - t) / 1000000) + " ms");
	}

	public Optional<String> test() {
		return test(0);
	}

	public Optional<String> test(int i) {
		return test(String.valueOf(i));
	}

	public Optional<String> test(String i) {
		return run(testInputFileName(i), true);
	}

	private String testInputFileName(String i) {
		return TEST_INPUT + i + TXT_SUFFIX;
	}

	public Optional<String> run() {
		return run(INPUT);
	}

	public Optional<String> run(String fileName) {
		return run(fileName, false);
	}

	public Optional<String> run(String fileName, boolean isTest) {
		try {
			return Optional.ofNullable(this.getClass().newInstance().setTest(isTest).runConcrete(fileName));
		} catch (InstantiationException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		}
		return Optional.empty();
	}

	protected abstract String runConcrete(String fileName);
}
