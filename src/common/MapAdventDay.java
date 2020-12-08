package common;

import java.util.List;

public abstract class MapAdventDay extends AdventDay {

	@Override
	protected String runConcrete(String fileName) {
		List<List<Character>> map = InputReader.readMap(getDay(), fileName);
		return processMap(map);
	}

	abstract String processMap(List<List<Character>> map);

}
