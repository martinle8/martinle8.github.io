import java.awt.*;

public class Lion extends Critter {
	// private variables to measure the count of the instances and the previous color of the lion
	private int count;
	private Color initialColor;
	
	// constructor for the critter lion
	public Lion() {
		this.count = 0;
	}
	
	// returns the color of the lion
	public Color getColor() {
		if ((count) % 3 == 0) {
			Color randomColor = getRandomColor();
			this.initialColor = randomColor;
			return randomColor;
		}
			return this.initialColor;
	}
	
	// returns the string value of the Lion
	public String toString() {
		return "L";
	}
	
	// returns the move to be made by the lion
	public Action getMove(CritterInfo info) {
		this.count = this.count + 1;
		if (info.getFront() == Neighbor.OTHER) {
			return Action.INFECT;
		} else if (info.getFront() == Neighbor.WALL || info.getRight() == Neighbor.WALL) {
			return Action.LEFT;
		} else if (info.getFront() == Neighbor.SAME) {
			return Action.RIGHT;
		} else {
			return Action.HOP;
		}
	}
	
	// returns a random color (either red, blue or green)
	private Color getRandomColor() {
		double number = Math.random();
		if (number < (1.0 / 3)) {
			return Color.RED;
		} else if (number > (2.0 / 3)) {
			return Color.GREEN;
		} else {
			return Color.BLUE;
		}
	}
}
