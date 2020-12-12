package day11;

import java.util.List;

import org.javatuples.Pair;

public class LineOfSightSeating extends Seating {

	public LineOfSightSeating(List<List<Character>> map, int limit) {
		super(map, limit);
	}

	@Override
	protected Pair<Integer, Integer> getAdjacency(int i, int j, Direction dir) {
		char value = FLOOR;
		int k = 1;
		do {
			value = get(i + k * dir.i, j + k * dir.j);
			if (value == SEAT || value == TAKEN) {
				return Pair.with(i + k * dir.i, j + k * dir.j);
			}
			k++;
		} while (value != BORDER);
		return Pair.with(-1, -1);
	}
}
