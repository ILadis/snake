package snake.game;

import java.util.Iterator;

public class Part implements Touchable, Iterable<Part> {
	private Part parent, child;
	private Point position;

	public Part(Point position) {
		this.position = position;
	}

	private Part(Part parent) {
		this.position = parent.position.copy();
		this.parent = parent;
	}

	public Boolean isHead() {
		return parent == null;
	}

	public Boolean isTail() {
		return child == null;
	}

	@Override
	public Point position() {
		return position;
	}

	public void move(Direction direction) {
		if (isHead()) {
			position.add(direction.toPoint());
		} else {
			position.assign(parent.position);
			parent.move(direction);
		}
	}

	public Part append() {
		child = new Part(this);
		return child;
	}

	@Override
	public Iterator<Part> iterator() {
		if (isHead()) {
			return new HeadIterator(this);
		} else if (isTail()) {
			return new TailIterator(this);
		}

		throw new IllegalStateException();
	}

	static class HeadIterator implements Iterator<Part> {
		private Part current;

		private HeadIterator(Part head) {
			this.current = head;
		}

		@Override
		public boolean hasNext() {
			return current != null;
		}

		@Override
		public Part next() {
			Part next = current;
			current = next.child;
			return next;
		}
	}

	static class TailIterator implements Iterator<Part> {
		private Part current;

		private TailIterator(Part tail) {
			this.current = tail;
		}

		@Override
		public boolean hasNext() {
			return current != null;
		}

		@Override
		public Part next() {
			Part next = current;
			current = next.parent;
			return next;
		}
	}
}