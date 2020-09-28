package snake.gfx;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

import snake.game.Controller;
import snake.game.Direction;
import snake.game.Snack;
import snake.game.Snake;

public class KeyController extends KeyAdapter implements Controller {

	private Map<Integer, Direction> controls;
	private Queue<Direction> buffer;

	public static KeyController forArrowKeys() {
		Map<Integer, Direction> controls = new HashMap<>();
		controls.put(KeyEvent.VK_UP, Direction.UP);
		controls.put(KeyEvent.VK_DOWN, Direction.DOWN);
		controls.put(KeyEvent.VK_RIGHT, Direction.RIGHT);
		controls.put(KeyEvent.VK_LEFT, Direction.LEFT);

		return new KeyController(controls);
	}

	private KeyController(Map<Integer, Direction> controls) {
		this.buffer = new LinkedList<>();
		this.controls = controls;
	}

	@Override
	public void control(Snake snake, Snack snack) {
		while (!buffer.isEmpty()) {
			Direction direction = buffer.remove();

			if (!direction.inverse().equals(snake.direction())) {
				snake.direction(direction);
				break;
			}
		}
	}

	@Override
	public void keyPressed(KeyEvent event) {
		Integer keyCode = event.getKeyCode();
		if (controls.containsKey(keyCode)) {
			Direction direction = controls.get(event.getKeyCode());
			buffer.add(direction);

			if (buffer.size() > 2) {
				buffer.remove();
			}
		}
	}

}
