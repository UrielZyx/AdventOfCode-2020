package day12;

import common.SerialLineAdventDay;

public class Day12_1 extends SerialLineAdventDay {

	protected int east, north, currentDir;
	protected char[] directions = new char[] { 'E', 'S', 'W', 'N' };

	@Override
	protected int getDay() {
		return 12;
	}

	public static void main(String[] args) {
		new Day12_1().testAndPrint();
	}

	@Override
	protected void processLine(String line) {
		char dir = line.charAt(0);
		int amount = Integer.valueOf(line.substring(1));
		move(dir, amount);
	}

	protected void move(char dir, int amount) {
		if (dir == 'R') {
			currentDir += amount / 90;
		}
		if (dir == 'L') {
			currentDir += 4 - amount / 90;
		}
		if (dir == 'F') {
			dir = directions[currentDir % 4];
		}
		switch (dir) {
		case 'N':
			north += amount;
			break;
		case 'E':
			east += amount;
			break;
		case 'S':
			north -= amount;
			break;
		case 'W':
			east -= amount;
			break;

		default:
			break;
		}
	}

	@Override
	protected String processResults() {
		return String.valueOf(Math.abs(east) + Math.abs(north));
	}
}
