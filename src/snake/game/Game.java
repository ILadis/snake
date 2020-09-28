package snake.game;

import java.util.Random;

public class Game {

	private Controller controller;
	private Random random;
	private Border border;
	private Snake snake;
	private Snack snack;
	private Timer velocity;
	private Boolean alive;

	public Game(Controller controller) {
		this.random = new Random();
		this.border = new Border(Point.of(20, 25));
		this.snake = new Snake(Point.of(1, 1));
		this.snack = new Snack(Point.of(1, 1));
		this.velocity = new Timer(0.2d);
		this.controller = controller;
		this.alive = true;
	}

	public Border border() {
		return border;
	}

	public Snake snake() {
		return snake;
	}

	public Snack food() {
		return snack;
	}

	public void setup() {
		snake.direction(Direction.RIGHT);

		Integer size = 5;
		while (size-- > 0) {
			snake.grow();
			snake.move();
		}

		relocateSnack();
	}

	public void step(Double dtime) {
		Integer steps = velocity.advance(dtime);
		while (alive && steps-- > 0) {
			controller.control(snake, snack);
			snake.move();
			checkFatality();
			checkSnack();
		}
	}

	private void checkFatality() {
		if (border.touches(snake.head()) || snake.touches(snake.head())) {
			alive = false;
		}
	}

	private void checkSnack() {
		if (snack.touches(snake.head())) {
			snake.grow(3);
			relocateSnack();
		}
	}

	private void relocateSnack() {
		Point position = Point.random(random, border.dimensions());
		snack.position().assign(position);

		if (snake.touches(snack)) {
			relocateSnack();
		}

		if (border.touches(snack)) {
			relocateSnack();
		}
	}

}
