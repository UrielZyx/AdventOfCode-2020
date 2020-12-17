package day11;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.stream.Collectors;

import org.javatuples.Pair;

import common.dataStructures.Grid;

public class Seating extends Grid {

	protected final static char FLOOR = '.';
	protected final static char SEAT = 'L';
	protected final static char TAKEN = '#';

	protected int limit;

	public Seating(List<List<Character>> map, int limit) {

		this.limit = limit;

		height = map.size();
		width = map.get(0).size();

		for (int i = 0; i < height; i++) {
			grid.add(new ArrayList<>());
			for (int j = 0; j < width; j++) {
				grid.get(i).add(map.get(i).get(j));
			}
		}

		calculateAdjacencies();
	}

	public String getState() {
		return grid
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
			grid.get(pos.getValue0()).set(pos.getValue1(), TAKEN);
		}

		while (!freed.isEmpty()) {
			Pair<Integer, Integer> pos = freed.poll();
			grid.get(pos.getValue0()).set(pos.getValue1(), SEAT);
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
}