package common;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class InputReader {

	public static final String PATH = "C:\\urm\\advent-of-code\\AdventOfCode-2020\\src\\";
	public static final String DAY = "day";

	public static List<String> readLines(int dayNumber, String fileName) {
		return readLines(filaPath(dayNumber, fileName));
	}

	public static List<String> readLines(String fileName) {
		try (BufferedReader reader = new BufferedReader(new FileReader(PATH + fileName))) {
			return reader.lines().collect(Collectors.toList());
		} catch (IOException e) {
			e.printStackTrace();
		}
		return new ArrayList<>();
	}

	public static List<List<Character>> readMap(int dayNumber, String fileName) {
		return readMap(filaPath(dayNumber, fileName));
	}

	public static List<List<Character>> readMap(String fileName) {
		try (BufferedReader reader = new BufferedReader(new FileReader(PATH + fileName))) {
			return reader
					.lines()
					.map(s -> (s
							.chars()
							.mapToObj(i -> (char) i)
							.collect(Collectors.toList())))
					.collect(Collectors.toList());
		} catch (IOException e) {
			e.printStackTrace();
		}
		return new ArrayList<>();
	}

	private static String filaPath(int dayNumber, String fileName) {
		return DAY + dayNumber + File.separator + fileName;
	}
}
