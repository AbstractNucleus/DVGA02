import java.awt.*;
import java.util.ArrayList;
import javax.swing.JTextField;

public class Game {
	private Player player = new Player(400, 590, 100, 10, Color.cyan);
	//private Player player = new Player(0, 590, 800, 10, Color.cyan);
	private SquareCollection squareCollection = new SquareCollection(10, 3);
	private ArrayList<Ball> balls = new ArrayList<Ball>();
	private ArrayList<Sprite> objects = new ArrayList<Sprite>();
	private Lives score_view = new Lives(700, 320, Color.blue, "Score: ");
	ArrayList<Sprite> original_objects = new ArrayList<Sprite>(objects);
	private int life = 1;
	private int lives = 3;
	private Lives life_view = new Lives(100, 320, Color.green, "Life: ");
	private Lives life_left_view = new Lives(100, 350, Color.red, "Lives left: ");
	private int latest_score_added, lost, won = 0;

	public Game(GameBoard board, Scoreboard scoreboard) {
		for (int i = 0; i < 4; i++){
			Ball ball = new Ball(400, 300, 20, 20);
			balls.add(ball);
		};
		concatObjects();
		for (Sprite obj: objects){
			original_objects.add(obj);
		}

		this.balls.get(life-1).setVisible(true);
	}

	public void update(Keyboard keyboard) {
		if (lost == 0 && won == 0){
			this.life_view.setLife(life);
			this.life_left_view.setLife(lives-life);

			concatObjects();
			this.squareCollection.update(keyboard);
			this.player.update(keyboard);


			Ball ball = this.balls.get(life-1);

			ball.new_update(keyboard, this.objects);
			if (ball.getY() >= 600){ball.setVisible(false); this.life += 1;}
			
			ball = this.balls.get(life-1);
			ball.setVisible(true);
			int temp = calcPoints();
			this.score_view.setLife(temp);
		}
	}
   
	public void draw(Graphics2D graphics, Scoreboard scoreboard) {
		if (life-1 == lives){
			if (lost == 0) {
				int points = calcPoints();
				graphics.setFont(new Font("Comic Sans MS", Font.PLAIN, 38)); 
				graphics.setColor(Color.red); 
				graphics.drawString("Game over with " + points + " points", 200, 300);

				if (latest_score_added == 0){
					scoreboard.latestScores.add(0, Integer.toString(points));
					latest_score_added = 1;
				}
				
				if (scoreboard.latestScores.size() > 3){
					scoreboard.latestScores.remove(3);
				}

				lost = 1;
				scoreboard.latestScores.writeFile();

				if (points > scoreboard.highScores.lowscore){
					HighscoreInput input = new HighscoreInput(scoreboard, points);
				}
			}
		}
		if (getBoxesLeft() == 0){
			if (won == 0){
				int points = calcPoints();
				graphics.setFont(new Font("Comic Sans MS", Font.PLAIN, 38)); 
				graphics.setColor(Color.green); 
				graphics.drawString("Game completed with " + points + " points", 200, 300);

				if (latest_score_added == 0){
					scoreboard.latestScores.add(0, Integer.toString(points));
					latest_score_added = 1;
				}

				if (scoreboard.latestScores.size() > 3){
					scoreboard.latestScores.remove(3);
				}

				won = 1;
				scoreboard.latestScores.writeFile();
				
				if (points > scoreboard.highScores.lowscore){
					HighscoreInput input = new HighscoreInput(scoreboard, points);
				}
			}
		
		}
		this.life_view.draw(graphics);
		this.life_left_view.draw(graphics);
		this.score_view.draw(graphics);
		this.squareCollection.draw(graphics);
		this.player.draw(graphics);
		this.balls.get(this.life-1).draw(graphics);
	}

	public void concatObjects(){
		this.objects.clear();
		this.objects.add(this.player);
		for (ColoredBox square: this.squareCollection.getAllSquares()){
			if (square.getVisible() == 1){
				this.objects.add(square);
			}
		}
	}

	public ArrayList<ColoredBox> getColoredBoxes(){
		ArrayList<ColoredBox> boxes = new ArrayList<ColoredBox>();
		for (ColoredBox square: this.squareCollection.getAllSquares()){
			if (square.getHits() >= square.getHp()){
				boxes.add(square);
			}
		}
		return boxes;
	}

	public int calcPoints(){
		int temp_score = 0;
		for (ColoredBox square: getColoredBoxes()){
			if (square.getVisible() == 0){
				temp_score += square.getPoints();
			}
		}
		return temp_score;
	}

	public int getBoxesLeft(){
		int i = this.squareCollection.getAllSquares().size();
		for (ColoredBox square: getColoredBoxes()){
			if (square.getVisible() == 0){
				i -= 1;
			}
		}
		return i;
	}
}
