package day11;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.stream.Collectors;

import org.javatuples.Pair;

public class Seating {

	protected final static char FLOOR = '.';
	protected final static char SEAT = 'L';
	protected final static char TAKEN = '#';
	protected final static char BORDER = 'X';

	int height, width;
	List<List<Character>> seatings = new ArrayList<>();
	int limit = 4;
	boolean lineOfSight = false;

	public Seating(List<List<Character>> map) {
		height = map.size();
		width = map.get(0).size();

		for (int i = 0; i < height; i++) {
			seatings.add(new ArrayList<>());
			for (int j = 0; j < width; j++) {
				seatings.get(i).add(map.get(i).get(j));
			}
		}
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
		return getOccupied(i - 1, j - 1)
				+ getOccupied(i - 1, j)
				+ getOccupied(i - 1, j + 1)
				+ getOccupied(i, j - 1)
				+ getOccupied(i, j + 1)
				+ getOccupied(i + 1, j - 1)
				+ getOccupied(i + 1, j)
				+ getOccupied(i + 1, j + 1);
	}

	private int getOccupied(int i, int j) {
		return get(i, j) == TAKEN ? 1 : 0;
	}

	private char get(int i, int j) {
		if (i < 0 || i >= height || j < 0 || j >= width) {
			return BORDER;
		}
		return seatings.get(i).get(j);
	}
}