import java.awt.*;
import java.awt.event.*;
import javax.swing.JComponent;

public class GameBoard extends JComponent {
	private final int FPS = 90; 
	private Game game;
	private Keyboard keyboard;
	public GameBoard() {
		keyboard = new Keyboard();
		game = new Game(this);
	}
	
	@Override
	public Dimension getPreferredSize() {
		return new Dimension(800, 600);
	}

	@Override
	protected void paintComponent(Graphics arg0) {
		Color bg = new Color(25, 25, 25);
		super.paintComponent(arg0);
		Graphics2D graphics = (Graphics2D)arg0;
		graphics.setColor(bg);
		graphics.fillRect(0, 0, getWidth(), getHeight());
		
		game.draw(graphics);
	}
	
	@Override
	protected void processKeyEvent(KeyEvent e) {
		super.processKeyEvent(e);
		if (e.getID() == KeyEvent.KEY_PRESSED)
			keyboard.processKeyEvent(e.getKeyCode(), true);
		else if (e.getID() == KeyEvent.KEY_RELEASED)
			keyboard.processKeyEvent(e.getKeyCode(), false);
	}

	public void start() {
		while(true) {
			game.update(keyboard);
			try {
				Thread.sleep(1000 / FPS); //Throttle thread
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			this.repaint();
		}
	}
}
