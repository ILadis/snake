package snake.game;

public enum Direction {
	UP(0, -1), DOWN(0, 1), RIGHT(1, 0), LEFT(-1, 0);

	private Point vector;

	private Direction(Integer x, Integer y) {
		this.vector = Point.of(x, y);
	}

	public Direction inverse() {
		switch (this) {
		case UP:
			return DOWN;
		case DOWN:
			return UP;
		case RIGHT:
			return LEFT;
		default:
			return RIGHT;
		}
	}

	public Point toPoint() {
		return vector;
	}
}
