package tests;

import static org.junit.Assert.assertEquals;

import java.util.List;
import java.util.Map;

import org.junit.Test;

import common.AdventDay;

public class MyTest {

	@Test
	public void runTests() throws InstantiationException, IllegalAccessException {
		Outputs out = Outputs.getInstance();
		Map<Class<? extends AdventDay>, List<String>> testOutputs = out.getTestOutputs();
		for (Class<? extends AdventDay> day : testOutputs.keySet()) {
			runTests(day, testOutputs.get(day));
		}
	}

	public void runTests(Class<? extends AdventDay> day, List<String> results)
			throws InstantiationException, IllegalAccessException {
		for (int i = 0; i < results.size(); i++) {
			testSingle(day, results.get(i), i);
		}
	}

	private void testSingle(Class<? extends AdventDay> day, String expected, int i)
			throws InstantiationException, IllegalAccessException {
		String result = day.newInstance().test(i).orElse(null);
		assertEquals("Bug in " + day.getSimpleName() + "tests", expected, result);
	}

	@Test
	public void runRealInputs() throws InstantiationException, IllegalAccessException {
		Outputs out = Outputs.getInstance();
		Map<Class<? extends AdventDay>, String> outputs = out.getOutputs();
		for (Class<? extends AdventDay> day : outputs.keySet()) {
			runDay(day, outputs.get(day));
		}
	}

	public void runDay(Class<? extends AdventDay> day, String output)
			throws InstantiationException, IllegalAccessException {
		String result = day.newInstance().run().orElse(null);
		assertEquals("Bug in " + day.getSimpleName(), output, result);
	}

}
