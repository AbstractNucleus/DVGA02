import java.awt.*;
import java.util.ArrayList;

public class Game {
	private Player player = new Player(400, 590, 60, 10, Color.cyan);
	private SquareCollection squareCollection = new SquareCollection(20, 6);
	private Ball ball = new Ball(400, 300, 20, 20);
	private ArrayList<Sprite> objects = new ArrayList<Sprite>();
	private int score = 0;
	ArrayList<Sprite> original_objects = new ArrayList<Sprite>(objects);


	public Game(GameBoard board) {
		concatObjects();
		for (Sprite obj: objects){
			original_objects.add(obj);
		}
	}

	public void update(Keyboard keyboard) {
		concatObjects();
		this.squareCollection.update(keyboard);
		this.player.update(keyboard);
		this.ball.new_update(keyboard, this.objects);
		this.score = this.original_objects.size() - this.objects.size();
		if (this.ball.getY() >= 600){
            System.out.println(this.score);
			System.exit(0);
        }
	}

	public void draw(Graphics2D graphics) {
		this.squareCollection.draw(graphics);
		this.player.draw(graphics);
		this.ball.draw(graphics);
	}

	public void concatObjects(){
		this.objects.clear();
		this.objects.add(this.player);
		for (ColoredBox square: this.squareCollection.getAllSquares()){
			if (square.getHits() < square.getHp()){
				this.objects.add(square);
			}
		}
	}
}
