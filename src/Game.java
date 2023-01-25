import java.awt.*;

public class Game {
	private int tickcount = 0;

	private Player player = new Player(400, 300, 20, 20, Color.cyan);
	private SquareCollection squareCollection = new SquareCollection(10);

	public Game(GameBoard board) {
	}

	public void update(Keyboard keyboard) {
		this.squareCollection.update(keyboard, tickcount);
		this.player.update(keyboard);

		this.tickcount++;
	}

	public void draw(Graphics2D graphics) {
		this.squareCollection.draw(graphics);
		this.player.draw(graphics);
	}
}
