package tests;

import static org.junit.Assert.assertEquals;

import java.util.List;
import java.util.Map;

import org.junit.Test;

import common.AdventDay;
import common.Outputs;

public class MyTest {

	@Test
	public void testOutputsOfTests() throws InstantiationException, IllegalAccessException {
		Outputs out = new Outputs();
		Map<Class<? extends AdventDay>, List<String>> testOutputs = out.getTestOutputs();
		for (Class<? extends AdventDay> day : testOutputs.keySet()) {
			List<String> results = testOutputs.get(day);
			testSingle(day, results.get(0));
		}
	}

	private void testSingle(Class<? extends AdventDay> day, String expected)
			throws InstantiationException, IllegalAccessException {
		String result = day.newInstance().test().orElse(null);
		assertEquals("Bug in " + day.getSimpleName() + "tests", expected, result);
	}

	@Test
	public void testOutputsOfActual() throws InstantiationException, IllegalAccessException {
		Outputs out = new Outputs();
		Map<Class<? extends AdventDay>, String> outputs = out.getOutputs();
		for (Class<? extends AdventDay> day : outputs.keySet()) {
			String result = day.newInstance().run().orElse(null);
			assertEquals("Bug in " + day.getSimpleName(), outputs.get(day), result);
		}
	}

}
