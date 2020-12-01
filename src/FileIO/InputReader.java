package FileIO;

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

	public static List<String> readLines(int day, String fileName) {
		return readLines(DAY + day + File.separator + fileName);
	}

	public static List<String> readLines(String fileName) {
		try (BufferedReader reader = new BufferedReader(new FileReader(PATH + fileName))) {
			return reader.lines().collect(Collectors.toList());
		} catch (IOException e) {
			e.printStackTrace();
		}
		return new ArrayList<>();
	}
}
