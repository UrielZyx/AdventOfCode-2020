package day16;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Day16_2 extends Day16_1 {

	Map<String, TreeMap<Integer, Integer>> fields = new HashMap<>();
	List<List<Integer>> otherTickets = new ArrayList<>();
	List<List<String>> possibleMappings = new ArrayList<>();
	List<Integer> myTicketValues = new ArrayList<>();
	Map<String, Integer> myTicket = new HashMap<>();

	public static void main(String[] args) {
		new Day16_2().testAndPrint();
	}

	@Override
	protected void addField(String name, Integer min1, Integer max1, Integer min2, Integer max2) {
		super.addField(name, min1, max1, min2, max2);

		TreeMap<Integer, Integer> constraints = new TreeMap<>();
		constraints.put(min1, max1);
		constraints.put(min2, max2);
		fields.put(name, constraints);
	}

	@Override
	protected void readOwnTicket(String line) {
		Arrays
				.stream(line.split(","))
				.map(Integer::valueOf)
				.forEach(myTicketValues::add);

		myTicketValues.forEach(v -> {
			otherTickets.add(new ArrayList<>());
			ArrayList<String> mappings = new ArrayList<>();
			fields.keySet().forEach(mappings::add);
			possibleMappings.add(mappings);
		});
	}

	@Override
	protected void scanTicket(String line) {
		String[] values = line.split(",");
		boolean isValid = Arrays
				.stream(values)
				.map(Integer::valueOf)
				.allMatch(this::isValid);

		if (isValid) {
			for (int i = 0; i < values.length; i++) {
				otherTickets.get(i).add(Integer.valueOf(values[i]));
			}
		}
	}

	@Override
	protected String computeResult() {
		processMyTicket();
		if (isTest) {
			return myTicket
					.entrySet()
					.stream()
					.map(f -> f.getKey() + ": " + f.getValue())
					.collect(Collectors.joining(", "));
		}
		return String.valueOf(
				myTicket
						.keySet()
						.stream()
						.filter(f -> f.startsWith("departure "))
						.map(myTicket::get)
						.map(Long::valueOf)
						.reduce(1L, (a, b) -> a * b));
	}

	private void processMyTicket() {

		findMappings();

		for (int i = 0; i < myTicketValues.size(); i++) {
			myTicket.put(possibleMappings.get(i).get(0), myTicketValues.get(i));
		}
	}

	private void findMappings() {
		Set<String> found = new HashSet<>();

		IntStream.range(0, possibleMappings.size()).forEach(i -> {
			List<String> mappingstoRemove = new ArrayList<>();
			possibleMappings.get(i).forEach(mapping -> {
				boolean isValidMapping = otherTickets.get(i).stream().allMatch(v -> isValid(v, fields.get(mapping)));
				if (!isValidMapping) {
					mappingstoRemove.add(mapping);
				}
			});
			possibleMappings.get(i).removeAll(mappingstoRemove);
		});

		while (found.size() < fields.size()) {
			possibleMappings.forEach(mappings -> {
				if (mappings.size() > 1) {
					found.forEach(mappings::remove);
				}
				if (mappings.size() == 1) {
					found.add(mappings.get(0));
				}
			});
		}
	}
}