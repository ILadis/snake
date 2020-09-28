package snake.ai;

import snake.game.Controller;
import snake.game.Direction;
import snake.game.Point;
import snake.game.Snack;
import snake.game.Snake;

public class SimpleController implements Controller {

	@Override
	public void control(Snake snake, Snack snack) {
		Point snakePosition = snake.head().position();
		Point snackPosition = snack.position();

		Point targetDirection = snackPosition.copy().minus(snakePosition);

		Double length = Math.sqrt(targetDirection.x() * targetDirection.x() + targetDirection.y() * targetDirection.y());

		Long x = Math.round(targetDirection.x() / length);
		Long y = Math.round(targetDirection.y() / length);

		Long closest = Long.MAX_VALUE;
		Direction newDir = null;

		for (Direction direction : Direction.values()) {
			Point vector = direction.toPoint();

			Long delta = Math.abs(vector.x() - x) + Math.abs(vector.y() - y);
			if (delta < closest) {
				newDir = direction;
				closest = delta;
			}
		}

		snake.direction(newDir);
	}

}
