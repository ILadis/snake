package snake.game;

public enum Direction {
	UP(0, -1), DOWN(0, 1), RIGHT(1, 0), LEFT(-1, 0);

	private Point vector;

	private Direction(Integer x, Integer y) {
		this.vector = Point.of(x, y);
	}

	public Point toVector() {
		return vector;
	}
}
