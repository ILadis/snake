package snake.game;

public class Timer {
	private Double value, current;

	public Timer(Double value) {
		this.value = value;
		this.current = 0d;
	}

	public Double advance(Double dtime) {
		current += dtime;
		Double steps = current / value;
		return steps;
	}

	public void consume(Double steps) {
		current -= steps * value;
	}

	public void reset(Double value) {
		current = value;
	}
}
