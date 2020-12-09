package day07;

import java.util.HashMap;
import java.util.Map;

import com.google.common.collect.ArrayListMultimap;
import com.google.common.collect.Multimap;

public class Day7_2 extends Day7_1 {

	Multimap<String, BagDescription> rules = ArrayListMultimap.create();
	Map<String, Integer> results = new HashMap<>();

	public static void main(String[] args) {
		new Day7_2().testAndPrint();
	}

	@Override
	protected void processBag(String conatining, BagDescription b) {
		rules.put(conatining, b);
	}

	@Override
	protected String processResults() {
		return String.valueOf(processResults(SHINY_GOLD));
	}

	private int processResults(String color) {
		if (!rules.containsKey(color)) {
			results.put(color, 0);
			return 0;
		}

		if (results.containsKey(color)) {
			return results.get(color);
		}

		int sum = 0;
		for (BagDescription bag : rules.get(color)) {
			sum += bag.numberOfBags * (processResults(bag.color) + 1);
		}
		results.put(color, sum);
		return sum;
	}
}
