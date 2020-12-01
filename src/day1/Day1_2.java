
package day1;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import FileIO.InputReader;

public class Day1_2 {

	private static final String INPUT = "input.txt"; // "test input.txt";
	private static final int TARGET = 2020;

	public static void main(String[] args) {
		Set<Integer> singles = new HashSet<>();
		Map<Integer, Integer> doubles = new HashMap<>();

		for (String v : InputReader.readLines(1, INPUT)) {
			int n = Integer.parseInt(v);
			int m = TARGET - n;
			if (doubles.containsKey(m)) {
				System.out.println(n * doubles.get(m) * (m - doubles.get(m)));
			}
			singles.add(n);
			for (int o : singles) {
				doubles.put(o + n, n);
			}
		}
	}
}
