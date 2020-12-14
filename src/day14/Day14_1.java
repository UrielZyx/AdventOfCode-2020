package day14;

import java.util.HashMap;
import java.util.Map;

import common.SerialLineAdventDay;

public class Day14_1 extends SerialLineAdventDay {

	private static final String MASK = "mask ";
	protected String currentMask = "";
	protected Map<Long, Long> memory = new HashMap<>();

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
		Long address = Long.valueOf(left);
		Long value = Long.valueOf(right);
		updateMemory(address, value);
	}

	protected void updateMemory(Long address, Long value) {
		String maskedValue = currentMask;
		String binaryValue = Long.toBinaryString(value);
		int d = maskedValue.length() - binaryValue.length();
		for (int i = 0; i < d; i++) {
			if (maskedValue.charAt(i) == 'X') {
				maskedValue = replaceCharAtIndex(maskedValue, i, '0');
			}
		}
		for (int i = 0; i < binaryValue.length(); i++) {
			if (maskedValue.charAt(d + i) == 'X') {
				maskedValue = replaceCharAtIndex(maskedValue, d + i, binaryValue.charAt(i));
			}
		}
		memory.put(address, Long.valueOf(maskedValue, 2));
	}

	protected String replaceCharAtIndex(String str, int i, char c) {
		return str.substring(0, i) + c + str.substring(i + 1);
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
