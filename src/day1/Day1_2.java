
package day1;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Day1_2 extends Day1_1 {

	Set<Integer> singles = new HashSet<>();
	Map<Integer, Integer> doubles = new HashMap<>();

	public static void main(String[] args) {
		new Day1_2().print();
	}

	@Override
	protected void processLine(String line) {
		int n = Integer.parseInt(line);
		int m = TARGET - n;
		if (doubles.containsKey(m)) {
			result = Integer.toString(n * doubles.get(m) * (m - doubles.get(m)));
		}
		singles.add(n);
		for (int o : singles) {
			doubles.put(o + n, n);
		}
	}
}
