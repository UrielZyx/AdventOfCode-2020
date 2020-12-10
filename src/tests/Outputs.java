package tests;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import common.AdventDay;
import day01.Day1_1;
import day01.Day1_2;
import day02.Day2_1;
import day02.Day2_2;
import day03.Day3_1;
import day03.Day3_2;
import day04.Day4_1;
import day04.Day4_2;
import day05.Day5_1;
import day05.Day5_2;
import day06.Day6_1;
import day06.Day6_2;
import day07.Day7_1;
import day07.Day7_2;
import day08.Day8_1;
import day08.Day8_2;
import day09.Day9_1;
import day09.Day9_2;
import day10.Day10_1;
import day10.Day10_2;

public class Outputs {

	private static Outputs instance = null;

	public static Outputs getInstance() {
		if (instance == null) {
			instance = new Outputs();
		}
		return instance;
	}

	private Map<Class<? extends AdventDay>, List<String>> testOutputs = new HashMap<>();
	private Map<Class<? extends AdventDay>, String> outputs = new HashMap<>();

	public Map<Class<? extends AdventDay>, List<String>> getTestOutputs() {
		return testOutputs;
	}

	public Map<Class<? extends AdventDay>, String> getOutputs() {
		return outputs;
	}

	private Outputs() {
		testOutputs.put(Day1_1.class, Arrays.asList("514579"));
		testOutputs.put(Day1_2.class, Arrays.asList("241861950"));
		testOutputs.put(Day2_1.class, Arrays.asList("2"));
		testOutputs.put(Day2_2.class, Arrays.asList("1"));
		testOutputs.put(Day3_1.class, Arrays.asList("7"));
		testOutputs.put(Day3_2.class, Arrays.asList("336"));
		testOutputs.put(Day4_1.class, Arrays.asList("2"));
		testOutputs.put(Day4_2.class, Arrays.asList("2", "0", "4"));
		testOutputs.put(Day6_1.class, Arrays.asList("11"));
		testOutputs.put(Day6_2.class, Arrays.asList("6"));
		testOutputs.put(Day7_1.class, Arrays.asList("4"));
		testOutputs.put(Day7_2.class, Arrays.asList("32", "126"));
		testOutputs.put(Day8_1.class, Arrays.asList("5"));
		testOutputs.put(Day8_2.class, Arrays.asList("8"));
		testOutputs.put(Day9_1.class, Arrays.asList("127"));
		testOutputs.put(Day9_2.class, Arrays.asList("62"));
		testOutputs.put(Day10_1.class, Arrays.asList("35", "220"));
		testOutputs.put(Day10_2.class, Arrays.asList("8", "19208"));

		outputs.put(Day1_1.class, "1007104");
		outputs.put(Day1_2.class, "18847752");
		outputs.put(Day2_1.class, "628");
		outputs.put(Day2_2.class, "705");
		outputs.put(Day3_1.class, "189");
		outputs.put(Day3_2.class, "1718180100");
		outputs.put(Day4_1.class, "213");
		outputs.put(Day4_2.class, "147");
		outputs.put(Day5_1.class, "944");
		outputs.put(Day5_2.class, "554");
		outputs.put(Day6_1.class, "6351");
		outputs.put(Day6_2.class, "3143");
		outputs.put(Day7_1.class, "103");
		outputs.put(Day7_2.class, "1469");
		outputs.put(Day8_1.class, "1475");
		outputs.put(Day8_2.class, "1270");
		outputs.put(Day9_1.class, "375054920");
		outputs.put(Day9_2.class, "54142584");
		outputs.put(Day10_1.class, "2812");
		outputs.put(Day10_2.class, "386869246296064");
	}
}
