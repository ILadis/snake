package snake.game;

public class Border implements Touchable {
	private Point dimensions;

	public Border(Point dimensions) {
		this.dimensions = dimensions;
	}

	public Point dimensions() {
		return dimensions;
	}

	@Override
	public Boolean touches(Touchable other) {
		Point point = other.position();
		if (point.x() == 0 || point.y() == 0) {
			return true;
		}

		if (point.x() == dimensions.x() || point.y() == dimensions.y()) {
			return true;
		}

		return false;
	}

	@Override
	public Point position() {
		return Point.of(0, 0);
	}
}
