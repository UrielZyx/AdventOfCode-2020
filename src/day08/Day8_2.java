package day08;

import static day08.Instruction.Command.*;

import java.util.List;

public class Day8_2 extends Day8_1 {

	public static void main(String[] args) {
		new Day8_2().testAndPrint();
	}

	@Override
	protected String processLines(List<String> lines) {
		List<Instruction> instructions = getInstructions(lines);
		for (Instruction instruction : instructions) {
			String result = null;
			if (instruction.command.equals(NOP)) {
				instruction.command = JMP;
				result = runProgram(instructions);
				instruction.command = NOP;
			}
			if (instruction.command.equals(JMP)) {
				instruction.command = NOP;
				result = runProgram(instructions);
				instruction.command = JMP;

			}
			if (result != null) {
				return result;
			}
		}
		return null;
	}

	@Override
	protected String stuckInLoop(int accumulator) {
		return null;
	}

	@Override
	protected String terminated(int accumulator) {
		return String.valueOf(accumulator);
	}
}
