package day7;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Queue;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.commons.lang3.StringUtils;

import com.google.common.collect.ArrayListMultimap;
import com.google.common.collect.Multimap;

import common.LineAdventDay;

public class Day7_1 extends LineAdventDay {

	private static final String BAG = "bag";
	protected static final String SHINY_GOLD = "shiny gold";
	Multimap<String, String> rulesByContained = ArrayListMultimap.create();
	Pattern p = Pattern.compile("\\d+");

	public static void main(String[] args) {
		new Day7_1().print();
	}

	@Override
	protected int getDay() {
		return 7;
	}

	@Override
	protected void processLine(String line) {
		int end = line.indexOf(BAG);
		String conatining = line.substring(0, end).trim();
		List<BagDescription> contained = new ArrayList<>();
		for (String endOfLine = nextNumber(line); StringUtils
				.isNotBlank(endOfLine); endOfLine = nextNumber(endOfLine)) {
			int begin = endOfLine.indexOf(' ');
			end = endOfLine.indexOf(BAG);
			contained.add(BagDescription.of(Integer.parseInt(endOfLine.substring(0, begin)),
					endOfLine.substring(begin, end).trim()));
		}
		contained.stream().forEach(b -> processBag(conatining, b));
	}

	protected void processBag(String conatining, BagDescription b) {
		rulesByContained.put(b.color, conatining);
	}

	private String nextNumber(String line) {
		Matcher m = p.matcher(line);
		while (m.find()) {
			if (m.start() > 0) {
				return line.substring(m.start());
			}
		}
		return StringUtils.EMPTY;
	}

	@Override
	protected String processResults() {
		Set<String> possibleColors = new HashSet<>();
		Queue<String> visited = new ArrayDeque<>();
		visited.add(SHINY_GOLD);
		while (!visited.isEmpty()) {
			String current = visited.poll();
			if (!possibleColors.contains(current)) {
				possibleColors.add(current);
				visited.addAll(rulesByContained.get(current));
			}
		}
		possibleColors.remove(SHINY_GOLD);
		return String.valueOf(possibleColors.size());
	}
}
