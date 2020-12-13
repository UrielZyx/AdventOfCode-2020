package day13;

import java.util.List;

import common.LineAdventDay;

public class Day13_1 extends LineAdventDay {

	@Override
	protected int getDay() {
		return 13;
	}

	public static void main(String[] args) {
		new Day13_1().testAndPrint();
	}

	@Override
	protected String processLines(List<String> lines) {
		int startTime = Integer.valueOf(lines.get(0));
		String[] busses = lines.get(1).split(",");
		return processBusses(startTime, busses);
	}

	protected String processBusses(int startTime, String[] busses) {
		int minBus = 0, minTime = Integer.MAX_VALUE;
		for (String b : busses) {
			if (!b.equals("x")) {
				int busNumber = Integer.valueOf(b);
				int time = busNumber - (startTime % busNumber);
				if (time < minTime) {
					minTime = time;
					minBus = busNumber;
				}
			}
		}
		return String.valueOf(minTime * minBus);
		// return Arrays.stream(busses)
		// .filter(b -> !b.equals("x"))
		// .mapToInt(Integer::valueOf)
		// .map(b -> b - (startTime % b))
		// .min()
		// .orElse(-1);
	}

}
