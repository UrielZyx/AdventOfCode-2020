package day10;

import static java.math.BigInteger.ONE;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Day10_2 extends Day10_1 {

	public static void main(String[] args) {
		new Day10_2().testAndPrint();
	}

	@Override
	protected String processDiffs(List<Integer> diffs) {
		int length = 0, maxLength = 0;
		Map<Integer, Integer> counts = new HashMap<>();
		List<BigInteger> options = new ArrayList<>(Arrays.asList(ONE, ONE, BigInteger.valueOf(2)));

		for (Integer d : diffs) {
			if (d == 1) {
				length++;
			} else {
				if (maxLength < length) {
					maxLength = length;
				}
				counts.put(length, counts.getOrDefault(length, 0) + 1);
				length = 0;
			}
		}

		for (int i = options.size(); i <= maxLength; i++) {
			options.add(options.get(i - 1).add(options.get(i - 2)).add(options.get(i - 3)));
		}

		return counts.keySet()
				.stream()
				.map(i -> options.get(i).pow(counts.get(i)))
				.reduce(ONE,
						(a, b) -> a.multiply(b))
				.toString();
	}
}
