package snake.gfx;

import java.awt.Graphics2D;

import snake.game.Part;
import snake.game.Point;
import snake.game.Snake;

public class SnakePaint implements Paint {

	private Snake snake;

	public SnakePaint(Snake snake) {
		this.snake = snake;
	}

	@Override
	public void draw(Graphics2D gfx, Double dtime) {
		Integer grid = Sizes.GRID_SIZE;
		gfx.setStroke(Sizes.STROKE_MEDIUM);

		for (Part part : snake.head()) {
			Point position = part.position();

			Integer x = position.x() * grid;
			Integer y = position.y() * grid;

			gfx.setColor(Colors.TWO);
			gfx.fillRect(x + 2, y + 2, grid - 4, grid - 4);

			gfx.setColor(Colors.FOUR);
			gfx.drawRect(x + 2, y + 2, grid - 4, grid - 4);
			gfx.fillRect(x + 5, y + 5, grid - 7, grid - 7);
		}
	}

}
