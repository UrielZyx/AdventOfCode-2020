package tests;

import static org.junit.Assert.assertEquals;

import java.util.List;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;
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
			if (results.size() == 1) {
				testSingle(day, results.get(0));
			} else {
				for (int i = 0; i < results.size(); i++) {
					testSingle(day, results.get(i), String.valueOf(i));
				}
			}
		}
	}

	private void testSingle(Class<? extends AdventDay> day, String expected)
			throws InstantiationException, IllegalAccessException {
		testSingle(day, expected, StringUtils.EMPTY);
	}

	private void testSingle(Class<? extends AdventDay> day, String expected, String i)
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
