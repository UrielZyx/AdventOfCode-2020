package day08;

import static day08.Instruction.Command.*;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import common.LineAdventDay;

public class Day8_1 extends LineAdventDay {

	@Override
	protected int getDay() {
		return 8;
	}

	public static void main(String[] args) {
		new Day8_1().testAndPrint();
		// System.out.println(new Day8_1().test());
	}

	@Override
	protected String processLines(List<String> lines) {
		return runProgram(getInstructions(lines));
	}

	protected List<Instruction> getInstructions(List<String> lines) {
		return lines
				.stream()
				.map(Instruction::create)
				.collect(Collectors.toList());
	}

	protected String runProgram(List<Instruction> instructions) {
		int accumulator = 0, i = 0;
		Set<Integer> visited = new HashSet<>();
		while (i != instructions.size()) {
			if (visited.contains(i)) {
				return stuckInLoop(accumulator);
			}
			visited.add(i);

			Instruction inst = instructions.get(i);
			if (inst.command.equals(JMP)) {
				i += inst.parameter;
			} else {
				i++;
				if (inst.command.equals(ACC)) {
					accumulator += inst.parameter;
				}
			}
		}
		return terminated(accumulator);
	}

	protected String stuckInLoop(int accumulator) {
		return String.valueOf(accumulator);
	}

	protected String terminated(int accumulator) {
		return null;
	}
}
