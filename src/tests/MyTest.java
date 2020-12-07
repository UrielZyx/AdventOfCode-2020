package tests;

import static org.junit.Assert.assertEquals;

import java.util.List;
import java.util.Map;

import org.junit.Test;

import common.AdventDay;

public class MyTest {

	@Test
	public void testOutputsOfTests() throws InstantiationException, IllegalAccessException {
		Outputs out = new Outputs();
		Map<Class<? extends AdventDay>, List<String>> testOutputs = out.getTestOutputs();
		for (Class<? extends AdventDay> day : testOutputs.keySet()) {
			List<String> results = testOutputs.get(day);
			for (int i = 0; i < results.size(); i++) {
				testSingle(day, results.get(i), i);
			}
		}
	}

	private void testSingle(Class<? extends AdventDay> day, String expected, int i)
			throws InstantiationException, IllegalAccessException {
		String result = day.newInstance().test(i).orElse(null);
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
