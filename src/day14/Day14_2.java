package day14;

public class Day14_2 extends Day14_1 {

	public static void main(String[] args) {
		new Day14_2().testAndPrint();
	}

	@Override
	protected void updateMemory(Long address, Long value) {
		String maskedAddress = currentMask;
		String binaryAddress = Long.toBinaryString(address);
		int d = maskedAddress.length() - binaryAddress.length();
		for (int i = 0; i < binaryAddress.length(); i++) {
			if (maskedAddress.charAt(d + i) == '0') {
				maskedAddress = replaceCharAtIndex(maskedAddress, d + i, binaryAddress.charAt(i));
			}
		}
		put(maskedAddress, value);
	}

	private void put(String maskedAddress, Long value) {
		if (maskedAddress.contains("X")) {
			put(maskedAddress.replaceFirst("X", "0"), value);
			put(maskedAddress.replaceFirst("X", "1"), value);
		} else {
			memory.put(Long.valueOf(maskedAddress, 2), value);
		}
	}
}
