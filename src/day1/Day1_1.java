package day1;

import java.util.HashSet;
import java.util.Set;

import FileIO.InputReader;

public class Day1_1 {

	private static final String INPUT = "input.txt"; // "test input.txt";
	private static final int TARGET = 2020;

	public static void main(String[] args) {
		Set<Integer> values = new HashSet<>();

		for (String v : InputReader.read(1, INPUT)) {
			int n = Integer.parseInt(v);
			if (values.contains(TARGET - n)) {
				System.out.println(n * (TARGET - n));
			}
			values.add(n);
		}
	}
}
