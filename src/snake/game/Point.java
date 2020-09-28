package snake.game;

import java.util.Random;

public class Point {
	private Integer x, y;

	public static Point of(Integer x, Integer y) {
		return new Point(x, y);
	}

	public static Point random(Random random, Point max) {
		return new Point(random.nextInt(max.x), random.nextInt(max.y));
	}

	private Point(Integer x, Integer y) {
		this.x = x;
		this.y = y;
	}

	public Integer x() {
		return x;
	}

	public Integer y() {
		return y;
	}

	public Point assign(Point other) {
		this.x = other.x;
		this.y = other.y;
		return this;
	}

	public Point add(Point other) {
		this.x += other.x;
		this.y += other.y;
		return this;
	}

	public Point minus(Point other) {
		this.x -= other.x;
		this.y -= other.y;
		return this;
	}

	public Point copy() {
		return new Point(x, y);
	}

	@Override
	public boolean equals(Object object) {
		if (object instanceof Point) {
			Point other = (Point) object;
			return x.equals(other.x) && y.equals(other.y);
		}

		return super.equals(object);
	}

	@Override
	public String toString() {
		return String.format("[%d, $d]", x, y);
	}
}
