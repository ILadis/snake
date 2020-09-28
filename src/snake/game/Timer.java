package snake.game;

public class Timer {
	private Double value, current;

	public Timer(Double value) {
		this.value = value;
		this.current = 0d;
	}

	public Integer advance(Double dtime) {
		current += dtime;

		Double steps = current / value;
		if (steps > 0) {
			current %= value;
		}

		return steps.intValue();
	}
}
