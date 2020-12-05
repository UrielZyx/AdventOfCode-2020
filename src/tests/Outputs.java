package tests;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import common.AdventDay;
import day1.Day1_1;
import day1.Day1_2;
import day2.Day2_1;
import day2.Day2_2;
import day3.Day3_1;
import day3.Day3_2;
import day4.Day4_1;
import day4.Day4_2;

public class Outputs {

	private Map<Class<? extends AdventDay>, List<String>> testOutputs = new HashMap<>();
	private Map<Class<? extends AdventDay>, String> outputs = new HashMap<>();

	public Map<Class<? extends AdventDay>, List<String>> getTestOutputs() {
		return testOutputs;
	}

	public Map<Class<? extends AdventDay>, String> getOutputs() {
		return outputs;
	}

	public Outputs() {
		testOutputs.put(Day1_1.class, Arrays.asList("514579"));
		testOutputs.put(Day1_2.class, Arrays.asList("241861950"));
		testOutputs.put(Day2_1.class, Arrays.asList("2"));
		testOutputs.put(Day2_2.class, Arrays.asList("1"));
		testOutputs.put(Day3_1.class, Arrays.asList("7"));
		testOutputs.put(Day3_2.class, Arrays.asList("336"));
		testOutputs.put(Day4_1.class, Arrays.asList("2"));
		testOutputs.put(Day4_2.class, Arrays.asList("2", "0", "4"));

		outputs.put(Day1_1.class, "1007104");
		outputs.put(Day1_2.class, "18847752");
		outputs.put(Day2_1.class, "628");
		outputs.put(Day2_2.class, "705");
		outputs.put(Day3_1.class, "189");
		outputs.put(Day3_2.class, "1718180100");
		outputs.put(Day4_1.class, "213");
		outputs.put(Day4_2.class, "147");
	}
}
