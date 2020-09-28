package snake.game;

public interface Touchable {
	Point position();

	default Boolean touches(Touchable other) {
		return position().equals(other.position());
	}
}
