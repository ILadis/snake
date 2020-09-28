package snake;

import java.awt.Canvas;
import java.awt.Frame;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;

import snake.game.Game;
import snake.gfx.BorderPaint;
import snake.gfx.KeyController;
import snake.gfx.Scene;
import snake.gfx.SnackPaint;
import snake.gfx.SnakePaint;

public class Main {

	public static void main(String[] args) {
		Frame frame = new Frame();
		frame.setTitle("Snake AI");
		frame.setVisible(true);
		frame.setResizable(false);

		Canvas canvas = new Canvas();
		canvas.setSize(420, 520);

		frame.add(canvas);
		frame.pack();

		KeyController controller = KeyController.forArrowKeys();
		// Controller controller = new BasicTypeController.Adapter(new SimpleController());

		Game game = new Game(controller);
		game.setup();

		Scene scene = new Scene(canvas);
		scene.add(new BorderPaint(game.border()));
		scene.add(new SnakePaint(game.snake()));
		scene.add(new SnackPaint(game.food()));

		Runnable task = () -> {
			game.step(0.010d);
			scene.draw(0.010d);
		};

		ScheduledExecutorService scheduler = Executors.newScheduledThreadPool(1);
		ScheduledFuture<?> loop = scheduler.scheduleAtFixedRate(task, 0, 10, TimeUnit.MILLISECONDS);

		canvas.addKeyListener(controller);
		canvas.requestFocus();

		frame.addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				loop.cancel(false);
				scheduler.shutdown();
				frame.dispose();
			}
		});
	}
}
