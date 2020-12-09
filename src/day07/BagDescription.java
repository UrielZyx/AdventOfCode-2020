package day07;

public class BagDescription {
	int numberOfBags;
	String color;

	public static BagDescription of(int numberOfBags, String color) {
		return new BagDescription(numberOfBags, color);
	}

	private BagDescription(int numberOfBags, String color) {
		this.numberOfBags = numberOfBags;
		this.color = color;
	}

	public int getNumberOfBags() {
		return numberOfBags;
	}

	public void setNumberOfBags(int numberOfBags) {
		this.numberOfBags = numberOfBags;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}
}
