package snake.gfx;

import java.awt.Graphics2D;

import snake.game.Point;
import snake.game.Snack;

public class SnackPaint implements Paint {
	private Snack snack;

	public SnackPaint(Snack food) {
		this.snack = food;
	}

	@Override
	public void draw(Graphics2D gfx, Double dtime) {
		Integer grid = Sizes.GRID_SIZE;

		Point position = snack.position();

		Integer x = position.x() * grid;
		Integer y = position.y() * grid;

		gfx.setColor(Colors.FOUR);
		gfx.setStroke(Sizes.STROKE_LARGE);

		gfx.drawLine(x + 10, y +  3, x + 10, y +  6);
		gfx.drawLine(x + 10, y + 14, x + 10, y + 17);

		gfx.drawLine(x +  3, y + 10, x +  6, y + 10);
		gfx.drawLine(x + 14, y + 10, x + 17, y + 10);
	}

}
