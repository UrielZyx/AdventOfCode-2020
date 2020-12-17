package common.dataStructures;

import java.util.ArrayList;
import java.util.List;

import org.javatuples.Pair;

import com.google.common.collect.ArrayListMultimap;
import com.google.common.collect.Multimap;

public class Grid {

	protected enum Direction {
		N(0, 1), E(1, 0), W(-1, 0), S(0, -1), NE(1, 1), NW(-1, 1), SE(1, -1), SW(-1, -1);

		public int i, j;

		private Direction(int i, int j) {
			this.i = i;
			this.j = j;
		}
	}

	protected static final char BORDER = 'X';

	protected List<List<Character>> grid = new ArrayList<>();
	protected int height;
	protected int width;
	protected Multimap<Pair<Integer, Integer>, Pair<Integer, Integer>> adjacencies = ArrayListMultimap.create();

	public Grid() {
		super();
	}

	protected void calculateAdjacencies() {
		for (int i = 0; i < height; i++) {
			for (int j = 0; j < width; j++) {
				for (Direction dir : Direction.values()) {
					adjacencies.put(Pair.with(i, j), getAdjacency(i, j, dir));
				}
			}
		}
	}

	protected Pair<Integer, Integer> getAdjacency(int i, int j, Direction dir) {
		return Pair.with(i + dir.i, j + dir.j);
	}

	protected char get(int i, int j) {
		if (i < 0 || i >= height || j < 0 || j >= width) {
			return BORDER;
		}
		return grid.get(i).get(j);
	}

}