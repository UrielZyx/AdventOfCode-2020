package day09;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

public class Day9_2 extends Day9_1 {

	List<Long> values = new ArrayList<>();

	public static void main(String[] args) {
		new Day9_2().testAndPrint();
	}

	@Override
	protected void processValue(long value) {
		values.add(value);
		super.processValue(value);
	}

	@Override
	protected String processResults() {
		return String.valueOf(findSub());
	}

	private long findSub() {
		List<BigInteger> partialSums = new ArrayList<>();
		BigInteger target = BigInteger.valueOf(result);
		for (long v : values) {
			partialSums.add(BigInteger.valueOf(v));
		}
		for (int offset = 1; offset < values.size(); offset++) {
			for (int pos = 0; pos + offset < values.size(); pos++) {
				if (partialSums.get(pos).compareTo(target) <= 0) {
					partialSums.set(pos, partialSums.get(pos).add(BigInteger.valueOf(values.get(pos + offset))));
				}
				if (partialSums.get(pos).compareTo(target) == 0)
					return calculateWeakness(pos, offset);
			}
		}
		return -1;
	}

	private long calculateWeakness(int pos, int offset) {
		long min = Long.MAX_VALUE, max = 0;
		for (int i = pos; i <= pos + offset; i++) {
			long v = values.get(i);
			if (v > max)
				max = v;
			if (v < min)
				min = v;
		}
		return min + max;
	}
}
