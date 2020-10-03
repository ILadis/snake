package snake.gfx;

import java.awt.Graphics2D;

import snake.game.Point;
import snake.game.Snack;

public class SnackPaint implements Paint {
	private Double angle;
	private Snack snack;

	public SnackPaint(Snack food) {
		this.snack = food;
		this.angle = Double.valueOf(0d);
	}

	@Override
	public void draw(Graphics2D gfx, Double dtime) {
		Point position = snack.position();

		angle += dtime * 180;

		drawSnack(gfx, position, angle, 0d);
		drawSnack(gfx, position, angle, 90d);
		drawSnack(gfx, position, angle, 180d);
		drawSnack(gfx, position, angle, 270d);
	}

	private void drawSnack(Graphics2D gfx, Point position, Double angle, Double offset) {
		Integer grid = Sizes.GRID_SIZE;

		Integer x = position.x() * grid + 10;
		Integer y = position.y() * grid + 10;

		Double rads = Math.toRadians(angle + offset);

		Double dx = Math.cos(rads);
		Double dy = Math.sin(rads);

		Long x1 = Math.round(x + dx * 5);
		Long y1 = Math.round(y + dy * 5);

		Long x2 = Math.round(x + dx * 8);
		Long y2 = Math.round(y + dy * 8);

		gfx.setColor(Colors.FOUR);
		gfx.setStroke(Sizes.STROKE_LARGE);
		gfx.drawLine(x1.intValue(), y1.intValue(), x2.intValue(), y2.intValue());
	}

}
