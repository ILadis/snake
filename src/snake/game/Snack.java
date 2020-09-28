package snake.game;

public class Snack implements Touchable {
	private Point position;

	public Snack(Point position) {
		this.position = position;
	}

	@Override
	public Point position() {
		return position;
	}
}
