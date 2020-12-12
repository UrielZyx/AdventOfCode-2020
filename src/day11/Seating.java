package day11;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.stream.Collectors;

import org.javatuples.Pair;

import com.google.common.collect.ArrayListMultimap;
import com.google.common.collect.Multimap;

public class Seating {

	protected enum Direction {
		N(0, 1), E(1, 0), W(-1, 0), S(0, -1), NE(1, 1), NW(-1, 1), SE(1, -1), SW(-1, -1);

		public int i, j;

		private Direction(int i, int j) {
			this.i = i;
			this.j = j;
		}
	}

	protected final static char FLOOR = '.';
	protected final static char SEAT = 'L';
	protected final static char TAKEN = '#';
	protected final static char BORDER = 'X';

	protected int height, width, limit;
	protected List<List<Character>> seatings = new ArrayList<>();
	protected Multimap<Pair<Integer, Integer>, Pair<Integer, Integer>> adjacencies = ArrayListMultimap.create();

	public Seating(List<List<Character>> map, int limit) {

		this.limit = limit;

		height = map.size();
		width = map.get(0).size();

		for (int i = 0; i < height; i++) {
			seatings.add(new ArrayList<>());
			for (int j = 0; j < width; j++) {
				seatings.get(i).add(map.get(i).get(j));
			}
		}

		calculateAdjacencies();
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

	public String getState() {
		return seatings
				.stream()
				.flatMap(List::stream)
				.map(String::valueOf)
				.collect(Collectors.joining());
	}

	public void iterate() {
		Queue<Pair<Integer, Integer>> taken = new LinkedList<>();
		Queue<Pair<Integer, Integer>> freed = new LinkedList<>();

		for (int i = 0; i < height; i++) {
			for (int j = 0; j < width; j++) {
				if (get(i, j) != FLOOR) {
					int neighbors = countAdjacentOccupied(i, j);
					if (neighbors == 0) {
						taken.add(Pair.with(i, j));
					}
					if (neighbors >= limit) {
						freed.add(Pair.with(i, j));
					}
				}
			}
		}

		while (!taken.isEmpty()) {
			Pair<Integer, Integer> pos = taken.poll();
			seatings.get(pos.getValue0()).set(pos.getValue1(), TAKEN);
		}

		while (!freed.isEmpty()) {
			Pair<Integer, Integer> pos = freed.poll();
			seatings.get(pos.getValue0()).set(pos.getValue1(), SEAT);
		}
	}

	private int countAdjacentOccupied(int i, int j) {
		return adjacencies.get(Pair.with(i, j))
				.stream()
				.mapToInt(p -> getOccupied(p.getValue0(), p.getValue1()))
				.sum();
	}

	private int getOccupied(int i, int j) {
		return get(i, j) == TAKEN ? 1 : 0;
	}

	protected char get(int i, int j) {
		if (i < 0 || i >= height || j < 0 || j >= width) {
			return BORDER;
		}
		return seatings.get(i).get(j);
	}
}