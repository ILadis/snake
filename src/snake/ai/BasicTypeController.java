package snake.ai;

import snake.game.Controller;
import snake.game.Direction;
import snake.game.Point;
import snake.game.Snack;
import snake.game.Snake;

public interface BasicTypeController {
	String control(Integer headX, Integer headY, Integer snackX, Integer snackY);

	static class Adapter implements Controller {
		private BasicTypeController controller;

		public Adapter(BasicTypeController controller) {
			this.controller = controller;
		}

		@Override
		public void control(Snake snake, Snack snack) {
			Point headPosition = snake.head().position();
			Point snackPosition = snack.position();

			String control = controller.control(
					headPosition.x(), headPosition.y(),
					snackPosition.x(), snackPosition.y());

			Direction direction = Direction.valueOf(control);
			if (direction != null) {
				snake.direction(direction);
			}
		}
	}

}
