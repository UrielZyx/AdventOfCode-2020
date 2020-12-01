package FileIO;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class InputReader {
	public static List<String> read(String fileName) {
		try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
			return reader.lines().collect(Collectors.toList());
		} catch (IOException e) {
			e.printStackTrace();
		}
		return new ArrayList<>();
	}
}
