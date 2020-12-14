package day14;

import java.util.HashMap;
import java.util.Map;

import common.SerialLineAdventDay;

public class Day14_1 extends SerialLineAdventDay {

	private static final String MASK = "mask ";
	String currentMask = "";
	Map<Integer, Long> memory = new HashMap<>();

	@Override
	protected int getDay() {
		return 14;
	}

	public static void main(String[] args) {
		new Day14_1().testAndPrint();
	}

	@Override
	protected void processLine(String line) {
		String[] assignment = line.split("=");
		if (MASK.equals(assignment[0])) {
			updateMask(assignment[1].substring(1));
		} else {
			updateMemory(assignment);
		}
	}

	private void updateMask(String mask) {
		currentMask = mask;
	}

	private void updateMemory(String[] assignment) {
		updateMemory(assignment[0].split("[\\[\\]]")[1], assignment[1].substring(1));
	}

	private void updateMemory(String left, String right) {
		Integer address = Integer.valueOf(left);
		Long value = Long.valueOf(right);
		String maskedValue = currentMask;
		String binaryValue = Long.toBinaryString(value);
		int d = maskedValue.length() - binaryValue.length();
		for (int i = 0; i < d; i++) {
			if (maskedValue.charAt(i) == 'X') {
				maskedValue = maskedValue.replaceFirst("X", "0");
			}
		}
		for (int i = 0; i < binaryValue.length(); i++) {
			if (maskedValue.charAt(d + i) == 'X') {
				maskedValue = maskedValue.replaceFirst("X", String.valueOf(binaryValue.charAt(i)));
			}
		}
		memory.put(address, Long.valueOf(maskedValue, 2));
	}

	@Override
	protected String processResults() {
		return String.valueOf(memory
				.keySet()
				.stream()
				.map(memory::get)
				.mapToLong(Long::valueOf)
				.sum());
	}
}
