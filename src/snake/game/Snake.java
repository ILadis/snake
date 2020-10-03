package snake.game;

public class Snake implements Touchable {
	private Part head, tail;
	private Direction direction;
	private Integer size;

	public Snake(Point position) {
		head = tail = new Part(position);
		size = 1;
	}

	public Part head() {
		return head;
	}

	public Part tail() {
		return tail;
	}

	@Override
	public Point position() {
		return head.position();
	}

	public void direction(Direction direction) {
		this.direction = direction;
	}

	public Direction direction() {
		return direction;
	}

	public void move() {
		tail.move(direction);
	}

	public void grow() {
		size++;
		tail = tail.append();
	}

	public void grow(Integer times) {
		while (times-- > 0) {
			grow();
		}
	}

	@Override
	public Boolean touches(Touchable other) {
		for (Part part : head) {
			if (part != other && part.touches(other)) {
				return true;
			}
		}

		return false;
	}
}
