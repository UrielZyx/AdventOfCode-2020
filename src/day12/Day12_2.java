package day12;

public class Day12_2 extends Day12_1 {

	int wpn = 1, wpe = 10;

	public static void main(String[] args) {
		new Day12_2().testAndPrint();
	}

	@Override
	protected void move(char dir, int amount) {
		int tmp;
		switch (dir) {
		case 'F':
			north += wpn * amount;
			east += wpe * amount;
			break;
		case 'N':
			wpn += amount;
			break;
		case 'E':
			wpe += amount;
			break;
		case 'S':
			wpn -= amount;
			break;
		case 'W':
			wpe -= amount;
			break;
		case 'R':
			for (int i = 0; i < amount / 90; i++) {
				tmp = wpn;
				wpn = -wpe;
				wpe = tmp;
			}
			break;
		case 'L':
			for (int i = 0; i < amount / 90; i++) {
				tmp = wpn;
				wpn = wpe;
				wpe = -tmp;
			}
			break;

		default:
			break;
		}
	}
}
