package snake.ai;

public class SimpleController implements BasicTypeController {

	@Override
	public String control(Integer headX, Integer headY, Integer snackX, Integer snackY) {
		Integer targetX = snackX - headX;
		Integer targetY = snackY - headY;

		Double length = Math.sqrt(targetX * targetX + targetY * targetY);

		Long x = Math.round(targetX / length);
		Long y = Math.round(targetY / length);

		return toDirection(x, y);
	}

	private String toDirection(Long x, Long y) {
		if (x == -1) {
			return "LEFT";
		} else if (x == 1) {
			return "RIGHT";
		} else if (y == -1) {
			return "UP";
		} else if (y == 1) {
			return "DOWN";
		} else {
			return "";
		}
	}
}
