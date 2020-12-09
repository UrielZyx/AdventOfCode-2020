package day08;

public class Instruction {

	public enum Command {
		NOP, ACC, JMP
	}

	public Command command;
	public int parameter;

	public static Instruction create(String instruction) {
		String[] params = instruction.split(" ");
		return create(params[0], Integer.valueOf(params[1]));
	}

	public static Instruction create(String command, int parameter) {
		return new Instruction(command, parameter);
	}

	private Instruction(String command, int parameter) {
		super();
		this.command = Command.valueOf(command.toUpperCase());
		this.parameter = parameter;
	}
}
