package snake.gfx;

import java.awt.Graphics2D;
import java.util.Iterator;

import snake.game.Part;
import snake.game.Point;
import snake.game.Snake;
import snake.game.Timer;

public class SnakePaint implements Paint {
	private Snake snake;
	private Point head;
	private Timer timer;

	public SnakePaint(Snake snake) {
		this.snake = snake;
		this.head = snake.head().position().copy();
		this.timer = new Timer(0.1d);
	}

	@Override
	public void draw(Graphics2D gfx, Double dtime) {
		Double progress = getProgress(dtime);

		Iterator<Part> iterator = snake.head().iterator();
		Part part, child = iterator.next();

		Point direction = Point.of(0, 0);

		while (iterator.hasNext()) {
			part = child;
			child = iterator.next();

			Point position = part.position();
			direction.assign(child.position()).minus(position);

			drawPart(gfx, position, direction, progress);
		}
	}

	private void drawPart(Graphics2D gfx, Point position, Point direction, Double progress) {
		Integer grid = Sizes.GRID_SIZE;

		Integer x = position.x() * grid;
		Integer y = position.y() * grid;

		Long dx = Math.round(progress * grid * direction.x());
		Long dy = Math.round(progress * grid * direction.y());

		x += dx.intValue();
		y += dy.intValue();

		gfx.setStroke(Sizes.STROKE_MEDIUM);
		gfx.setColor(Colors.TWO);
		gfx.fillRect(x + 2, y + 2, grid - 4, grid - 4);

		gfx.setColor(Colors.FOUR);
		gfx.drawRect(x + 2, y + 2, grid - 4, grid - 4);
		gfx.fillRect(x + 5, y + 5, grid - 7, grid - 7);
	}

	private Double getProgress(Double dtime) {
		Double progress = timer.advance(dtime);
		if (progress > 1d) {
			progress = 1d;

			if (hasMoved()) {
				progress = 0d;
				timer.reset(0d);
			}
		}

		return 1d - progress;
	}

	private Boolean hasMoved() {
		Point head = snake.head().position();
		Boolean moved = !head.equals(this.head);

		this.head.assign(head);

		return moved;
	}
}
