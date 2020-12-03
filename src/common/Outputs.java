package common;

import java.util.HashMap;
import java.util.Map;

import day1.Day1_1;
import day1.Day1_2;
import day2.Day2_1;
import day2.Day2_2;
import day3.Day3_1;
import day3.Day3_2;

public class Outputs {

	private Map<Class<? extends AdventDay>, String> testOutputs = new HashMap<>();
	private Map<Class<? extends AdventDay>, String> outputs = new HashMap<>();

	public Map<Class<? extends AdventDay>, String> getTestOutputs() {
		return testOutputs;
	}

	public Map<Class<? extends AdventDay>, String> getOutputs() {
		return outputs;
	}

	public Outputs() {
		testOutputs.put(Day1_1.class, "514579");
		testOutputs.put(Day1_2.class, "241861950");
		testOutputs.put(Day2_1.class, "2");
		testOutputs.put(Day2_2.class, "1");
		testOutputs.put(Day3_1.class, "7");
		testOutputs.put(Day3_2.class, "336");

		outputs.put(Day1_1.class, "1007104");
		outputs.put(Day1_2.class, "18847752");
		outputs.put(Day2_1.class, "628");
		outputs.put(Day2_2.class, "705");
		outputs.put(Day3_1.class, "189");
		outputs.put(Day3_2.class, "1718180100");
	}
}