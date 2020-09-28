package snake.gfx;

import java.awt.BasicStroke;
import java.awt.Graphics2D;

import snake.game.Border;
import snake.game.Point;

public class BorderPaint implements Paint {
	private Border border;

	public BorderPaint(Border border) {
		this.border = border;
	}

	@Override
	public void draw(Graphics2D gfx, Double dtime) {
		Integer grid = Sizes.GRID_SIZE;

		Point position = border.dimensions();

		Integer x = position.x() * grid + grid;
		Integer y = position.y() * grid + grid;

		gfx.setColor(Colors.TWO);
		gfx.fillRect(0, 0, x, y);

		gfx.setColor(Colors.ONE);
		gfx.fillRect(18, 18, x - 36, y - 36);

		gfx.setColor(Colors.FOUR);
		gfx.setStroke(new BasicStroke(2));

		gfx.drawRect(15, 15, x - 30, y - 30);
		gfx.drawRect(18, 18, x - 36, y - 36);
	}

}
