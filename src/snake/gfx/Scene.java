package snake.gfx;

import java.awt.Canvas;
import java.awt.Graphics2D;
import java.awt.image.BufferStrategy;
import java.util.ArrayList;
import java.util.List;

public class Scene {
	private Canvas canvas;
	private List<Paint> paints;

	public Scene(Canvas canvas) {
		this.canvas = canvas;
		this.paints = new ArrayList<>();
	}

	public void add(Paint paint) {
		paints.add(paint);
	}

	public void draw(Double dtime) {
		BufferStrategy bs = canvas.getBufferStrategy();
		if (bs == null) {
			canvas.createBufferStrategy(2);
			return;
		}

		Graphics2D gfx = (Graphics2D) bs.getDrawGraphics();
		gfx.clearRect(0, 0, canvas.getWidth(), canvas.getHeight());

		for (Paint paint : paints) {
			paint.draw(gfx, dtime);
		}

		gfx.dispose();
		bs.show();
	}

}
